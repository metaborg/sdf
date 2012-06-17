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

@SuppressWarnings("all") public class $Color$Rule$Named_3_0 extends Strategy 
{ 
  public static $Color$Rule$Named_3_0 instance = new $Color$Rule$Named_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_32790, Strategy m_32790, Strategy n_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRuleNamed_3_0");
    Fail1272:
    { 
      IStrategoTerm w_32965 = null;
      IStrategoTerm t_32965 = null;
      IStrategoTerm u_32965 = null;
      IStrategoTerm v_32965 = null;
      IStrategoTerm x_32965 = null;
      IStrategoTerm y_32965 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRuleNamed_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1272;
      t_32965 = term.getSubterm(0);
      u_32965 = term.getSubterm(1);
      v_32965 = term.getSubterm(2);
      IStrategoList annos45 = term.getAnnotations();
      w_32965 = annos45;
      term = l_32790.invoke(context, t_32965);
      if(term == null)
        break Fail1272;
      x_32965 = term;
      term = m_32790.invoke(context, u_32965);
      if(term == null)
        break Fail1272;
      y_32965 = term;
      term = n_32790.invoke(context, v_32965);
      if(term == null)
        break Fail1272;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRuleNamed_3, new IStrategoTerm[]{x_32965, y_32965, term}), checkListAnnos(termFactory, w_32965));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}