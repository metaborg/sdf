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

@SuppressWarnings("all") public class $Description_1_0 extends Strategy 
{ 
  public static $Description_1_0 instance = new $Description_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy s_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Description_1_0");
    Fail1296:
    { 
      IStrategoTerm e_32969 = null;
      IStrategoTerm d_32969 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consDescription_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1296;
      d_32969 = term.getSubterm(0);
      IStrategoList annos67 = term.getAnnotations();
      e_32969 = annos67;
      term = s_32791.invoke(context, d_32969);
      if(term == null)
        break Fail1296;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consDescription_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, e_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}