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
    Fail88:
    { 
      IStrategoTerm term96 = term;
      Success64:
      { 
        Fail89:
        { 
          IStrategoTerm v_9717 = null;
          TermReference w_9717 = new TermReference();
          TermReference x_9717 = new TermReference();
          TermReference y_9717 = new TermReference();
          TermReference z_9717 = new TermReference();
          IStrategoTerm a_9718 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail89;
          IStrategoTerm arg107 = term.getSubterm(0);
          if(arg107.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg107).getConstructor())
            break Fail89;
          v_9717 = arg107.getSubterm(0);
          if(w_9717.value == null)
            w_9717.value = arg107.getSubterm(1);
          else
            if(w_9717.value != arg107.getSubterm(1) && !w_9717.value.match(arg107.getSubterm(1)))
              break Fail89;
          if(y_9717.value == null)
            y_9717.value = arg107.getSubterm(2);
          else
            if(y_9717.value != arg107.getSubterm(2) && !y_9717.value.match(arg107.getSubterm(2)))
              break Fail89;
          a_9718 = term;
          lifted70 lifted700 = new lifted70();
          lifted700.w_9717 = w_9717;
          lifted700.x_9717 = x_9717;
          lifted700.y_9717 = y_9717;
          lifted700.z_9717 = z_9717;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted700);
          if(term == null)
            break Fail89;
          term = a_9718;
          if(x_9717.value == null || z_9717.value == null)
            break Fail89;
          term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{x_9717.value, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{v_9717}), z_9717.value});
          if(true)
            break Success64;
        }
        term = term96;
        IStrategoTerm u_9717 = null;
        u_9717 = term;
        term = templatelang_not_desugared_0_1.instance.invoke(context, u_9717, generated.const71);
        if(term == null)
          break Fail88;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}