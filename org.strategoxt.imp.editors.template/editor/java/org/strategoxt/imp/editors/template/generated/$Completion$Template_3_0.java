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

@SuppressWarnings("all") public class $Completion$Template_3_0 extends Strategy 
{ 
  public static $Completion$Template_3_0 instance = new $Completion$Template_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_9755, Strategy c_9755, Strategy d_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTemplate_3_0");
    Fail500:
    { 
      IStrategoTerm f_9935 = null;
      IStrategoTerm c_9935 = null;
      IStrategoTerm d_9935 = null;
      IStrategoTerm e_9935 = null;
      IStrategoTerm g_9935 = null;
      IStrategoTerm h_9935 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTemplate_3 != ((IStrategoAppl)term).getConstructor())
        break Fail500;
      c_9935 = term.getSubterm(0);
      d_9935 = term.getSubterm(1);
      e_9935 = term.getSubterm(2);
      IStrategoList annos73 = term.getAnnotations();
      f_9935 = annos73;
      term = b_9755.invoke(context, c_9935);
      if(term == null)
        break Fail500;
      g_9935 = term;
      term = c_9755.invoke(context, d_9935);
      if(term == null)
        break Fail500;
      h_9935 = term;
      term = d_9755.invoke(context, e_9935);
      if(term == null)
        break Fail500;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTemplate_3, new IStrategoTerm[]{g_9935, h_9935, term}), checkListAnnos(termFactory, f_9935));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}