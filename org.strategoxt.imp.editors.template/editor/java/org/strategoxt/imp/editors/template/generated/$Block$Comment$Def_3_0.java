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

@SuppressWarnings("all") public class $Block$Comment$Def_3_0 extends Strategy 
{ 
  public static $Block$Comment$Def_3_0 instance = new $Block$Comment$Def_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_32791, Strategy e_32791, Strategy f_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("BlockCommentDef_3_0");
    Fail1283:
    { 
      IStrategoTerm p_32967 = null;
      IStrategoTerm m_32967 = null;
      IStrategoTerm n_32967 = null;
      IStrategoTerm o_32967 = null;
      IStrategoTerm q_32967 = null;
      IStrategoTerm r_32967 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBlockCommentDef_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1283;
      m_32967 = term.getSubterm(0);
      n_32967 = term.getSubterm(1);
      o_32967 = term.getSubterm(2);
      IStrategoList annos54 = term.getAnnotations();
      p_32967 = annos54;
      term = d_32791.invoke(context, m_32967);
      if(term == null)
        break Fail1283;
      q_32967 = term;
      term = e_32791.invoke(context, n_32967);
      if(term == null)
        break Fail1283;
      r_32967 = term;
      term = f_32791.invoke(context, o_32967);
      if(term == null)
        break Fail1283;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBlockCommentDef_3, new IStrategoTerm[]{q_32967, r_32967, term}), checkListAnnos(termFactory, p_32967));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}