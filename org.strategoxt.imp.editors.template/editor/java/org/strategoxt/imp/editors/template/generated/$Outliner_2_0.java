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

@SuppressWarnings("all") public class $Outliner_2_0 extends Strategy 
{ 
  public static $Outliner_2_0 instance = new $Outliner_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_9753, Strategy z_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Outliner_2_0");
    Fail486:
    { 
      IStrategoTerm k_9932 = null;
      IStrategoTerm i_9932 = null;
      IStrategoTerm j_9932 = null;
      IStrategoTerm l_9932 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOutliner_2 != ((IStrategoAppl)term).getConstructor())
        break Fail486;
      i_9932 = term.getSubterm(0);
      j_9932 = term.getSubterm(1);
      IStrategoList annos59 = term.getAnnotations();
      k_9932 = annos59;
      term = y_9753.invoke(context, i_9932);
      if(term == null)
        break Fail486;
      l_9932 = term;
      term = z_9753.invoke(context, j_9932);
      if(term == null)
        break Fail486;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOutliner_2, new IStrategoTerm[]{l_9932, term}), checkListAnnos(termFactory, k_9932));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}