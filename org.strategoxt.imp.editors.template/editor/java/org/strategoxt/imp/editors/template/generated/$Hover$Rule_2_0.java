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

@SuppressWarnings("all") public class $Hover$Rule_2_0 extends Strategy 
{ 
  public static $Hover$Rule_2_0 instance = new $Hover$Rule_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_9755, Strategy k_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("HoverRule_2_0");
    Fail504:
    { 
      IStrategoTerm y_9935 = null;
      IStrategoTerm w_9935 = null;
      IStrategoTerm x_9935 = null;
      IStrategoTerm z_9935 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consHoverRule_2 != ((IStrategoAppl)term).getConstructor())
        break Fail504;
      w_9935 = term.getSubterm(0);
      x_9935 = term.getSubterm(1);
      IStrategoList annos77 = term.getAnnotations();
      y_9935 = annos77;
      term = j_9755.invoke(context, w_9935);
      if(term == null)
        break Fail504;
      z_9935 = term;
      term = k_9755.invoke(context, x_9935);
      if(term == null)
        break Fail504;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consHoverRule_2, new IStrategoTerm[]{z_9935, term}), checkListAnnos(termFactory, y_9935));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}