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

@SuppressWarnings("all") public class $Sort$Cons_2_0 extends Strategy 
{ 
  public static $Sort$Cons_2_0 instance = new $Sort$Cons_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_9756, Strategy l_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SortCons_2_0");
    Fail525:
    { 
      IStrategoTerm s_9938 = null;
      IStrategoTerm q_9938 = null;
      IStrategoTerm r_9938 = null;
      IStrategoTerm t_9938 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)term).getConstructor())
        break Fail525;
      q_9938 = term.getSubterm(0);
      r_9938 = term.getSubterm(1);
      IStrategoList annos95 = term.getAnnotations();
      s_9938 = annos95;
      term = k_9756.invoke(context, q_9938);
      if(term == null)
        break Fail525;
      t_9938 = term;
      term = l_9756.invoke(context, r_9938);
      if(term == null)
        break Fail525;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSortCons_2, new IStrategoTerm[]{t_9938, term}), checkListAnnos(termFactory, s_9938));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}