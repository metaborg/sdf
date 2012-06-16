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

@SuppressWarnings("all") public class $Template$Production_3_0 extends Strategy 
{ 
  public static $Template$Production_3_0 instance = new $Template$Production_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_9757, Strategy k_9757, Strategy l_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TemplateProduction_3_0");
    Fail549:
    { 
      IStrategoTerm i_9941 = null;
      IStrategoTerm f_9941 = null;
      IStrategoTerm g_9941 = null;
      IStrategoTerm h_9941 = null;
      IStrategoTerm j_9941 = null;
      IStrategoTerm k_9941 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail549;
      f_9941 = term.getSubterm(0);
      g_9941 = term.getSubterm(1);
      h_9941 = term.getSubterm(2);
      IStrategoList annos112 = term.getAnnotations();
      i_9941 = annos112;
      term = j_9757.invoke(context, f_9941);
      if(term == null)
        break Fail549;
      j_9941 = term;
      term = k_9757.invoke(context, g_9941);
      if(term == null)
        break Fail549;
      k_9941 = term;
      term = l_9757.invoke(context, h_9941);
      if(term == null)
        break Fail549;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{j_9941, k_9941, term}), checkListAnnos(termFactory, i_9941));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}