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

@SuppressWarnings("all") public class $Extensions_1_0 extends Strategy 
{ 
  public static $Extensions_1_0 instance = new $Extensions_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Extensions_1_0");
    Fail477:
    { 
      IStrategoTerm y_9930 = null;
      IStrategoTerm x_9930 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consExtensions_1 != ((IStrategoAppl)term).getConstructor())
        break Fail477;
      x_9930 = term.getSubterm(0);
      IStrategoList annos50 = term.getAnnotations();
      y_9930 = annos50;
      term = k_9753.invoke(context, x_9930);
      if(term == null)
        break Fail477;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consExtensions_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, y_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}