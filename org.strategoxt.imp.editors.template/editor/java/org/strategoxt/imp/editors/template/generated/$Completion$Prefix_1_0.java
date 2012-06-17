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

@SuppressWarnings("all") public class $Completion$Prefix_1_0 extends Strategy 
{ 
  public static $Completion$Prefix_1_0 instance = new $Completion$Prefix_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_32789)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionPrefix_1_0");
    Fail1249:
    { 
      IStrategoTerm p_32964 = null;
      IStrategoTerm o_32964 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionPrefix_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1249;
      o_32964 = term.getSubterm(0);
      IStrategoList annos38 = term.getAnnotations();
      p_32964 = annos38;
      term = z_32789.invoke(context, o_32964);
      if(term == null)
        break Fail1249;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionPrefix_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, p_32964));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}