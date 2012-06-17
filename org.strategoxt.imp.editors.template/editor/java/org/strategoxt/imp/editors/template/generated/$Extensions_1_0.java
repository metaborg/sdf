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

@SuppressWarnings("all") public class $Extensions_1_0 extends Strategy 
{ 
  public static $Extensions_1_0 instance = new $Extensions_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_32791)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Extensions_1_0");
    Fail1297:
    { 
      IStrategoTerm h_32969 = null;
      IStrategoTerm g_32969 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consExtensions_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1297;
      g_32969 = term.getSubterm(0);
      IStrategoList annos68 = term.getAnnotations();
      h_32969 = annos68;
      term = t_32791.invoke(context, g_32969);
      if(term == null)
        break Fail1297;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consExtensions_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, h_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}