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

@SuppressWarnings("all") public class $Escape_1_0 extends Strategy 
{ 
  public static $Escape_1_0 instance = new $Escape_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy c_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Escape_1_0");
    Fail517:
    { 
      IStrategoTerm w_9937 = null;
      IStrategoTerm v_9937 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consEscape_1 != ((IStrategoAppl)term).getConstructor())
        break Fail517;
      v_9937 = term.getSubterm(0);
      IStrategoList annos90 = term.getAnnotations();
      w_9937 = annos90;
      term = c_9756.invoke(context, v_9937);
      if(term == null)
        break Fail517;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consEscape_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, w_9937));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}