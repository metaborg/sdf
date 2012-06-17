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

@SuppressWarnings("all") public class $Constructor$Only_1_0 extends Strategy 
{ 
  public static $Constructor$Only_1_0 instance = new $Constructor$Only_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ConstructorOnly_1_0");
    Fail1331:
    { 
      IStrategoTerm n_32975 = null;
      IStrategoTerm m_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consConstructorOnly_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1331;
      m_32975 = term.getSubterm(0);
      IStrategoList annos102 = term.getAnnotations();
      n_32975 = annos102;
      term = f_32794.invoke(context, m_32975);
      if(term == null)
        break Fail1331;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consConstructorOnly_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}