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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Strategy_1_0");
    Fail490:
    { 
      IStrategoTerm b_9933 = null;
      IStrategoTerm a_9933 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consStrategy_1 != ((IStrategoAppl)term).getConstructor())
        break Fail490;
      a_9933 = term.getSubterm(0);
      IStrategoList annos63 = term.getAnnotations();
      b_9933 = annos63;
      term = f_9754.invoke(context, a_9933);
      if(term == null)
        break Fail490;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consStrategy_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, b_9933));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}