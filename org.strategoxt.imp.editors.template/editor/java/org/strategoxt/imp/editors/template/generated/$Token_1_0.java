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

@SuppressWarnings("all") public class $Token_1_0 extends Strategy 
{ 
  public static $Token_1_0 instance = new $Token_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Token_1_0");
    Fail1268:
    { 
      IStrategoTerm c_32965 = null;
      IStrategoTerm b_32965 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consToken_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1268;
      b_32965 = term.getSubterm(0);
      IStrategoList annos41 = term.getAnnotations();
      c_32965 = annos41;
      term = e_32790.invoke(context, b_32965);
      if(term == null)
        break Fail1268;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consToken_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, c_32965));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}