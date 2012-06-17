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

@SuppressWarnings("all") public class $S$D$F$Section_1_0 extends Strategy 
{ 
  public static $S$D$F$Section_1_0 instance = new $S$D$F$Section_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SDFSection_1_0");
    Fail1357:
    { 
      IStrategoTerm n_32978 = null;
      IStrategoTerm m_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1357;
      m_32978 = term.getSubterm(0);
      IStrategoList annos122 = term.getAnnotations();
      n_32978 = annos122;
      term = i_32795.invoke(context, m_32978);
      if(term == null)
        break Fail1357;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSDFSection_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, n_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}