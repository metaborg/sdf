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

@SuppressWarnings("all") public class prods_ref_group_1_0 extends Strategy 
{ 
  public static prods_ref_group_1_0 instance = new prods_ref_group_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("prods_ref_group_1_0");
    Fail1349:
    { 
      IStrategoTerm y_32977 = null;
      IStrategoTerm x_32977 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consprods_ref_group_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1349;
      x_32977 = term.getSubterm(0);
      IStrategoList annos117 = term.getAnnotations();
      y_32977 = annos117;
      term = d_32795.invoke(context, x_32977);
      if(term == null)
        break Fail1349;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consprods_ref_group_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, y_32977));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}