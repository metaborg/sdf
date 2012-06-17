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

@SuppressWarnings("all") public class $Builders_2_0 extends Strategy 
{ 
  public static $Builders_2_0 instance = new $Builders_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_32791, Strategy a_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Builders_2_0");
    Fail1302:
    { 
      IStrategoTerm z_32969 = null;
      IStrategoTerm x_32969 = null;
      IStrategoTerm y_32969 = null;
      IStrategoTerm a_32970 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBuilders_2 != ((IStrategoAppl)term).getConstructor())
        break Fail1302;
      x_32969 = term.getSubterm(0);
      y_32969 = term.getSubterm(1);
      IStrategoList annos73 = term.getAnnotations();
      z_32969 = annos73;
      term = z_32791.invoke(context, x_32969);
      if(term == null)
        break Fail1302;
      a_32970 = term;
      term = a_32792.invoke(context, y_32969);
      if(term == null)
        break Fail1302;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBuilders_2, new IStrategoTerm[]{a_32970, term}), checkListAnnos(termFactory, z_32969));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}