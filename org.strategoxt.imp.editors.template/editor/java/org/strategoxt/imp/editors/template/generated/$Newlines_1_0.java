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

@SuppressWarnings("all") public class $Newlines_1_0 extends Strategy 
{ 
  public static $Newlines_1_0 instance = new $Newlines_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Newlines_1_0");
    Fail1356:
    { 
      IStrategoTerm k_32978 = null;
      IStrategoTerm j_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consNewlines_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1356;
      j_32978 = term.getSubterm(0);
      IStrategoList annos121 = term.getAnnotations();
      k_32978 = annos121;
      term = h_32795.invoke(context, j_32978);
      if(term == null)
        break Fail1356;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consNewlines_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}