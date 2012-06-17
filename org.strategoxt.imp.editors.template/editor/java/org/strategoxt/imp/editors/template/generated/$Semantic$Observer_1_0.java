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

@SuppressWarnings("all") public class $Semantic$Observer_1_0 extends Strategy 
{ 
  public static $Semantic$Observer_1_0 instance = new $Semantic$Observer_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SemanticObserver_1_0");
    Fail1316:
    { 
      IStrategoTerm m_32972 = null;
      IStrategoTerm l_32972 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSemanticObserver_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1316;
      l_32972 = term.getSubterm(0);
      IStrategoList annos87 = term.getAnnotations();
      m_32972 = annos87;
      term = z_32792.invoke(context, l_32972);
      if(term == null)
        break Fail1316;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSemanticObserver_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, m_32972));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}