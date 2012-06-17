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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("LanguageId_1_0");
    Fail1298:
    { 
      IStrategoTerm k_32969 = null;
      IStrategoTerm j_32969 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLanguageId_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1298;
      j_32969 = term.getSubterm(0);
      IStrategoList annos69 = term.getAnnotations();
      k_32969 = annos69;
      term = u_32791.invoke(context, j_32969);
      if(term == null)
        break Fail1298;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLanguageId_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}