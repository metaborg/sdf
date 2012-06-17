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

@SuppressWarnings("all") public class $W$A$T$E$R_1_0 extends Strategy 
{ 
  public static $W$A$T$E$R_1_0 instance = new $W$A$T$E$R_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy m_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("WATER_1_0");
    Fail1362:
    { 
      IStrategoTerm z_32978 = null;
      IStrategoTerm y_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consWATER_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1362;
      y_32978 = term.getSubterm(0);
      IStrategoList annos126 = term.getAnnotations();
      z_32978 = annos126;
      term = m_32795.invoke(context, y_32978);
      if(term == null)
        break Fail1362;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consWATER_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, z_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}