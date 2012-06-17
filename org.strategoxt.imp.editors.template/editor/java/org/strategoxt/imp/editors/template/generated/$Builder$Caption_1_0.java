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

@SuppressWarnings("all") public class $Builder$Caption_1_0 extends Strategy 
{ 
  public static $Builder$Caption_1_0 instance = new $Builder$Caption_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("BuilderCaption_1_0");
    Fail1314:
    { 
      IStrategoTerm c_32972 = null;
      IStrategoTerm b_32972 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBuilderCaption_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1314;
      b_32972 = term.getSubterm(0);
      IStrategoList annos85 = term.getAnnotations();
      c_32972 = annos85;
      term = v_32792.invoke(context, b_32972);
      if(term == null)
        break Fail1314;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBuilderCaption_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, c_32972));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}