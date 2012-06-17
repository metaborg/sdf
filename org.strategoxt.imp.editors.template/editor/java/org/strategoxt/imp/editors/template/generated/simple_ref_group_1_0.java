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

@SuppressWarnings("all") public class simple_ref_group_1_0 extends Strategy 
{ 
  public static simple_ref_group_1_0 instance = new simple_ref_group_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("simple_ref_group_1_0");
    Fail1350:
    { 
      IStrategoTerm b_32978 = null;
      IStrategoTerm a_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._conssimple_ref_group_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1350;
      a_32978 = term.getSubterm(0);
      IStrategoList annos118 = term.getAnnotations();
      b_32978 = annos118;
      term = e_32795.invoke(context, a_32978);
      if(term == null)
        break Fail1350;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._conssimple_ref_group_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, b_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}