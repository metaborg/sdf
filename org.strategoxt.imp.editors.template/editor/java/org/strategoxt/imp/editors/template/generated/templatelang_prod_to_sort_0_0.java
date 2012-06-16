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
    Fail285:
    { 
      IStrategoTerm term283 = term;
      IStrategoConstructor cons24 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success208:
      { 
        if(cons24 == Main._consprod_3)
        { 
          Fail286:
          { 
            IStrategoTerm v_9739 = null;
            IStrategoTerm arg440 = term.getSubterm(1);
            if(arg440.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg440).getConstructor())
              break Fail286;
            v_9739 = arg440.getSubterm(0);
            term = v_9739;
            if(true)
              break Success208;
          }
          term = term283;
        }
        Success209:
        { 
          if(cons24 == Main._consDesugared_1)
          { 
            Fail287:
            { 
              IStrategoTerm u_9739 = null;
              IStrategoTerm arg442 = term.getSubterm(0);
              if(arg442.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg442).getConstructor())
                break Fail287;
              u_9739 = arg442.getSubterm(0);
              term = u_9739;
              if(true)
                break Success209;
            }
            term = term283;
          }
          IStrategoTerm t_9739 = null;
          t_9739 = term;
          term = templatelang_not_desugared_0_1.instance.invoke(context, t_9739, generated.const113);
          if(term == null)
            break Fail285;
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