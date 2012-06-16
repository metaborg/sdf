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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_9753)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Extends_1_0");
    Fail471:
    { 
      IStrategoTerm g_9930 = null;
      IStrategoTerm f_9930 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consExtends_1 != ((IStrategoAppl)term).getConstructor())
        break Fail471;
      f_9930 = term.getSubterm(0);
      IStrategoList annos44 = term.getAnnotations();
      g_9930 = annos44;
      term = e_9753.invoke(context, f_9930);
      if(term == null)
        break Fail471;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consExtends_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, g_9930));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}