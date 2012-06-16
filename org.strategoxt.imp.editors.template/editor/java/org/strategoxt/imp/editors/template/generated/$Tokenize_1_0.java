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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_9756)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Tokenize_1_0");
    Fail534:
    { 
      IStrategoTerm v_9939 = null;
      IStrategoTerm u_9939 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consTokenize_1 != ((IStrategoAppl)term).getConstructor())
        break Fail534;
      u_9939 = term.getSubterm(0);
      IStrategoList annos101 = term.getAnnotations();
      v_9939 = annos101;
      term = w_9756.invoke(context, u_9939);
      if(term == null)
        break Fail534;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consTokenize_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, v_9939));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}