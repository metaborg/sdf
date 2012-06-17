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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32790, Strategy p_32790, Strategy q_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRuleAllNamed_3_0");
    Fail1273:
    { 
      IStrategoTerm d_32966 = null;
      IStrategoTerm a_32966 = null;
      IStrategoTerm b_32966 = null;
      IStrategoTerm c_32966 = null;
      IStrategoTerm e_32966 = null;
      IStrategoTerm f_32966 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRuleAllNamed_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1273;
      a_32966 = term.getSubterm(0);
      b_32966 = term.getSubterm(1);
      c_32966 = term.getSubterm(2);
      IStrategoList annos46 = term.getAnnotations();
      d_32966 = annos46;
      term = o_32790.invoke(context, a_32966);
      if(term == null)
        break Fail1273;
      e_32966 = term;
      term = p_32790.invoke(context, b_32966);
      if(term == null)
        break Fail1273;
      f_32966 = term;
      term = q_32790.invoke(context, c_32966);
      if(term == null)
        break Fail1273;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRuleAllNamed_3, new IStrategoTerm[]{e_32966, f_32966, term}), checkListAnnos(termFactory, d_32966));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}