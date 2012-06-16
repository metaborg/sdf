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

@SuppressWarnings("all") public class assoc_ref_group_2_0 extends Strategy 
{ 
  public static assoc_ref_group_2_0 instance = new assoc_ref_group_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_9756, Strategy t_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("assoc_ref_group_2_0");
    Fail528:
    { 
      IStrategoTerm l_9939 = null;
      IStrategoTerm j_9939 = null;
      IStrategoTerm k_9939 = null;
      IStrategoTerm m_9939 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consassoc_ref_group_2 != ((IStrategoAppl)term).getConstructor())
        break Fail528;
      j_9939 = term.getSubterm(0);
      k_9939 = term.getSubterm(1);
      IStrategoList annos98 = term.getAnnotations();
      l_9939 = annos98;
      term = s_9756.invoke(context, j_9939);
      if(term == null)
        break Fail528;
      m_9939 = term;
      term = t_9756.invoke(context, k_9939);
      if(term == null)
        break Fail528;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consassoc_ref_group_2, new IStrategoTerm[]{m_9939, term}), checkListAnnos(termFactory, l_9939));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}