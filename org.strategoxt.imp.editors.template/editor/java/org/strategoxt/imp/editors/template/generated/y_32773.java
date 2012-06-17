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

@SuppressWarnings("all") public class y_32773 extends Strategy 
{ 
  public static y_32773 instance = new y_32773();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1083:
    { 
      IStrategoTerm term503 = term;
      IStrategoConstructor cons32 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success449:
      { 
        if(cons32 == Main._consLine_1)
        { 
          Fail1084:
          { 
            IStrategoTerm arg496 = term.getSubterm(0);
            if(arg496.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg496).isEmpty())
              break Fail1084;
            if(true)
              break Success449;
          }
          term = term503;
        }
        if(cons32 == Main._consLine_1)
        { 
          IStrategoTerm arg497 = term.getSubterm(0);
          if(arg497.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg497).isEmpty())
            break Fail1083;
          IStrategoTerm arg498 = ((IStrategoList)arg497).head();
          if(arg498.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg498).getConstructor())
            break Fail1083;
          IStrategoTerm arg500 = ((IStrategoList)arg497).tail();
          if(arg500.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg500).isEmpty())
            break Fail1083;
        }
        else
        { 
          break Fail1083;
        }
      }
      if(true)
        return term;
    }
    context.push("y_32773");
    context.popOnFailure();
    return null;
  }
}