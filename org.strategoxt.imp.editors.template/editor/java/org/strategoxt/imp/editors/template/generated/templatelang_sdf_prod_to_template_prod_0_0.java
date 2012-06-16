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
    Fail181:
    { 
      IStrategoTerm term183 = term;
      Success131:
      { 
        Fail182:
        { 
          IStrategoTerm f_9727 = null;
          IStrategoTerm g_9727 = null;
          IStrategoTerm h_9727 = null;
          IStrategoTerm i_9727 = null;
          IStrategoTerm m_9727 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consprod_3 != ((IStrategoAppl)term).getConstructor())
            break Fail182;
          g_9727 = term.getSubterm(0);
          IStrategoTerm arg234 = term.getSubterm(1);
          if(arg234.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg234).getConstructor())
            break Fail182;
          f_9727 = arg234.getSubterm(0);
          i_9727 = term.getSubterm(2);
          term = map_1_0.instance.invoke(context, g_9727, templatelang_sdf_sym_to_template_elem_0_0.instance);
          if(term == null)
            break Fail182;
          m_9727 = term;
          term = separate_by_0_1.instance.invoke(context, m_9727, generated.constLayout1);
          if(term == null)
            break Fail182;
          h_9727 = term;
          term = templatelang_get_attrs_0_0.instance.invoke(context, i_9727);
          if(term == null)
            break Fail182;
          term = termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{term});
          term = termFactory.makeAppl(Main._consDesugared_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{f_9727, termFactory.makeAppl(Main._consSingleLineTemplate_1, new IStrategoTerm[]{h_9727}), term})});
          if(true)
            break Success131;
        }
        term = debug_1_0.instance.invoke(context, term183, lifted144.instance);
        if(term == null)
          break Fail181;
        if(true)
          break Fail181;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}