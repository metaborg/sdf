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

@SuppressWarnings("all") public class $Color$Rule$All$Named_3_0 extends Strategy 
{ 
  public static $Color$Rule$All$Named_3_0 instance = new $Color$Rule$All$Named_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_9752, Strategy g_9752, Strategy h_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRuleAllNamed_3_0");
    Fail453:
    { 
      IStrategoTerm u_9927 = null;
      IStrategoTerm r_9927 = null;
      IStrategoTerm s_9927 = null;
      IStrategoTerm t_9927 = null;
      IStrategoTerm v_9927 = null;
      IStrategoTerm w_9927 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRuleAllNamed_3 != ((IStrategoAppl)term).getConstructor())
        break Fail453;
      r_9927 = term.getSubterm(0);
      s_9927 = term.getSubterm(1);
      t_9927 = term.getSubterm(2);
      IStrategoList annos28 = term.getAnnotations();
      u_9927 = annos28;
      term = f_9752.invoke(context, r_9927);
      if(term == null)
        break Fail453;
      v_9927 = term;
      term = g_9752.invoke(context, s_9927);
      if(term == null)
        break Fail453;
      w_9927 = term;
      term = h_9752.invoke(context, t_9927);
      if(term == null)
        break Fail453;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRuleAllNamed_3, new IStrategoTerm[]{v_9927, w_9927, term}), checkListAnnos(termFactory, u_9927));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}