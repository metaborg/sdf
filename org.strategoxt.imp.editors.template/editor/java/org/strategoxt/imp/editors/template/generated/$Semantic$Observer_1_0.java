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

@SuppressWarnings("all") public class $Semantic$Observer_1_0 extends Strategy 
{ 
  public static $Semantic$Observer_1_0 instance = new $Semantic$Observer_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SemanticObserver_1_0");
    Fail496:
    { 
      IStrategoTerm d_9934 = null;
      IStrategoTerm c_9934 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSemanticObserver_1 != ((IStrategoAppl)term).getConstructor())
        break Fail496;
      c_9934 = term.getSubterm(0);
      IStrategoList annos69 = term.getAnnotations();
      d_9934 = annos69;
      term = q_9754.invoke(context, c_9934);
      if(term == null)
        break Fail496;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSemanticObserver_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, d_9934));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}