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

@SuppressWarnings("all") public class $Extends_1_0 extends Strategy 
{ 
  public static $Extends_1_0 instance = new $Extends_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Extends_1_0");
    Fail1291:
    { 
      IStrategoTerm p_32968 = null;
      IStrategoTerm o_32968 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consExtends_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1291;
      o_32968 = term.getSubterm(0);
      IStrategoList annos62 = term.getAnnotations();
      p_32968 = annos62;
      term = n_32791.invoke(context, o_32968);
      if(term == null)
        break Fail1291;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consExtends_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, p_32968));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}