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

@SuppressWarnings("all") public class $Constructor$Only_1_0 extends Strategy 
{ 
  public static $Constructor$Only_1_0 instance = new $Constructor$Only_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ConstructorOnly_1_0");
    Fail511:
    { 
      IStrategoTerm e_9937 = null;
      IStrategoTerm d_9937 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consConstructorOnly_1 != ((IStrategoAppl)term).getConstructor())
        break Fail511;
      d_9937 = term.getSubterm(0);
      IStrategoList annos84 = term.getAnnotations();
      e_9937 = annos84;
      term = w_9755.invoke(context, d_9937);
      if(term == null)
        break Fail511;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consConstructorOnly_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, e_9937));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}