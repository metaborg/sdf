package org.strategoxt.imp.editors.template.generated;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_lib.*;
import org.strategoxt.stratego_sglr.*;
import org.strategoxt.stratego_gpp.*;
import org.strategoxt.stratego_xtc.*;
import org.strategoxt.stratego_aterm.*;
import org.strategoxt.stratego_sdf.*;
import org.strategoxt.strc.*;
import org.strategoxt.imp.editors.template.generated.*;
import org.strategoxt.java_front.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") final class lifted184 extends Strategy 
{ 
  public static final lifted184 instance = new lifted184();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail824:
    { 
      IStrategoTerm h_9946 = null;
      IStrategoTerm i_9946 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail824;
      i_9946 = ((IStrategoList)term).head();
      h_9946 = ((IStrategoList)term).tail();
      term = i_9946;
      IStrategoTerm term251 = term;
      IStrategoConstructor cons50 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success355:
      { 
        if(cons50 == Main._consLine_1)
        { 
          Fail825:
          { 
            IStrategoTerm arg353 = term.getSubterm(0);
            if(arg353.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg353).isEmpty())
              break Fail825;
            if(true)
              break Success355;
          }
          term = term251;
        }
        if(cons50 == Main._consLine_1)
        { 
          IStrategoTerm arg354 = term.getSubterm(0);
          if(arg354.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg354).isEmpty())
            break Fail824;
          IStrategoTerm arg355 = ((IStrategoList)arg354).head();
          if(arg355.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg355).getConstructor())
            break Fail824;
          IStrategoTerm arg357 = ((IStrategoList)arg354).tail();
          if(arg357.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg357).isEmpty())
            break Fail824;
        }
        else
        { 
          break Fail824;
        }
      }
      term = h_9946;
      if(true)
        return term;
    }
    return null;
  }
}