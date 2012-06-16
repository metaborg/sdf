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

@SuppressWarnings("all") public class $Folding_2_0 extends Strategy 
{ 
  public static $Folding_2_0 instance = new $Folding_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_9754, Strategy b_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Folding_2_0");
    Fail487:
    { 
      IStrategoTerm p_9932 = null;
      IStrategoTerm n_9932 = null;
      IStrategoTerm o_9932 = null;
      IStrategoTerm q_9932 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFolding_2 != ((IStrategoAppl)term).getConstructor())
        break Fail487;
      n_9932 = term.getSubterm(0);
      o_9932 = term.getSubterm(1);
      IStrategoList annos60 = term.getAnnotations();
      p_9932 = annos60;
      term = a_9754.invoke(context, n_9932);
      if(term == null)
        break Fail487;
      q_9932 = term;
      term = b_9754.invoke(context, o_9932);
      if(term == null)
        break Fail487;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFolding_2, new IStrategoTerm[]{q_9932, term}), checkListAnnos(termFactory, p_9932));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}