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

@SuppressWarnings("all") public class $Completion$Keyword_2_0 extends Strategy 
{ 
  public static $Completion$Keyword_2_0 instance = new $Completion$Keyword_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32793, Strategy o_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionKeyword_2_0");
    Fail1321:
    { 
      IStrategoTerm u_32973 = null;
      IStrategoTerm s_32973 = null;
      IStrategoTerm t_32973 = null;
      IStrategoTerm v_32973 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionKeyword_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1321;
      s_32973 = term.getSubterm(0);
      t_32973 = term.getSubterm(1);
      IStrategoList annos92 = term.getAnnotations();
      u_32973 = annos92;
      term = n_32793.invoke(context, s_32973);
      if(term == null)
        break Fail1321;
      v_32973 = term;
      term = o_32793.invoke(context, t_32973);
      if(term == null)
        break Fail1321;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionKeyword_2, new IStrategoTerm[]{v_32973, term}), checkListAnnos(termFactory, u_32973));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}