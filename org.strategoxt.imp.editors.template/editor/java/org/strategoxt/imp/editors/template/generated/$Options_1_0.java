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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Options_1_0");
    Fail1360:
    { 
      IStrategoTerm w_32978 = null;
      IStrategoTerm v_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consOptions_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1360;
      v_32978 = term.getSubterm(0);
      IStrategoList annos125 = term.getAnnotations();
      w_32978 = annos125;
      term = l_32795.invoke(context, v_32978);
      if(term == null)
        break Fail1360;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consOptions_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}