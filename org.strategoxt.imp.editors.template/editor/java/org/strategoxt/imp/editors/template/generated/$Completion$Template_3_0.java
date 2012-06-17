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

@SuppressWarnings("all") public class $Completion$Template_3_0 extends Strategy 
{ 
  public static $Completion$Template_3_0 instance = new $Completion$Template_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_32793, Strategy l_32793, Strategy m_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTemplate_3_0");
    Fail1320:
    { 
      IStrategoTerm o_32973 = null;
      IStrategoTerm l_32973 = null;
      IStrategoTerm m_32973 = null;
      IStrategoTerm n_32973 = null;
      IStrategoTerm p_32973 = null;
      IStrategoTerm q_32973 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTemplate_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1320;
      l_32973 = term.getSubterm(0);
      m_32973 = term.getSubterm(1);
      n_32973 = term.getSubterm(2);
      IStrategoList annos91 = term.getAnnotations();
      o_32973 = annos91;
      term = k_32793.invoke(context, l_32973);
      if(term == null)
        break Fail1320;
      p_32973 = term;
      term = l_32793.invoke(context, m_32973);
      if(term == null)
        break Fail1320;
      q_32973 = term;
      term = m_32793.invoke(context, n_32973);
      if(term == null)
        break Fail1320;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTemplate_3, new IStrategoTerm[]{p_32973, q_32973, term}), checkListAnnos(termFactory, o_32973));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}