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

@SuppressWarnings("all") public class $Template$Production$With$Cons_3_0 extends Strategy 
{ 
  public static $Template$Production$With$Cons_3_0 instance = new $Template$Production$With$Cons_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_32795, Strategy q_32795, Strategy r_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TemplateProductionWithCons_3_0");
    Fail1368:
    { 
      IStrategoTerm k_32979 = null;
      IStrategoTerm h_32979 = null;
      IStrategoTerm i_32979 = null;
      IStrategoTerm j_32979 = null;
      IStrategoTerm l_32979 = null;
      IStrategoTerm m_32979 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplateProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1368;
      h_32979 = term.getSubterm(0);
      i_32979 = term.getSubterm(1);
      j_32979 = term.getSubterm(2);
      IStrategoList annos129 = term.getAnnotations();
      k_32979 = annos129;
      term = p_32795.invoke(context, h_32979);
      if(term == null)
        break Fail1368;
      l_32979 = term;
      term = q_32795.invoke(context, i_32979);
      if(term == null)
        break Fail1368;
      m_32979 = term;
      term = r_32795.invoke(context, j_32979);
      if(term == null)
        break Fail1368;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplateProductionWithCons_3, new IStrategoTerm[]{l_32979, m_32979, term}), checkListAnnos(termFactory, k_32979));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}