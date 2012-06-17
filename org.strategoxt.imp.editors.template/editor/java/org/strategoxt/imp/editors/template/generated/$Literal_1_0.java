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

@SuppressWarnings("all") public class $Literal_1_0 extends Strategy 
{ 
  public static $Literal_1_0 instance = new $Literal_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_32790)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Literal_1_0");
    Fail1267:
    { 
      IStrategoTerm z_32964 = null;
      IStrategoTerm y_32964 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLiteral_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1267;
      y_32964 = term.getSubterm(0);
      IStrategoList annos40 = term.getAnnotations();
      z_32964 = annos40;
      term = d_32790.invoke(context, y_32964);
      if(term == null)
        break Fail1267;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consLiteral_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, z_32964));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}