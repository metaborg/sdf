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

@SuppressWarnings("all") public class $Color$Rule$Named_3_0 extends Strategy 
{ 
  public static $Color$Rule$Named_3_0 instance = new $Color$Rule$Named_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_9752, Strategy d_9752, Strategy e_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRuleNamed_3_0");
    Fail452:
    { 
      IStrategoTerm n_9927 = null;
      IStrategoTerm k_9927 = null;
      IStrategoTerm l_9927 = null;
      IStrategoTerm m_9927 = null;
      IStrategoTerm o_9927 = null;
      IStrategoTerm p_9927 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRuleNamed_3 != ((IStrategoAppl)term).getConstructor())
        break Fail452;
      k_9927 = term.getSubterm(0);
      l_9927 = term.getSubterm(1);
      m_9927 = term.getSubterm(2);
      IStrategoList annos27 = term.getAnnotations();
      n_9927 = annos27;
      term = c_9752.invoke(context, k_9927);
      if(term == null)
        break Fail452;
      o_9927 = term;
      term = d_9752.invoke(context, l_9927);
      if(term == null)
        break Fail452;
      p_9927 = term;
      term = e_9752.invoke(context, m_9927);
      if(term == null)
        break Fail452;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRuleNamed_3, new IStrategoTerm[]{o_9927, p_9927, term}), checkListAnnos(termFactory, n_9927));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}