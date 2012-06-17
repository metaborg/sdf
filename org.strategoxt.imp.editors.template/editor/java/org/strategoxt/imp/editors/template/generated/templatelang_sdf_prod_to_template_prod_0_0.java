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

@SuppressWarnings("all") public class templatelang_sdf_prod_to_template_prod_0_0 extends Strategy 
{ 
  public static templatelang_sdf_prod_to_template_prod_0_0 instance = new templatelang_sdf_prod_to_template_prod_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_sdf_prod_to_template_prod_0_0");
    Fail1001:
    { 
      IStrategoTerm term439 = term;
      Success387:
      { 
        Fail1002:
        { 
          IStrategoTerm o_32765 = null;
          IStrategoTerm p_32765 = null;
          IStrategoTerm q_32765 = null;
          IStrategoTerm r_32765 = null;
          IStrategoTerm v_32765 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consprod_3 != ((IStrategoAppl)term).getConstructor())
            break Fail1002;
          p_32765 = term.getSubterm(0);
          IStrategoTerm arg387 = term.getSubterm(1);
          if(arg387.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg387).getConstructor())
            break Fail1002;
          o_32765 = arg387.getSubterm(0);
          r_32765 = term.getSubterm(2);
          term = map_1_0.instance.invoke(context, p_32765, templatelang_sdf_sym_to_template_elem_0_0.instance);
          if(term == null)
            break Fail1002;
          v_32765 = term;
          term = separate_by_0_1.instance.invoke(context, v_32765, generated.constLayout1);
          if(term == null)
            break Fail1002;
          q_32765 = term;
          term = templatelang_get_attrs_0_0.instance.invoke(context, r_32765);
          if(term == null)
            break Fail1002;
          term = termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{term});
          term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{o_32765, termFactory.makeAppl(Main._consSingleLineTemplate_1, new IStrategoTerm[]{q_32765}), term})});
          if(true)
            break Success387;
        }
        term = debug_1_0.instance.invoke(context, term439, lifted343.instance);
        if(term == null)
          break Fail1001;
        if(true)
          break Fail1001;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}