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

@SuppressWarnings("all") public class templatelang_prod_to_sort_0_0 extends Strategy 
{ 
  public static templatelang_prod_to_sort_0_0 instance = new templatelang_prod_to_sort_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_prod_to_sort_0_0");
    Fail1105:
    { 
      IStrategoTerm term539 = term;
      IStrategoConstructor cons36 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success464:
      { 
        if(cons36 == Main._consprod_3)
        { 
          Fail1106:
          { 
            IStrategoTerm e_32778 = null;
            IStrategoTerm arg593 = term.getSubterm(1);
            if(arg593.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg593).getConstructor())
              break Fail1106;
            e_32778 = arg593.getSubterm(0);
            term = e_32778;
            if(true)
              break Success464;
          }
          term = term539;
        }
        Success465:
        { 
          if(cons36 == Main._consDesugared_1)
          { 
            Fail1107:
            { 
              IStrategoTerm d_32778 = null;
              IStrategoTerm arg595 = term.getSubterm(0);
              if(arg595.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg595).getConstructor())
                break Fail1107;
              d_32778 = arg595.getSubterm(0);
              term = d_32778;
              if(true)
                break Success465;
            }
            term = term539;
          }
          IStrategoTerm c_32778 = null;
          c_32778 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, c_32778, generated.const234);
          if(term == null)
            break Fail1105;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}