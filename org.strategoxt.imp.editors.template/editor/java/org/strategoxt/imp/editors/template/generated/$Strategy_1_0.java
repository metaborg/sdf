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

@SuppressWarnings("all") public class $Strategy_1_0 extends Strategy 
{ 
  public static $Strategy_1_0 instance = new $Strategy_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Strategy_1_0");
    Fail1310:
    { 
      IStrategoTerm k_32971 = null;
      IStrategoTerm j_32971 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consStrategy_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1310;
      j_32971 = term.getSubterm(0);
      IStrategoList annos81 = term.getAnnotations();
      k_32971 = annos81;
      term = o_32792.invoke(context, j_32971);
      if(term == null)
        break Fail1310;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consStrategy_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_32971));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}