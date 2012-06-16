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
    Fail86:
    { 
      IStrategoTerm term95 = term;
      Success63:
      { 
        Fail87:
        { 
          IStrategoTerm p_9717 = null;
          TermReference q_9717 = new TermReference();
          TermReference r_9717 = new TermReference();
          IStrategoTerm s_9717 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail87;
          IStrategoTerm arg105 = term.getSubterm(0);
          if(arg105.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg105).getConstructor())
            break Fail87;
          p_9717 = arg105.getSubterm(0);
          if(q_9717.value == null)
            q_9717.value = arg105.getSubterm(1);
          else
            if(q_9717.value != arg105.getSubterm(1) && !q_9717.value.match(arg105.getSubterm(1)))
              break Fail87;
          s_9717 = term;
          lifted69 lifted690 = new lifted69();
          lifted690.q_9717 = q_9717;
          lifted690.r_9717 = r_9717;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted690);
          if(term == null)
            break Fail87;
          term = s_9717;
          if(r_9717.value == null)
            break Fail87;
          term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{r_9717.value, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{p_9717}), generated.constno_attrs0});
          if(true)
            break Success63;
        }
        term = term95;
        IStrategoTerm o_9717 = null;
        o_9717 = term;
        term = templatelang_not_desugared_0_1.instance.invoke(context, o_9717, generated.const70);
        if(term == null)
          break Fail86;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}