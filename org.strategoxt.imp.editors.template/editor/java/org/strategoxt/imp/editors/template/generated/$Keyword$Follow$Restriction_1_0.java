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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("KeywordFollowRestriction_1_0");
    Fail1355:
    { 
      IStrategoTerm h_32978 = null;
      IStrategoTerm g_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consKeywordFollowRestriction_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1355;
      g_32978 = term.getSubterm(0);
      IStrategoList annos120 = term.getAnnotations();
      h_32978 = annos120;
      term = g_32795.invoke(context, g_32978);
      if(term == null)
        break Fail1355;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consKeywordFollowRestriction_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, h_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}