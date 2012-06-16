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

@SuppressWarnings("all") public class $P$P$Table_1_0 extends Strategy 
{ 
  public static $P$P$Table_1_0 instance = new $P$P$Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("PPTable_1_0");
    Fail493:
    { 
      IStrategoTerm q_9933 = null;
      IStrategoTerm p_9933 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consPPTable_1 != ((IStrategoAppl)term).getConstructor())
        break Fail493;
      p_9933 = term.getSubterm(0);
      IStrategoList annos66 = term.getAnnotations();
      q_9933 = annos66;
      term = l_9754.invoke(context, p_9933);
      if(term == null)
        break Fail493;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consPPTable_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, q_9933));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}