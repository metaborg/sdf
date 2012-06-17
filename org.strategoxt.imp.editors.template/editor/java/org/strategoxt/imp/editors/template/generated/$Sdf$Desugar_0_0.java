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
    Fail1165:
    { 
      IStrategoTerm term612 = term;
      IStrategoConstructor cons46 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success506:
      { 
        if(cons46 == Main._consno_attrs_0)
        { 
          Fail1166:
          { 
            term = generated.constattrs0;
            if(true)
              break Success506;
          }
          term = term612;
        }
        if(cons46 == Main._consterm_1)
        { 
          IStrategoTerm l_32782 = null;
          IStrategoTerm arg712 = term.getSubterm(0);
          if(arg712.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg712).getConstructor())
            break Fail1165;
          l_32782 = arg712.getSubterm(0);
          term = termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{l_32782});
        }
        else
        { 
          break Fail1165;
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