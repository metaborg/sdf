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

@SuppressWarnings("all") public class $List$Sort_1_0 extends Strategy 
{ 
  public static $List$Sort_1_0 instance = new $List$Sort_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_9755)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ListSort_1_0");
    Fail513:
    { 
      IStrategoTerm k_9937 = null;
      IStrategoTerm j_9937 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consListSort_1 != ((IStrategoAppl)term).getConstructor())
        break Fail513;
      j_9937 = term.getSubterm(0);
      IStrategoList annos86 = term.getAnnotations();
      k_9937 = annos86;
      term = y_9755.invoke(context, j_9937);
      if(term == null)
        break Fail513;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consListSort_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, k_9937));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}