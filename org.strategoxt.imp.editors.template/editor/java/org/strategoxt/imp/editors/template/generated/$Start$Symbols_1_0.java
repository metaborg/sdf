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

@SuppressWarnings("all") public class $Start$Symbols_1_0 extends Strategy 
{ 
  public static $Start$Symbols_1_0 instance = new $Start$Symbols_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("StartSymbols_1_0");
    Fail473:
    { 
      IStrategoTerm m_9930 = null;
      IStrategoTerm l_9930 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consStartSymbols_1 != ((IStrategoAppl)term).getConstructor())
        break Fail473;
      l_9930 = term.getSubterm(0);
      IStrategoList annos46 = term.getAnnotations();
      m_9930 = annos46;
      term = g_9753.invoke(context, l_9930);
      if(term == null)
        break Fail473;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consStartSymbols_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, m_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}