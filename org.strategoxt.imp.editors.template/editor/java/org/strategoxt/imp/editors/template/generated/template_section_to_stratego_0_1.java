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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm ref_r_32808)
  { 
    ITermFactory termFactory = context.getFactory();
    TermReference r_32808 = new TermReference(ref_r_32808);
    context.push("template_section_to_stratego_0_1");
    Fail834:
    { 
      IStrategoTerm term269 = term;
      Success267:
      { 
        Fail835:
        { 
          TermReference e_32744 = new TermReference();
          TermReference f_32744 = new TermReference();
          TermReference g_32744 = new TermReference();
          IStrategoTerm h_32744 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail835;
          if(f_32744.value == null)
            f_32744.value = term.getSubterm(0);
          else
            if(f_32744.value != term.getSubterm(0) && !f_32744.value.match(term.getSubterm(0)))
              break Fail835;
          h_32744 = term;
          lifted206 lifted2060 = new lifted206();
          lifted2060.e_32744 = e_32744;
          lifted2060.f_32744 = f_32744;
          lifted2060.r_32808 = r_32808;
          lifted2060.g_32744 = g_32744;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted2060, lifted209.instance);
          if(term == null)
            break Fail835;
          term = h_32744;
          if(e_32744.value == null || g_32744.value == null)
            break Fail835;
          term = termFactory.makeTuple(e_32744.value, termFactory.annotateTerm(g_32744.value, checkListAnnos(termFactory, generated.constNil3)));
          term = make$Conc_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail835;
          term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{term});
          if(true)
            break Success267;
        }
        term = term269;
        TermReference w_32743 = new TermReference();
        TermReference x_32743 = new TermReference();
        TermReference y_32743 = new TermReference();
        TermReference z_32743 = new TermReference();
        IStrategoTerm a_32744 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
          break Fail834;
        IStrategoTerm arg161 = term.getSubterm(0);
        if(arg161.getTermType() != IStrategoTerm.APPL || Main._conslexical_syntax_1 != ((IStrategoAppl)arg161).getConstructor())
          break Fail834;
        if(w_32743.value == null)
          w_32743.value = arg161.getSubterm(0);
        else
          if(w_32743.value != arg161.getSubterm(0) && !w_32743.value.match(arg161.getSubterm(0)))
            break Fail834;
        a_32744 = term;
        lifted210 lifted2100 = new lifted210();
        lifted2100.w_32743 = w_32743;
        lifted2100.x_32743 = x_32743;
        lifted2100.y_32743 = y_32743;
        lifted2100.r_32808 = r_32808;
        lifted2100.z_32743 = z_32743;
        term = with_spxverify_2_0.instance.invoke(context, term, lifted2100, lifted214.instance);
        if(term == null)
          break Fail834;
        term = a_32744;
        if(x_32743.value == null || z_32743.value == null)
          break Fail834;
        term = termFactory.makeTuple(x_32743.value, termFactory.annotateTerm(z_32743.value, checkListAnnos(termFactory, generated.constNil3)));
        term = make$Conc_0_0.instance.invoke(context, term);
        if(term == null)
          break Fail834;
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