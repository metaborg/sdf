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

@SuppressWarnings("all") public class $Completion$Template$Ex_4_0 extends Strategy 
{ 
  public static $Completion$Template$Ex_4_0 instance = new $Completion$Template$Ex_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_9754, Strategy s_9754, Strategy t_9754, Strategy u_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTemplateEx_4_0");
    Fail497:
    { 
      IStrategoTerm j_9934 = null;
      IStrategoTerm f_9934 = null;
      IStrategoTerm g_9934 = null;
      IStrategoTerm h_9934 = null;
      IStrategoTerm i_9934 = null;
      IStrategoTerm k_9934 = null;
      IStrategoTerm l_9934 = null;
      IStrategoTerm m_9934 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTemplateEx_4 != ((IStrategoAppl)term).getConstructor())
        break Fail497;
      f_9934 = term.getSubterm(0);
      g_9934 = term.getSubterm(1);
      h_9934 = term.getSubterm(2);
      i_9934 = term.getSubterm(3);
      IStrategoList annos70 = term.getAnnotations();
      j_9934 = annos70;
      term = r_9754.invoke(context, f_9934);
      if(term == null)
        break Fail497;
      k_9934 = term;
      term = s_9754.invoke(context, g_9934);
      if(term == null)
        break Fail497;
      l_9934 = term;
      term = t_9754.invoke(context, h_9934);
      if(term == null)
        break Fail497;
      m_9934 = term;
      term = u_9754.invoke(context, i_9934);
      if(term == null)
        break Fail497;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTemplateEx_4, new IStrategoTerm[]{k_9934, l_9934, m_9934, term}), checkListAnnos(termFactory, j_9934));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}