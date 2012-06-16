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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Template_1_0");
    Fail520:
    { 
      IStrategoTerm f_9938 = null;
      IStrategoTerm e_9938 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
        break Fail520;
      e_9938 = term.getSubterm(0);
      IStrategoList annos93 = term.getAnnotations();
      f_9938 = annos93;
      term = f_9756.invoke(context, e_9938);
      if(term == null)
        break Fail520;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, f_9938));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}