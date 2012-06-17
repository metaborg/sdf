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

@SuppressWarnings("all") public class $Template$Production_3_0 extends Strategy 
{ 
  public static $Template$Production_3_0 instance = new $Template$Production_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_32795, Strategy t_32795, Strategy u_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TemplateProduction_3_0");
    Fail1369:
    { 
      IStrategoTerm r_32979 = null;
      IStrategoTerm o_32979 = null;
      IStrategoTerm p_32979 = null;
      IStrategoTerm q_32979 = null;
      IStrategoTerm s_32979 = null;
      IStrategoTerm t_32979 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1369;
      o_32979 = term.getSubterm(0);
      p_32979 = term.getSubterm(1);
      q_32979 = term.getSubterm(2);
      IStrategoList annos130 = term.getAnnotations();
      r_32979 = annos130;
      term = s_32795.invoke(context, o_32979);
      if(term == null)
        break Fail1369;
      s_32979 = term;
      term = t_32795.invoke(context, p_32979);
      if(term == null)
        break Fail1369;
      t_32979 = term;
      term = u_32795.invoke(context, q_32979);
      if(term == null)
        break Fail1369;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{s_32979, t_32979, term}), checkListAnnos(termFactory, r_32979));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}