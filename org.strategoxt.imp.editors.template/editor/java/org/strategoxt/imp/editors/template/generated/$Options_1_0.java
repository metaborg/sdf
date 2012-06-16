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

@SuppressWarnings("all") public class $Options_1_0 extends Strategy 
{ 
  public static $Options_1_0 instance = new $Options_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_9757)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Options_1_0");
    Fail540:
    { 
      IStrategoTerm n_9940 = null;
      IStrategoTerm m_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOptions_1 != ((IStrategoAppl)term).getConstructor())
        break Fail540;
      m_9940 = term.getSubterm(0);
      IStrategoList annos107 = term.getAnnotations();
      n_9940 = annos107;
      term = c_9757.invoke(context, m_9940);
      if(term == null)
        break Fail540;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOptions_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}