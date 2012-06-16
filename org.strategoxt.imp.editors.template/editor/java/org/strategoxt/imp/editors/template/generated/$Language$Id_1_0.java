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

@SuppressWarnings("all") public class $Language$Id_1_0 extends Strategy 
{ 
  public static $Language$Id_1_0 instance = new $Language$Id_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("LanguageId_1_0");
    Fail478:
    { 
      IStrategoTerm b_9931 = null;
      IStrategoTerm a_9931 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLanguageId_1 != ((IStrategoAppl)term).getConstructor())
        break Fail478;
      a_9931 = term.getSubterm(0);
      IStrategoList annos51 = term.getAnnotations();
      b_9931 = annos51;
      term = l_9753.invoke(context, a_9931);
      if(term == null)
        break Fail478;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLanguageId_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, b_9931));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}