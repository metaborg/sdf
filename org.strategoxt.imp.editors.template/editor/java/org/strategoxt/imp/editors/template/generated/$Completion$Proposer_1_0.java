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

@SuppressWarnings("all") public class $Completion$Proposer_1_0 extends Strategy 
{ 
  public static $Completion$Proposer_1_0 instance = new $Completion$Proposer_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionProposer_1_0");
    Fail502:
    { 
      IStrategoTerm p_9935 = null;
      IStrategoTerm o_9935 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionProposer_1 != ((IStrategoAppl)term).getConstructor())
        break Fail502;
      o_9935 = term.getSubterm(0);
      IStrategoList annos75 = term.getAnnotations();
      p_9935 = annos75;
      term = g_9755.invoke(context, o_9935);
      if(term == null)
        break Fail502;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionProposer_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, p_9935));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}