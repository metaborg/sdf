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

@SuppressWarnings("all") final class lifted187 extends Strategy 
{ 
  public static final lifted187 instance = new lifted187();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail816:
    { 
      term = try_1_0.instance.invoke(context, term, lifted188.instance);
      if(term == null)
        break Fail816;
      IStrategoTerm term252 = term;
      Success354:
      { 
        Fail817:
        { 
          if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
            break Fail817;
          IStrategoTerm arg362 = term.getSubterm(0);
          if(arg362.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg362).isEmpty())
            break Fail817;
          IStrategoTerm arg363 = ((IStrategoList)arg362).head();
          if(arg363.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg363).getConstructor())
            break Fail817;
          if(true)
            break Success354;
        }
        term = $Line_1_0.instance.invoke(context, term252, lifted191.instance);
        if(term == null)
          break Fail816;
      }
      if(true)
        return term;
    }
    return null;
  }
}