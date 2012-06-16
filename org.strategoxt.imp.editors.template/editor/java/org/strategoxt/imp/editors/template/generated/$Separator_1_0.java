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

@SuppressWarnings("all") public class $Separator_1_0 extends Strategy 
{ 
  public static $Separator_1_0 instance = new $Separator_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Separator_1_0");
    Fail544:
    { 
      IStrategoTerm w_9940 = null;
      IStrategoTerm v_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSeparator_1 != ((IStrategoAppl)term).getConstructor())
        break Fail544;
      v_9940 = term.getSubterm(0);
      IStrategoList annos110 = term.getAnnotations();
      w_9940 = annos110;
      term = f_9757.invoke(context, v_9940);
      if(term == null)
        break Fail544;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}