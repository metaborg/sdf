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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompilationUnit_1_0");
    Fail1335:
    { 
      IStrategoTerm z_32975 = null;
      IStrategoTerm y_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompilationUnit_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1335;
      y_32975 = term.getSubterm(0);
      IStrategoList annos106 = term.getAnnotations();
      z_32975 = annos106;
      term = j_32794.invoke(context, y_32975);
      if(term == null)
        break Fail1335;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompilationUnit_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, z_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}