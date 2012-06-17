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

@SuppressWarnings("all") public class $Completion$Template$With$Sort_4_0 extends Strategy 
{ 
  public static $Completion$Template$With$Sort_4_0 instance = new $Completion$Template$With$Sort_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_32793, Strategy h_32793, Strategy i_32793, Strategy j_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTemplateWithSort_4_0");
    Fail1319:
    { 
      IStrategoTerm g_32973 = null;
      IStrategoTerm c_32973 = null;
      IStrategoTerm d_32973 = null;
      IStrategoTerm e_32973 = null;
      IStrategoTerm f_32973 = null;
      IStrategoTerm h_32973 = null;
      IStrategoTerm i_32973 = null;
      IStrategoTerm j_32973 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTemplateWithSort_4 != ((IStrategoAppl)term).getConstructor())
        break Fail1319;
      c_32973 = term.getSubterm(0);
      d_32973 = term.getSubterm(1);
      e_32973 = term.getSubterm(2);
      f_32973 = term.getSubterm(3);
      IStrategoList annos90 = term.getAnnotations();
      g_32973 = annos90;
      term = g_32793.invoke(context, c_32973);
      if(term == null)
        break Fail1319;
      h_32973 = term;
      term = h_32793.invoke(context, d_32973);
      if(term == null)
        break Fail1319;
      i_32973 = term;
      term = i_32793.invoke(context, e_32973);
      if(term == null)
        break Fail1319;
      j_32973 = term;
      term = j_32793.invoke(context, f_32973);
      if(term == null)
        break Fail1319;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTemplateWithSort_4, new IStrategoTerm[]{h_32973, i_32973, j_32973, term}), checkListAnnos(termFactory, g_32973));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}