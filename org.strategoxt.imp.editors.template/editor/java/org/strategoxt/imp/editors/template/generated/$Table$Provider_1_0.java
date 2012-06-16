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

@SuppressWarnings("all") public class $Table$Provider_1_0 extends Strategy 
{ 
  public static $Table$Provider_1_0 instance = new $Table$Provider_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("TableProvider_1_0");
    Fail474:
    { 
      IStrategoTerm p_9930 = null;
      IStrategoTerm o_9930 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTableProvider_1 != ((IStrategoAppl)term).getConstructor())
        break Fail474;
      o_9930 = term.getSubterm(0);
      IStrategoList annos47 = term.getAnnotations();
      p_9930 = annos47;
      term = h_9753.invoke(context, o_9930);
      if(term == null)
        break Fail474;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTableProvider_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, p_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}