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

@SuppressWarnings("all") public class $Sort$And$Constructor_2_0 extends Strategy 
{ 
  public static $Sort$And$Constructor_2_0 instance = new $Sort$And$Constructor_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_32794, Strategy d_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SortAndConstructor_2_0");
    Fail1329:
    { 
      IStrategoTerm g_32975 = null;
      IStrategoTerm e_32975 = null;
      IStrategoTerm f_32975 = null;
      IStrategoTerm h_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSortAndConstructor_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1329;
      e_32975 = term.getSubterm(0);
      f_32975 = term.getSubterm(1);
      IStrategoList annos100 = term.getAnnotations();
      g_32975 = annos100;
      term = c_32794.invoke(context, e_32975);
      if(term == null)
        break Fail1329;
      h_32975 = term;
      term = d_32794.invoke(context, f_32975);
      if(term == null)
        break Fail1329;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSortAndConstructor_2, new IStrategoTerm[]{h_32975, term}), checkListAnnos(termFactory, g_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}