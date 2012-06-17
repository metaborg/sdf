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

@SuppressWarnings("all") public class $Color$Rule$All_2_0 extends Strategy 
{ 
  public static $Color$Rule$All_2_0 instance = new $Color$Rule$All_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_32790, Strategy u_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRuleAll_2_0");
    Fail1275:
    { 
      IStrategoTerm o_32966 = null;
      IStrategoTerm m_32966 = null;
      IStrategoTerm n_32966 = null;
      IStrategoTerm p_32966 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRuleAll_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1275;
      m_32966 = term.getSubterm(0);
      n_32966 = term.getSubterm(1);
      IStrategoList annos48 = term.getAnnotations();
      o_32966 = annos48;
      term = t_32790.invoke(context, m_32966);
      if(term == null)
        break Fail1275;
      p_32966 = term;
      term = u_32790.invoke(context, n_32966);
      if(term == null)
        break Fail1275;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRuleAll_2, new IStrategoTerm[]{p_32966, term}), checkListAnnos(termFactory, o_32966));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}