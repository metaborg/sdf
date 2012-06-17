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

@SuppressWarnings("all") public class $Constructor_1_0 extends Strategy 
{ 
  public static $Constructor_1_0 instance = new $Constructor_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Constructor_1_0");
    Fail1330:
    { 
      IStrategoTerm k_32975 = null;
      IStrategoTerm j_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consConstructor_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1330;
      j_32975 = term.getSubterm(0);
      IStrategoList annos101 = term.getAnnotations();
      k_32975 = annos101;
      term = e_32794.invoke(context, j_32975);
      if(term == null)
        break Fail1330;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consConstructor_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}