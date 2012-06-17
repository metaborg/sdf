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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Sort_1_0");
    Fail1334:
    { 
      IStrategoTerm w_32975 = null;
      IStrategoTerm v_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSort_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1334;
      v_32975 = term.getSubterm(0);
      IStrategoList annos105 = term.getAnnotations();
      w_32975 = annos105;
      term = i_32794.invoke(context, v_32975);
      if(term == null)
        break Fail1334;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSort_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}