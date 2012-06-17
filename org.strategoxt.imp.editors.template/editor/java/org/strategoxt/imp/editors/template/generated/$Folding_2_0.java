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

@SuppressWarnings("all") public class $Folding_2_0 extends Strategy 
{ 
  public static $Folding_2_0 instance = new $Folding_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_32792, Strategy k_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Folding_2_0");
    Fail1307:
    { 
      IStrategoTerm y_32970 = null;
      IStrategoTerm w_32970 = null;
      IStrategoTerm x_32970 = null;
      IStrategoTerm z_32970 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFolding_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1307;
      w_32970 = term.getSubterm(0);
      x_32970 = term.getSubterm(1);
      IStrategoList annos78 = term.getAnnotations();
      y_32970 = annos78;
      term = j_32792.invoke(context, w_32970);
      if(term == null)
        break Fail1307;
      z_32970 = term;
      term = k_32792.invoke(context, x_32970);
      if(term == null)
        break Fail1307;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFolding_2, new IStrategoTerm[]{z_32970, term}), checkListAnnos(termFactory, y_32970));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}