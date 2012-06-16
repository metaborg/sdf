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

@SuppressWarnings("all") public class $Completions_2_0 extends Strategy 
{ 
  public static $Completions_2_0 instance = new $Completions_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_9753, Strategy t_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Completions_2_0");
    Fail483:
    { 
      IStrategoTerm v_9931 = null;
      IStrategoTerm t_9931 = null;
      IStrategoTerm u_9931 = null;
      IStrategoTerm w_9931 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletions_2 != ((IStrategoAppl)term).getConstructor())
        break Fail483;
      t_9931 = term.getSubterm(0);
      u_9931 = term.getSubterm(1);
      IStrategoList annos56 = term.getAnnotations();
      v_9931 = annos56;
      term = s_9753.invoke(context, t_9931);
      if(term == null)
        break Fail483;
      w_9931 = term;
      term = t_9753.invoke(context, u_9931);
      if(term == null)
        break Fail483;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletions_2, new IStrategoTerm[]{w_9931, term}), checkListAnnos(termFactory, v_9931));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}