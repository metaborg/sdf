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

@SuppressWarnings("all") public class $Tokenize_1_0 extends Strategy 
{ 
  public static $Tokenize_1_0 instance = new $Tokenize_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_32795)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Tokenize_1_0");
    Fail1354:
    { 
      IStrategoTerm e_32978 = null;
      IStrategoTerm d_32978 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTokenize_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1354;
      d_32978 = term.getSubterm(0);
      IStrategoList annos119 = term.getAnnotations();
      e_32978 = annos119;
      term = f_32795.invoke(context, d_32978);
      if(term == null)
        break Fail1354;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTokenize_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, e_32978));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}