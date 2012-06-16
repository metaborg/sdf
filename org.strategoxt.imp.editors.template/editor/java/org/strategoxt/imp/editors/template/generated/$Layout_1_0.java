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

@SuppressWarnings("all") public class $Layout_1_0 extends Strategy 
{ 
  public static $Layout_1_0 instance = new $Layout_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy b_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Layout_1_0");
    Fail516:
    { 
      IStrategoTerm t_9937 = null;
      IStrategoTerm s_9937 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)term).getConstructor())
        break Fail516;
      s_9937 = term.getSubterm(0);
      IStrategoList annos89 = term.getAnnotations();
      t_9937 = annos89;
      term = b_9756.invoke(context, s_9937);
      if(term == null)
        break Fail516;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLayout_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, t_9937));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}