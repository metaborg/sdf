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

@SuppressWarnings("all") public class $Layout_1_0 extends Strategy 
{ 
  public static $Layout_1_0 instance = new $Layout_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Layout_1_0");
    Fail1336:
    { 
      IStrategoTerm c_32976 = null;
      IStrategoTerm b_32976 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1336;
      b_32976 = term.getSubterm(0);
      IStrategoList annos107 = term.getAnnotations();
      c_32976 = annos107;
      term = k_32794.invoke(context, b_32976);
      if(term == null)
        break Fail1336;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLayout_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, c_32976));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}