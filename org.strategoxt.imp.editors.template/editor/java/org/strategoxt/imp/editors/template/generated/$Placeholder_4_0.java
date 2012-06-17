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

@SuppressWarnings("all") public class $Placeholder_4_0 extends Strategy 
{ 
  public static $Placeholder_4_0 instance = new $Placeholder_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_32794, Strategy q_32794, Strategy r_32794, Strategy s_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Placeholder_4_0");
    Fail1344:
    { 
      IStrategoTerm u_32976 = null;
      IStrategoTerm q_32976 = null;
      IStrategoTerm r_32976 = null;
      IStrategoTerm s_32976 = null;
      IStrategoTerm t_32976 = null;
      IStrategoTerm v_32976 = null;
      IStrategoTerm w_32976 = null;
      IStrategoTerm x_32976 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
        break Fail1344;
      q_32976 = term.getSubterm(0);
      r_32976 = term.getSubterm(1);
      s_32976 = term.getSubterm(2);
      t_32976 = term.getSubterm(3);
      IStrategoList annos112 = term.getAnnotations();
      u_32976 = annos112;
      term = p_32794.invoke(context, q_32976);
      if(term == null)
        break Fail1344;
      v_32976 = term;
      term = q_32794.invoke(context, r_32976);
      if(term == null)
        break Fail1344;
      w_32976 = term;
      term = r_32794.invoke(context, s_32976);
      if(term == null)
        break Fail1344;
      x_32976 = term;
      term = s_32794.invoke(context, t_32976);
      if(term == null)
        break Fail1344;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{v_32976, w_32976, x_32976, term}), checkListAnnos(termFactory, u_32976));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}