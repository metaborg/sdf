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

@SuppressWarnings("all") public class $Completion$Keyword_2_0 extends Strategy 
{ 
  public static $Completion$Keyword_2_0 instance = new $Completion$Keyword_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_9755, Strategy f_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionKeyword_2_0");
    Fail501:
    { 
      IStrategoTerm l_9935 = null;
      IStrategoTerm j_9935 = null;
      IStrategoTerm k_9935 = null;
      IStrategoTerm m_9935 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionKeyword_2 != ((IStrategoAppl)term).getConstructor())
        break Fail501;
      j_9935 = term.getSubterm(0);
      k_9935 = term.getSubterm(1);
      IStrategoList annos74 = term.getAnnotations();
      l_9935 = annos74;
      term = e_9755.invoke(context, j_9935);
      if(term == null)
        break Fail501;
      m_9935 = term;
      term = f_9755.invoke(context, k_9935);
      if(term == null)
        break Fail501;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionKeyword_2, new IStrategoTerm[]{m_9935, term}), checkListAnnos(termFactory, l_9935));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}