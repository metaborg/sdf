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

@SuppressWarnings("all") public class $Line$Comment$Prefix_1_0 extends Strategy 
{ 
  public static $Line$Comment$Prefix_1_0 instance = new $Line$Comment$Prefix_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("LineCommentPrefix_1_0");
    Fail1288:
    { 
      IStrategoTerm g_32968 = null;
      IStrategoTerm f_32968 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLineCommentPrefix_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1288;
      f_32968 = term.getSubterm(0);
      IStrategoList annos59 = term.getAnnotations();
      g_32968 = annos59;
      term = k_32791.invoke(context, f_32968);
      if(term == null)
        break Fail1288;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLineCommentPrefix_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, g_32968));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}