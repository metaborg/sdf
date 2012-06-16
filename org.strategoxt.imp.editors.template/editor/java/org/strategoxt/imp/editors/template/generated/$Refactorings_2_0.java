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

@SuppressWarnings("all") public class $Refactorings_2_0 extends Strategy 
{ 
  public static $Refactorings_2_0 instance = new $Refactorings_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_9753, Strategy p_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Refactorings_2_0");
    Fail481:
    { 
      IStrategoTerm l_9931 = null;
      IStrategoTerm j_9931 = null;
      IStrategoTerm k_9931 = null;
      IStrategoTerm m_9931 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consRefactorings_2 != ((IStrategoAppl)term).getConstructor())
        break Fail481;
      j_9931 = term.getSubterm(0);
      k_9931 = term.getSubterm(1);
      IStrategoList annos54 = term.getAnnotations();
      l_9931 = annos54;
      term = o_9753.invoke(context, j_9931);
      if(term == null)
        break Fail481;
      m_9931 = term;
      term = p_9753.invoke(context, k_9931);
      if(term == null)
        break Fail481;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consRefactorings_2, new IStrategoTerm[]{m_9931, term}), checkListAnnos(termFactory, l_9931));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}