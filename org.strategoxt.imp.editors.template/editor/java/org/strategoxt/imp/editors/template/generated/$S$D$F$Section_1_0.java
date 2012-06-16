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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SDFSection_1_0");
    Fail537:
    { 
      IStrategoTerm e_9940 = null;
      IStrategoTerm d_9940 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSDFSection_1 != ((IStrategoAppl)term).getConstructor())
        break Fail537;
      d_9940 = term.getSubterm(0);
      IStrategoList annos104 = term.getAnnotations();
      e_9940 = annos104;
      term = z_9756.invoke(context, d_9940);
      if(term == null)
        break Fail537;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSDFSection_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, e_9940));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}