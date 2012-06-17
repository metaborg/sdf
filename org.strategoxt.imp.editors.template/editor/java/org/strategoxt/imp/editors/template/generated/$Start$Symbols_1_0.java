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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("StartSymbols_1_0");
    Fail1293:
    { 
      IStrategoTerm v_32968 = null;
      IStrategoTerm u_32968 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consStartSymbols_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1293;
      u_32968 = term.getSubterm(0);
      IStrategoList annos64 = term.getAnnotations();
      v_32968 = annos64;
      term = p_32791.invoke(context, u_32968);
      if(term == null)
        break Fail1293;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consStartSymbols_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, v_32968));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}