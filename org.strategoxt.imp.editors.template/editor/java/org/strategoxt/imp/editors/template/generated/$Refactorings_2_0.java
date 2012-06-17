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

@SuppressWarnings("all") public class $Refactorings_2_0 extends Strategy 
{ 
  public static $Refactorings_2_0 instance = new $Refactorings_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_32791, Strategy y_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Refactorings_2_0");
    Fail1301:
    { 
      IStrategoTerm u_32969 = null;
      IStrategoTerm s_32969 = null;
      IStrategoTerm t_32969 = null;
      IStrategoTerm v_32969 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consRefactorings_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1301;
      s_32969 = term.getSubterm(0);
      t_32969 = term.getSubterm(1);
      IStrategoList annos72 = term.getAnnotations();
      u_32969 = annos72;
      term = x_32791.invoke(context, s_32969);
      if(term == null)
        break Fail1301;
      v_32969 = term;
      term = y_32791.invoke(context, t_32969);
      if(term == null)
        break Fail1301;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consRefactorings_2, new IStrategoTerm[]{v_32969, term}), checkListAnnos(termFactory, u_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}