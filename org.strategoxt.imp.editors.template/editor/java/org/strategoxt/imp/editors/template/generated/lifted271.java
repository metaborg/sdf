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

@SuppressWarnings("all") final class lifted271 extends Strategy 
{ 
  public static final lifted271 instance = new lifted271();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1749:
    { 
      IStrategoTerm term353 = term;
      Success633:
      { 
        Fail1750:
        { 
          if(term.getTermType() != IStrategoTerm.APPL || Main._consterm_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1750;
          IStrategoTerm arg256 = term.getSubterm(0);
          if(arg256.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg256).getConstructor())
            break Fail1750;
          IStrategoTerm arg257 = arg256.getSubterm(0);
          if(arg257.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg257).getConstructor())
            break Fail1750;
          IStrategoTerm arg258 = arg257.getSubterm(0);
          if(arg258.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg258).getConstructor())
            break Fail1750;
          IStrategoTerm arg259 = arg258.getSubterm(0);
          if(arg259.getTermType() != IStrategoTerm.STRING || !"completion".equals(((IStrategoString)arg259).stringValue()))
            break Fail1750;
          IStrategoTerm arg260 = arg257.getSubterm(1);
          if(arg260.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg260).isEmpty())
            break Fail1750;
          IStrategoTerm arg262 = ((IStrategoList)arg260).tail();
          if(arg262.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg262).isEmpty())
            break Fail1750;
          { 
            if(true)
              break Fail1749;
            if(true)
              break Success633;
          }
        }
        term = term353;
      }
      if(true)
        return term;
    }
    return null;
  }
}