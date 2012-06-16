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

@SuppressWarnings("all") public class p_9735 extends Strategy 
{ 
  public static p_9735 instance = new p_9735();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail263:
    { 
      IStrategoTerm term247 = term;
      IStrategoConstructor cons20 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success193:
      { 
        if(cons20 == Main._consLine_1)
        { 
          Fail264:
          { 
            IStrategoTerm arg343 = term.getSubterm(0);
            if(arg343.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg343).isEmpty())
              break Fail264;
            if(true)
              break Success193;
          }
          term = term247;
        }
        if(cons20 == Main._consLine_1)
        { 
          IStrategoTerm arg344 = term.getSubterm(0);
          if(arg344.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg344).isEmpty())
            break Fail263;
          IStrategoTerm arg345 = ((IStrategoList)arg344).head();
          if(arg345.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg345).getConstructor())
            break Fail263;
          IStrategoTerm arg347 = ((IStrategoList)arg344).tail();
          if(arg347.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg347).isEmpty())
            break Fail263;
        }
        else
        { 
          break Fail263;
        }
      }
      if(true)
        return term;
    }
    context.push("p_9735");
    context.popOnFailure();
    return null;
  }
}