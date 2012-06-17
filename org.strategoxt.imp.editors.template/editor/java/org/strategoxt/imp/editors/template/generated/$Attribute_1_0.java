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

@SuppressWarnings("all") public class $Attribute_1_0 extends Strategy 
{ 
  public static $Attribute_1_0 instance = new $Attribute_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Attribute_1_0");
    Fail1309:
    { 
      IStrategoTerm h_32971 = null;
      IStrategoTerm g_32971 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consAttribute_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1309;
      g_32971 = term.getSubterm(0);
      IStrategoList annos80 = term.getAnnotations();
      h_32971 = annos80;
      term = n_32792.invoke(context, g_32971);
      if(term == null)
        break Fail1309;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consAttribute_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, h_32971));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}