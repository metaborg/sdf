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

@SuppressWarnings("all") public class $Sdf$Production_3_0 extends Strategy 
{ 
  public static $Sdf$Production_3_0 instance = new $Sdf$Production_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_32794, Strategy z_32794, Strategy a_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SdfProduction_3_0");
    Fail1347:
    { 
      IStrategoTerm o_32977 = null;
      IStrategoTerm l_32977 = null;
      IStrategoTerm m_32977 = null;
      IStrategoTerm n_32977 = null;
      IStrategoTerm p_32977 = null;
      IStrategoTerm q_32977 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProduction_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1347;
      l_32977 = term.getSubterm(0);
      m_32977 = term.getSubterm(1);
      n_32977 = term.getSubterm(2);
      IStrategoList annos115 = term.getAnnotations();
      o_32977 = annos115;
      term = y_32794.invoke(context, l_32977);
      if(term == null)
        break Fail1347;
      p_32977 = term;
      term = z_32794.invoke(context, m_32977);
      if(term == null)
        break Fail1347;
      q_32977 = term;
      term = a_32795.invoke(context, n_32977);
      if(term == null)
        break Fail1347;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSdfProduction_3, new IStrategoTerm[]{p_32977, q_32977, term}), checkListAnnos(termFactory, o_32977));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}