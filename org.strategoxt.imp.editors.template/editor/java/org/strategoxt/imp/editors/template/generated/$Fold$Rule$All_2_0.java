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

@SuppressWarnings("all") public class $Fold$Rule$All_2_0 extends Strategy 
{ 
  public static $Fold$Rule$All_2_0 instance = new $Fold$Rule$All_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_32790, Strategy x_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FoldRuleAll_2_0");
    Fail1278:
    { 
      IStrategoTerm w_32966 = null;
      IStrategoTerm u_32966 = null;
      IStrategoTerm v_32966 = null;
      IStrategoTerm x_32966 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFoldRuleAll_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1278;
      u_32966 = term.getSubterm(0);
      v_32966 = term.getSubterm(1);
      IStrategoList annos50 = term.getAnnotations();
      w_32966 = annos50;
      term = w_32790.invoke(context, u_32966);
      if(term == null)
        break Fail1278;
      x_32966 = term;
      term = x_32790.invoke(context, v_32966);
      if(term == null)
        break Fail1278;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFoldRuleAll_2, new IStrategoTerm[]{x_32966, term}), checkListAnnos(termFactory, w_32966));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}