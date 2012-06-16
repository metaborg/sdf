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

@SuppressWarnings("all") public class templatelang_declare_section_0_0 extends Strategy 
{ 
  public static templatelang_declare_section_0_0 instance = new templatelang_declare_section_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_declare_section_0_0");
    Fail288:
    { 
      IStrategoTerm term285 = term;
      Success210:
      { 
        Fail289:
        { 
          TermReference b_9740 = new TermReference();
          IStrategoTerm c_9740 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail289;
          if(b_9740.value == null)
            b_9740.value = term.getSubterm(0);
          else
            if(b_9740.value != term.getSubterm(0) && !b_9740.value.match(term.getSubterm(0)))
              break Fail289;
          c_9740 = term;
          lifted211 lifted2110 = new lifted211();
          lifted2110.b_9740 = b_9740;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2110);
          if(term == null)
            break Fail289;
          term = c_9740;
          if(true)
            break Success210;
        }
        term = term285;
        TermReference w_9739 = new TermReference();
        IStrategoTerm x_9739 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateOptions_1 != ((IStrategoAppl)term).getConstructor())
          break Fail288;
        if(w_9739.value == null)
          w_9739.value = term.getSubterm(0);
        else
          if(w_9739.value != term.getSubterm(0) && !w_9739.value.match(term.getSubterm(0)))
            break Fail288;
        x_9739 = term;
        lifted213 lifted2130 = new lifted213();
        lifted2130.w_9739 = w_9739;
        term = with_spxverify_1_0.instance.invoke(context, term, lifted2130);
        if(term == null)
          break Fail288;
        term = x_9739;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}