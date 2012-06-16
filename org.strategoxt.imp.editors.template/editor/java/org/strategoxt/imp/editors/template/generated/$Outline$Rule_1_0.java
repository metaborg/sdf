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

@SuppressWarnings("all") public class $Outline$Rule_1_0 extends Strategy 
{ 
  public static $Outline$Rule_1_0 instance = new $Outline$Rule_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("OutlineRule_1_0");
    Fail456:
    { 
      IStrategoTerm j_9928 = null;
      IStrategoTerm i_9928 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOutlineRule_1 != ((IStrategoAppl)term).getConstructor())
        break Fail456;
      i_9928 = term.getSubterm(0);
      IStrategoList annos31 = term.getAnnotations();
      j_9928 = annos31;
      term = m_9752.invoke(context, i_9928);
      if(term == null)
        break Fail456;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOutlineRule_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, j_9928));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}