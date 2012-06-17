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

@SuppressWarnings("all") public class assoc_ref_group_2_0 extends Strategy 
{ 
  public static assoc_ref_group_2_0 instance = new assoc_ref_group_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_32795, Strategy c_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("assoc_ref_group_2_0");
    Fail1348:
    { 
      IStrategoTerm u_32977 = null;
      IStrategoTerm s_32977 = null;
      IStrategoTerm t_32977 = null;
      IStrategoTerm v_32977 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consassoc_ref_group_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1348;
      s_32977 = term.getSubterm(0);
      t_32977 = term.getSubterm(1);
      IStrategoList annos116 = term.getAnnotations();
      u_32977 = annos116;
      term = b_32795.invoke(context, s_32977);
      if(term == null)
        break Fail1348;
      v_32977 = term;
      term = c_32795.invoke(context, t_32977);
      if(term == null)
        break Fail1348;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consassoc_ref_group_2, new IStrategoTerm[]{v_32977, term}), checkListAnnos(termFactory, u_32977));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}