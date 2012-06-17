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

@SuppressWarnings("all") public class template_production_to_sdf_no_attrs_0_0 extends Strategy 
{ 
  public static template_production_to_sdf_no_attrs_0_0 instance = new template_production_to_sdf_no_attrs_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_production_to_sdf_no_attrs_0_0");
    Fail905:
    { 
      IStrategoTerm term350 = term;
      Success318:
      { 
        Fail906:
        { 
          IStrategoTerm x_32755 = null;
          TermReference y_32755 = new TermReference();
          TermReference z_32755 = new TermReference();
          IStrategoTerm a_32756 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail906;
          IStrategoTerm arg253 = term.getSubterm(0);
          if(arg253.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg253).getConstructor())
            break Fail906;
          x_32755 = arg253.getSubterm(0);
          if(y_32755.value == null)
            y_32755.value = arg253.getSubterm(1);
          else
            if(y_32755.value != arg253.getSubterm(1) && !y_32755.value.match(arg253.getSubterm(1)))
              break Fail906;
          a_32756 = term;
          lifted268 lifted2680 = new lifted268();
          lifted2680.y_32755 = y_32755;
          lifted2680.z_32755 = z_32755;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2680);
          if(term == null)
            break Fail906;
          term = a_32756;
          if(z_32755.value == null)
            break Fail906;
          term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{z_32755.value, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{x_32755}), generated.constno_attrs0});
          if(true)
            break Success318;
        }
        term = term350;
        IStrategoTerm w_32755 = null;
        w_32755 = term;
        term = templatelang_not_desugared_0_1.instance.invoke(context, w_32755, generated.const191);
        if(term == null)
          break Fail905;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}