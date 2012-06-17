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
    Fail1108:
    { 
      IStrategoTerm term541 = term;
      Success466:
      { 
        Fail1109:
        { 
          TermReference k_32778 = new TermReference();
          IStrategoTerm l_32778 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateSection_1 != ((IStrategoAppl)term).getConstructor())
            break Fail1109;
          if(k_32778.value == null)
            k_32778.value = term.getSubterm(0);
          else
            if(k_32778.value != term.getSubterm(0) && !k_32778.value.match(term.getSubterm(0)))
              break Fail1109;
          l_32778 = term;
          lifted410 lifted4100 = new lifted410();
          lifted4100.k_32778 = k_32778;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted4100);
          if(term == null)
            break Fail1109;
          term = l_32778;
          if(true)
            break Success466;
        }
        term = term541;
        TermReference f_32778 = new TermReference();
        IStrategoTerm g_32778 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateOptions_1 != ((IStrategoAppl)term).getConstructor())
          break Fail1108;
        if(f_32778.value == null)
          f_32778.value = term.getSubterm(0);
        else
          if(f_32778.value != term.getSubterm(0) && !f_32778.value.match(term.getSubterm(0)))
            break Fail1108;
        g_32778 = term;
        lifted412 lifted4120 = new lifted412();
        lifted4120.f_32778 = f_32778;
        term = with_spxverify_1_0.instance.invoke(context, term, lifted4120);
        if(term == null)
          break Fail1108;
        term = g_32778;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}