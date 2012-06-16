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

@SuppressWarnings("all") public class $Sort_1_0 extends Strategy 
{ 
  public static $Sort_1_0 instance = new $Sort_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Sort_1_0");
    Fail514:
    { 
      IStrategoTerm n_9937 = null;
      IStrategoTerm m_9937 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSort_1 != ((IStrategoAppl)term).getConstructor())
        break Fail514;
      m_9937 = term.getSubterm(0);
      IStrategoList annos87 = term.getAnnotations();
      n_9937 = annos87;
      term = z_9755.invoke(context, m_9937);
      if(term == null)
        break Fail514;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSort_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_9937));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}