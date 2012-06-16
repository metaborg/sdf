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

@SuppressWarnings("all") public class $Table_1_0 extends Strategy 
{ 
  public static $Table_1_0 instance = new $Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Table_1_0");
    Fail475:
    { 
      IStrategoTerm s_9930 = null;
      IStrategoTerm r_9930 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTable_1 != ((IStrategoAppl)term).getConstructor())
        break Fail475;
      r_9930 = term.getSubterm(0);
      IStrategoList annos48 = term.getAnnotations();
      s_9930 = annos48;
      term = i_9753.invoke(context, r_9930);
      if(term == null)
        break Fail475;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTable_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, s_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}