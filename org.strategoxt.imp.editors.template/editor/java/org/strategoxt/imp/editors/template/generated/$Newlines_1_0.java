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

@SuppressWarnings("all") public class $Newlines_1_0 extends Strategy 
{ 
  public static $Newlines_1_0 instance = new $Newlines_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Newlines_1_0");
    Fail536:
    { 
      IStrategoTerm b_9940 = null;
      IStrategoTerm a_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consNewlines_1 != ((IStrategoAppl)term).getConstructor())
        break Fail536;
      a_9940 = term.getSubterm(0);
      IStrategoList annos103 = term.getAnnotations();
      b_9940 = annos103;
      term = y_9756.invoke(context, a_9940);
      if(term == null)
        break Fail536;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consNewlines_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, b_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}