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

@SuppressWarnings("all") public class $Literal_1_0 extends Strategy 
{ 
  public static $Literal_1_0 instance = new $Literal_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Literal_1_0");
    Fail447:
    { 
      IStrategoTerm q_9926 = null;
      IStrategoTerm p_9926 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLiteral_1 != ((IStrategoAppl)term).getConstructor())
        break Fail447;
      p_9926 = term.getSubterm(0);
      IStrategoList annos22 = term.getAnnotations();
      q_9926 = annos22;
      term = u_9751.invoke(context, p_9926);
      if(term == null)
        break Fail447;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLiteral_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_9926));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}