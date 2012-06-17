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

@SuppressWarnings("all") public class $Semantic$Provider_1_0 extends Strategy 
{ 
  public static $Semantic$Provider_1_0 instance = new $Semantic$Provider_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SemanticProvider_1_0");
    Fail1328:
    { 
      IStrategoTerm c_32975 = null;
      IStrategoTerm b_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSemanticProvider_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1328;
      b_32975 = term.getSubterm(0);
      IStrategoList annos99 = term.getAnnotations();
      c_32975 = annos99;
      term = b_32794.invoke(context, b_32975);
      if(term == null)
        break Fail1328;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSemanticProvider_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, c_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}