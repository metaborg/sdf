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

@SuppressWarnings("all") public class template_production_to_sdf_0_0 extends Strategy 
{ 
  public static template_production_to_sdf_0_0 instance = new template_production_to_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_production_to_sdf_0_0");
    Fail907:
    { 
      IStrategoTerm term351 = term;
      Success319:
      { 
        Fail908:
        { 
          IStrategoTerm d_32756 = null;
          TermReference e_32756 = new TermReference();
          TermReference f_32756 = new TermReference();
          TermReference g_32756 = new TermReference();
          TermReference h_32756 = new TermReference();
          IStrategoTerm i_32756 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail908;
          IStrategoTerm arg255 = term.getSubterm(0);
          if(arg255.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg255).getConstructor())
            break Fail908;
          d_32756 = arg255.getSubterm(0);
          if(e_32756.value == null)
            e_32756.value = arg255.getSubterm(1);
          else
            if(e_32756.value != arg255.getSubterm(1) && !e_32756.value.match(arg255.getSubterm(1)))
              break Fail908;
          if(g_32756.value == null)
            g_32756.value = arg255.getSubterm(2);
          else
            if(g_32756.value != arg255.getSubterm(2) && !g_32756.value.match(arg255.getSubterm(2)))
              break Fail908;
          i_32756 = term;
          lifted269 lifted2690 = new lifted269();
          lifted2690.e_32756 = e_32756;
          lifted2690.f_32756 = f_32756;
          lifted2690.g_32756 = g_32756;
          lifted2690.h_32756 = h_32756;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2690);
          if(term == null)
            break Fail908;
          term = i_32756;
          if(f_32756.value == null || h_32756.value == null)
            break Fail908;
          term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{f_32756.value, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{d_32756}), h_32756.value});
          if(true)
            break Success319;
        }
        term = term351;
        IStrategoTerm c_32756 = null;
        c_32756 = term;
        term = templatelang_not_desugared_0_1.instance.invoke(context, c_32756, generated.const192);
        if(term == null)
          break Fail907;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}