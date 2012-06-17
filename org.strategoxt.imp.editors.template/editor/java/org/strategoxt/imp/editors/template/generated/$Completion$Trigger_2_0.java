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

@SuppressWarnings("all") public class $Completion$Trigger_2_0 extends Strategy 
{ 
  public static $Completion$Trigger_2_0 instance = new $Completion$Trigger_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_32793, Strategy f_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTrigger_2_0");
    Fail1318:
    { 
      IStrategoTerm z_32972 = null;
      IStrategoTerm x_32972 = null;
      IStrategoTerm y_32972 = null;
      IStrategoTerm a_32973 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTrigger_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1318;
      x_32972 = term.getSubterm(0);
      y_32972 = term.getSubterm(1);
      IStrategoList annos89 = term.getAnnotations();
      z_32972 = annos89;
      term = e_32793.invoke(context, x_32972);
      if(term == null)
        break Fail1318;
      a_32973 = term;
      term = f_32793.invoke(context, y_32972);
      if(term == null)
        break Fail1318;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTrigger_2, new IStrategoTerm[]{a_32973, term}), checkListAnnos(termFactory, z_32972));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}