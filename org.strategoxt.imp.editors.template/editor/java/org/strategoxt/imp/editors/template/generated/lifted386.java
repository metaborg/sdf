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

@SuppressWarnings("all") final class lifted386 extends Strategy 
{ 
  public static final lifted386 instance = new lifted386();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1636:
    { 
      term = try_1_0.instance.invoke(context, term, lifted387.instance);
      if(term == null)
        break Fail1636;
      IStrategoTerm term508 = term;
      Success610:
      { 
        Fail1637:
        { 
          if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1637;
          IStrategoTerm arg515 = term.getSubterm(0);
          if(arg515.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg515).isEmpty())
            break Fail1637;
          IStrategoTerm arg516 = ((IStrategoList)arg515).head();
          if(arg516.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg516).getConstructor())
            break Fail1637;
          if(true)
            break Success610;
        }
        term = $Line_1_0.instance.invoke(context, term508, lifted390.instance);
        if(term == null)
          break Fail1636;
      }
      if(true)
        return term;
    }
    return null;
  }
}