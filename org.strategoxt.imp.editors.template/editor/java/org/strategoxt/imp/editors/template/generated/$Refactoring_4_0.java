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

@SuppressWarnings("all") public class $Refactoring_4_0 extends Strategy 
{ 
  public static $Refactoring_4_0 instance = new $Refactoring_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_32792, Strategy q_32792, Strategy r_32792, Strategy s_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Refactoring_4_0");
    Fail1311:
    { 
      IStrategoTerm q_32971 = null;
      IStrategoTerm m_32971 = null;
      IStrategoTerm n_32971 = null;
      IStrategoTerm o_32971 = null;
      IStrategoTerm p_32971 = null;
      IStrategoTerm r_32971 = null;
      IStrategoTerm s_32971 = null;
      IStrategoTerm t_32971 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consRefactoring_4 != ((IStrategoAppl)term).getConstructor())
        break Fail1311;
      m_32971 = term.getSubterm(0);
      n_32971 = term.getSubterm(1);
      o_32971 = term.getSubterm(2);
      p_32971 = term.getSubterm(3);
      IStrategoList annos82 = term.getAnnotations();
      q_32971 = annos82;
      term = p_32792.invoke(context, m_32971);
      if(term == null)
        break Fail1311;
      r_32971 = term;
      term = q_32792.invoke(context, n_32971);
      if(term == null)
        break Fail1311;
      s_32971 = term;
      term = r_32792.invoke(context, o_32971);
      if(term == null)
        break Fail1311;
      t_32971 = term;
      term = s_32792.invoke(context, p_32971);
      if(term == null)
        break Fail1311;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consRefactoring_4, new IStrategoTerm[]{r_32971, s_32971, t_32971, term}), checkListAnnos(termFactory, q_32971));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}