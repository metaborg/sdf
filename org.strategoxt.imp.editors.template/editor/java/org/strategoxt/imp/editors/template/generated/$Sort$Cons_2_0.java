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

@SuppressWarnings("all") public class $Sort$Cons_2_0 extends Strategy 
{ 
  public static $Sort$Cons_2_0 instance = new $Sort$Cons_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_32794, Strategy u_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SortCons_2_0");
    Fail1345:
    { 
      IStrategoTerm b_32977 = null;
      IStrategoTerm z_32976 = null;
      IStrategoTerm a_32977 = null;
      IStrategoTerm c_32977 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSortCons_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1345;
      z_32976 = term.getSubterm(0);
      a_32977 = term.getSubterm(1);
      IStrategoList annos113 = term.getAnnotations();
      b_32977 = annos113;
      term = t_32794.invoke(context, z_32976);
      if(term == null)
        break Fail1345;
      c_32977 = term;
      term = u_32794.invoke(context, a_32977);
      if(term == null)
        break Fail1345;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSortCons_2, new IStrategoTerm[]{c_32977, term}), checkListAnnos(termFactory, b_32977));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}