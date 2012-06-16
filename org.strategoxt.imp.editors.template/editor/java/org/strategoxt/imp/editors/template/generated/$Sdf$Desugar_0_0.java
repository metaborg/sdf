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

@SuppressWarnings("all") public class $Sdf$Desugar_0_0 extends Strategy 
{ 
  public static $Sdf$Desugar_0_0 instance = new $Sdf$Desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail345:
    { 
      IStrategoTerm term356 = term;
      IStrategoConstructor cons34 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success250:
      { 
        if(cons34 == Main._consno_attrs_0)
        { 
          Fail346:
          { 
            term = generated.constattrs0;
            if(true)
              break Success250;
          }
          term = term356;
        }
        if(cons34 == Main._consterm_1)
        { 
          IStrategoTerm c_9744 = null;
          IStrategoTerm arg559 = term.getSubterm(0);
          if(arg559.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg559).getConstructor())
            break Fail345;
          c_9744 = arg559.getSubterm(0);
          term = termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{c_9744});
        }
        else
        { 
          break Fail345;
        }
      }
      if(true)
        return term;
    }
    context.push("SdfDesugar_0_0");
    context.popOnFailure();
    return null;
  }
}