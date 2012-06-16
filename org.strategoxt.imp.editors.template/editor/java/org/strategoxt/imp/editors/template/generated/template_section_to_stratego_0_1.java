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

@SuppressWarnings("all") public class template_section_to_stratego_0_1 extends Strategy 
{ 
  public static template_section_to_stratego_0_1 instance = new template_section_to_stratego_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm ref_i_9770)
  { 
    ITermFactory termFactory = context.getFactory();
    TermReference i_9770 = new TermReference(ref_i_9770);
    context.push("template_section_to_stratego_0_1");
    Fail15:
    { 
      IStrategoTerm term14 = term;
      Success12:
      { 
        Fail16:
        { 
          TermReference w_9705 = new TermReference();
          TermReference x_9705 = new TermReference();
          TermReference y_9705 = new TermReference();
          IStrategoTerm z_9705 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail16;
          if(x_9705.value == null)
            x_9705.value = term.getSubterm(0);
          else
            if(x_9705.value != term.getSubterm(0) && !x_9705.value.match(term.getSubterm(0)))
              break Fail16;
          z_9705 = term;
          lifted7 lifted710 = new lifted7();
          lifted710.w_9705 = w_9705;
          lifted710.x_9705 = x_9705;
          lifted710.i_9770 = i_9770;
          lifted710.y_9705 = y_9705;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted710, lifted10.instance);
          if(term == null)
            break Fail16;
          term = z_9705;
          if(w_9705.value == null || y_9705.value == null)
            break Fail16;
          term = termFactory.makeTuple(w_9705.value, termFactory.annotateTerm(y_9705.value, checkListAnnos(termFactory, generated.constNil0)));
          term = make$Conc_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail16;
          term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{term});
          if(true)
            break Success12;
        }
        term = term14;
        TermReference o_9705 = new TermReference();
        TermReference p_9705 = new TermReference();
        TermReference q_9705 = new TermReference();
        TermReference r_9705 = new TermReference();
        IStrategoTerm s_9705 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
          break Fail15;
        IStrategoTerm arg13 = term.getSubterm(0);
        if(arg13.getTermType() != IStrategoTerm.APPL || Main._conslexical_syntax_1 != ((IStrategoAppl)arg13).getConstructor())
          break Fail15;
        if(o_9705.value == null)
          o_9705.value = arg13.getSubterm(0);
        else
          if(o_9705.value != arg13.getSubterm(0) && !o_9705.value.match(arg13.getSubterm(0)))
            break Fail15;
        s_9705 = term;
        lifted11 lifted1110 = new lifted11();
        lifted1110.o_9705 = o_9705;
        lifted1110.p_9705 = p_9705;
        lifted1110.q_9705 = q_9705;
        lifted1110.i_9770 = i_9770;
        lifted1110.r_9705 = r_9705;
        term = with_spxverify_2_0.instance.invoke(context, term, lifted1110, lifted15.instance);
        if(term == null)
          break Fail15;
        term = s_9705;
        if(p_9705.value == null || r_9705.value == null)
          break Fail15;
        term = termFactory.makeTuple(p_9705.value, termFactory.annotateTerm(r_9705.value, checkListAnnos(termFactory, generated.constNil0)));
        term = make$Conc_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail15;
        term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{term});
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}