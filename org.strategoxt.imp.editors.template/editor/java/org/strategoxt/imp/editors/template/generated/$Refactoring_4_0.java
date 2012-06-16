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

@SuppressWarnings("all") public class $Refactoring_4_0 extends Strategy 
{ 
  public static $Refactoring_4_0 instance = new $Refactoring_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_9754, Strategy h_9754, Strategy i_9754, Strategy j_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Refactoring_4_0");
    Fail491:
    { 
      IStrategoTerm h_9933 = null;
      IStrategoTerm d_9933 = null;
      IStrategoTerm e_9933 = null;
      IStrategoTerm f_9933 = null;
      IStrategoTerm g_9933 = null;
      IStrategoTerm i_9933 = null;
      IStrategoTerm j_9933 = null;
      IStrategoTerm k_9933 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consRefactoring_4 != ((IStrategoAppl)term).getConstructor())
        break Fail491;
      d_9933 = term.getSubterm(0);
      e_9933 = term.getSubterm(1);
      f_9933 = term.getSubterm(2);
      g_9933 = term.getSubterm(3);
      IStrategoList annos64 = term.getAnnotations();
      h_9933 = annos64;
      term = g_9754.invoke(context, d_9933);
      if(term == null)
        break Fail491;
      i_9933 = term;
      term = h_9754.invoke(context, e_9933);
      if(term == null)
        break Fail491;
      j_9933 = term;
      term = i_9754.invoke(context, f_9933);
      if(term == null)
        break Fail491;
      k_9933 = term;
      term = j_9754.invoke(context, g_9933);
      if(term == null)
        break Fail491;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consRefactoring_4, new IStrategoTerm[]{i_9933, j_9933, k_9933, term}), checkListAnnos(termFactory, h_9933));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}