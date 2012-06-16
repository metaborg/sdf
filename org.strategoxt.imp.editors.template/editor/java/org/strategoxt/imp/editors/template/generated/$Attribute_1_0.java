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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_9754)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Attribute_1_0");
    Fail489:
    { 
      IStrategoTerm y_9932 = null;
      IStrategoTerm x_9932 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consAttribute_1 != ((IStrategoAppl)term).getConstructor())
        break Fail489;
      x_9932 = term.getSubterm(0);
      IStrategoList annos62 = term.getAnnotations();
      y_9932 = annos62;
      term = e_9754.invoke(context, x_9932);
      if(term == null)
        break Fail489;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consAttribute_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, y_9932));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}