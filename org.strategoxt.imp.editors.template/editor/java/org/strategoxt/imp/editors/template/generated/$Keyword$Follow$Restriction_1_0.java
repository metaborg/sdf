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

@SuppressWarnings("all") public class $Keyword$Follow$Restriction_1_0 extends Strategy 
{ 
  public static $Keyword$Follow$Restriction_1_0 instance = new $Keyword$Follow$Restriction_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("KeywordFollowRestriction_1_0");
    Fail535:
    { 
      IStrategoTerm y_9939 = null;
      IStrategoTerm x_9939 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consKeywordFollowRestriction_1 != ((IStrategoAppl)term).getConstructor())
        break Fail535;
      x_9939 = term.getSubterm(0);
      IStrategoList annos102 = term.getAnnotations();
      y_9939 = annos102;
      term = x_9756.invoke(context, x_9939);
      if(term == null)
        break Fail535;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consKeywordFollowRestriction_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, y_9939));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}