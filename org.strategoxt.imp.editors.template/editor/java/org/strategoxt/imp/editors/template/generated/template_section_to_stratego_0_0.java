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

@SuppressWarnings("all") public class template_section_to_stratego_0_0 extends Strategy 
{ 
  public static template_section_to_stratego_0_0 instance = new template_section_to_stratego_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_section_to_stratego_0_0");
    Fail17:
    { 
      IStrategoTerm term15 = term;
      Success13:
      { 
        Fail18:
        { 
          TermReference g_9706 = new TermReference();
          TermReference h_9706 = new TermReference();
          IStrategoTerm i_9706 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail18;
          if(g_9706.value == null)
            g_9706.value = term.getSubterm(0);
          else
            if(g_9706.value != term.getSubterm(0) && !g_9706.value.match(term.getSubterm(0)))
              break Fail18;
          i_9706 = term;
          lifted16 lifted1610 = new lifted16();
          lifted1610.g_9706 = g_9706;
          lifted1610.h_9706 = h_9706;
          term = with_spxverify_2_0.instance.invoke(context, term, lifted1610, lifted18.instance);
          if(term == null)
            break Fail18;
          term = i_9706;
          if(h_9706.value == null)
            break Fail18;
          term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{h_9706.value});
          if(true)
            break Success13;
        }
        term = term15;
        TermReference c_9706 = new TermReference();
        TermReference d_9706 = new TermReference();
        TermReference e_9706 = new TermReference();
        IStrategoTerm f_9706 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
          break Fail17;
        IStrategoTerm arg14 = term.getSubterm(0);
        if(arg14.getTermType() != IStrategoTerm.APPL || Main._conslexical_syntax_1 != ((IStrategoAppl)arg14).getConstructor())
          break Fail17;
        if(c_9706.value == null)
          c_9706.value = arg14.getSubterm(0);
        else
          if(c_9706.value != arg14.getSubterm(0) && !c_9706.value.match(arg14.getSubterm(0)))
            break Fail17;
        f_9706 = term;
        lifted19 lifted1910 = new lifted19();
        lifted1910.c_9706 = c_9706;
        lifted1910.d_9706 = d_9706;
        lifted1910.e_9706 = e_9706;
        term = with_spxverify_2_0.instance.invoke(context, term, lifted1910, lifted22.instance);
        if(term == null)
          break Fail17;
        term = f_9706;
        if(e_9706.value == null)
          break Fail17;
        term = termFactory.makeAppl(Main._consStrategies_1, new IStrategoTerm[]{e_9706.value});
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}