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

@SuppressWarnings("all") public class $Sort$And$Constructor_2_0 extends Strategy 
{ 
  public static $Sort$And$Constructor_2_0 instance = new $Sort$And$Constructor_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_9755, Strategy u_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SortAndConstructor_2_0");
    Fail509:
    { 
      IStrategoTerm x_9936 = null;
      IStrategoTerm v_9936 = null;
      IStrategoTerm w_9936 = null;
      IStrategoTerm y_9936 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSortAndConstructor_2 != ((IStrategoAppl)term).getConstructor())
        break Fail509;
      v_9936 = term.getSubterm(0);
      w_9936 = term.getSubterm(1);
      IStrategoList annos82 = term.getAnnotations();
      x_9936 = annos82;
      term = t_9755.invoke(context, v_9936);
      if(term == null)
        break Fail509;
      y_9936 = term;
      term = u_9755.invoke(context, w_9936);
      if(term == null)
        break Fail509;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSortAndConstructor_2, new IStrategoTerm[]{y_9936, term}), checkListAnnos(termFactory, x_9936));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}