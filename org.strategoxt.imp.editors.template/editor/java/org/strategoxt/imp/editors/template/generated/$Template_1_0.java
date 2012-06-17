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

@SuppressWarnings("all") public class $Template_1_0 extends Strategy 
{ 
  public static $Template_1_0 instance = new $Template_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Template_1_0");
    Fail1340:
    { 
      IStrategoTerm o_32976 = null;
      IStrategoTerm n_32976 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1340;
      n_32976 = term.getSubterm(0);
      IStrategoList annos111 = term.getAnnotations();
      o_32976 = annos111;
      term = o_32794.invoke(context, n_32976);
      if(term == null)
        break Fail1340;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, o_32976));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}