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

@SuppressWarnings("all") public class $Fold$Rule_2_0 extends Strategy 
{ 
  public static $Fold$Rule_2_0 instance = new $Fold$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_9752, Strategy q_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FoldRule_2_0");
    Fail459:
    { 
      IStrategoTerm s_9928 = null;
      IStrategoTerm q_9928 = null;
      IStrategoTerm r_9928 = null;
      IStrategoTerm t_9928 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFoldRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail459;
      q_9928 = term.getSubterm(0);
      r_9928 = term.getSubterm(1);
      IStrategoList annos33 = term.getAnnotations();
      s_9928 = annos33;
      term = p_9752.invoke(context, q_9928);
      if(term == null)
        break Fail459;
      t_9928 = term;
      term = q_9752.invoke(context, r_9928);
      if(term == null)
        break Fail459;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFoldRule_2, new IStrategoTerm[]{t_9928, term}), checkListAnnos(termFactory, s_9928));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}