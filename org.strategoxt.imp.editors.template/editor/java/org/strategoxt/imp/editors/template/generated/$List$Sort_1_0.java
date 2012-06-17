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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ListSort_1_0");
    Fail1333:
    { 
      IStrategoTerm t_32975 = null;
      IStrategoTerm s_32975 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consListSort_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1333;
      s_32975 = term.getSubterm(0);
      IStrategoList annos104 = term.getAnnotations();
      t_32975 = annos104;
      term = h_32794.invoke(context, s_32975);
      if(term == null)
        break Fail1333;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consListSort_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, t_32975));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}