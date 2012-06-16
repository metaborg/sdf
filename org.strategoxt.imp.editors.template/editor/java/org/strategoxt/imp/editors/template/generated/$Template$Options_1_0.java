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

@SuppressWarnings("all") public class $Template$Options_1_0 extends Strategy 
{ 
  public static $Template$Options_1_0 instance = new $Template$Options_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TemplateOptions_1_0");
    Fail539:
    { 
      IStrategoTerm k_9940 = null;
      IStrategoTerm j_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateOptions_1 != ((IStrategoAppl)term).getConstructor())
        break Fail539;
      j_9940 = term.getSubterm(0);
      IStrategoList annos106 = term.getAnnotations();
      k_9940 = annos106;
      term = b_9757.invoke(context, j_9940);
      if(term == null)
        break Fail539;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplateOptions_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}