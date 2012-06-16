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

@SuppressWarnings("all") public class $Description_1_0 extends Strategy 
{ 
  public static $Description_1_0 instance = new $Description_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Description_1_0");
    Fail476:
    { 
      IStrategoTerm v_9930 = null;
      IStrategoTerm u_9930 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consDescription_1 != ((IStrategoAppl)term).getConstructor())
        break Fail476;
      u_9930 = term.getSubterm(0);
      IStrategoList annos49 = term.getAnnotations();
      v_9930 = annos49;
      term = j_9753.invoke(context, u_9930);
      if(term == null)
        break Fail476;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consDescription_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, v_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}