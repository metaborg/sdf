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

@SuppressWarnings("all") public class $Sdf$Production$With$Cons_3_0 extends Strategy 
{ 
  public static $Sdf$Production$With$Cons_3_0 instance = new $Sdf$Production$With$Cons_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_9756, Strategy n_9756, Strategy o_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SdfProductionWithCons_3_0");
    Fail526:
    { 
      IStrategoTerm y_9938 = null;
      IStrategoTerm v_9938 = null;
      IStrategoTerm w_9938 = null;
      IStrategoTerm x_9938 = null;
      IStrategoTerm z_9938 = null;
      IStrategoTerm a_9939 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
        break Fail526;
      v_9938 = term.getSubterm(0);
      w_9938 = term.getSubterm(1);
      x_9938 = term.getSubterm(2);
      IStrategoList annos96 = term.getAnnotations();
      y_9938 = annos96;
      term = m_9756.invoke(context, v_9938);
      if(term == null)
        break Fail526;
      z_9938 = term;
      term = n_9756.invoke(context, w_9938);
      if(term == null)
        break Fail526;
      a_9939 = term;
      term = o_9756.invoke(context, x_9938);
      if(term == null)
        break Fail526;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSdfProductionWithCons_3, new IStrategoTerm[]{z_9938, a_9939, term}), checkListAnnos(termFactory, y_9938));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}