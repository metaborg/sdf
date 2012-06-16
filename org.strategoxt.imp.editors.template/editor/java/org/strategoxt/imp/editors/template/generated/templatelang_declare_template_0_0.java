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

@SuppressWarnings("all") public class templatelang_declare_template_0_0 extends Strategy 
{ 
  public static templatelang_declare_template_0_0 instance = new templatelang_declare_template_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_declare_template_0_0");
    Fail290:
    { 
      IStrategoTerm term286 = term;
      Success211:
      { 
        Fail291:
        { 
          TermReference h_9740 = new TermReference();
          TermReference i_9740 = new TermReference();
          TermReference j_9740 = new TermReference();
          TermReference k_9740 = new TermReference();
          TermReference l_9740 = new TermReference();
          IStrategoTerm n_9740 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consDesugared_1 != ((IStrategoAppl)term).getConstructor())
            break Fail291;
          IStrategoTerm arg445 = term.getSubterm(0);
          if(l_9740.value == null)
            l_9740.value = arg445;
          else
            if(l_9740.value != arg445 && !l_9740.value.match(arg445))
              break Fail291;
          if(arg445.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)arg445).getConstructor())
            break Fail291;
          if(i_9740.value == null)
            i_9740.value = arg445.getSubterm(0);
          else
            if(i_9740.value != arg445.getSubterm(0) && !i_9740.value.match(arg445.getSubterm(0)))
              break Fail291;
          if(h_9740.value == null)
            h_9740.value = arg445.getSubterm(2);
          else
            if(h_9740.value != arg445.getSubterm(2) && !h_9740.value.match(arg445.getSubterm(2)))
              break Fail291;
          n_9740 = term;
          lifted215 lifted2150 = new lifted215();
          lifted2150.h_9740 = h_9740;
          lifted2150.i_9740 = i_9740;
          lifted2150.j_9740 = j_9740;
          lifted2150.k_9740 = k_9740;
          lifted2150.l_9740 = l_9740;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2150);
          if(term == null)
            break Fail291;
          term = n_9740;
          if(true)
            break Success211;
        }
        term = term286;
        IStrategoTerm g_9740 = null;
        g_9740 = term;
        term = templatelang_not_desugared_0_1.instance.invoke(context, g_9740, generated.const114);
        if(term == null)
          break Fail290;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}