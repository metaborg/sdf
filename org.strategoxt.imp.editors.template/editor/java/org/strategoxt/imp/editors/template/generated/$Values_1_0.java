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

@SuppressWarnings("all") public class $Values_1_0 extends Strategy 
{ 
  public static $Values_1_0 instance = new $Values_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Values_1_0");
    Fail1300:
    { 
      IStrategoTerm q_32969 = null;
      IStrategoTerm p_32969 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consValues_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1300;
      p_32969 = term.getSubterm(0);
      IStrategoList annos71 = term.getAnnotations();
      q_32969 = annos71;
      term = w_32791.invoke(context, p_32969);
      if(term == null)
        break Fail1300;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consValues_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}