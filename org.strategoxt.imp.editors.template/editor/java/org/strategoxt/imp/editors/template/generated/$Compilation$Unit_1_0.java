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

@SuppressWarnings("all") public class $Compilation$Unit_1_0 extends Strategy 
{ 
  public static $Compilation$Unit_1_0 instance = new $Compilation$Unit_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompilationUnit_1_0");
    Fail515:
    { 
      IStrategoTerm q_9937 = null;
      IStrategoTerm p_9937 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompilationUnit_1 != ((IStrategoAppl)term).getConstructor())
        break Fail515;
      p_9937 = term.getSubterm(0);
      IStrategoList annos88 = term.getAnnotations();
      q_9937 = annos88;
      term = a_9756.invoke(context, p_9937);
      if(term == null)
        break Fail515;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompilationUnit_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_9937));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}