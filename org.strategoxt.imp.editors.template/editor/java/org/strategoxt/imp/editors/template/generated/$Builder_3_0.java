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

@SuppressWarnings("all") public class $Builder_3_0 extends Strategy 
{ 
  public static $Builder_3_0 instance = new $Builder_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy w_32792, Strategy x_32792, Strategy y_32792)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Builder_3_0");
    Fail1315:
    { 
      IStrategoTerm h_32972 = null;
      IStrategoTerm e_32972 = null;
      IStrategoTerm f_32972 = null;
      IStrategoTerm g_32972 = null;
      IStrategoTerm i_32972 = null;
      IStrategoTerm j_32972 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consBuilder_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1315;
      e_32972 = term.getSubterm(0);
      f_32972 = term.getSubterm(1);
      g_32972 = term.getSubterm(2);
      IStrategoList annos86 = term.getAnnotations();
      h_32972 = annos86;
      term = w_32792.invoke(context, e_32972);
      if(term == null)
        break Fail1315;
      i_32972 = term;
      term = x_32792.invoke(context, f_32972);
      if(term == null)
        break Fail1315;
      j_32972 = term;
      term = y_32792.invoke(context, g_32972);
      if(term == null)
        break Fail1315;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consBuilder_3, new IStrategoTerm[]{i_32972, j_32972, term}), checkListAnnos(termFactory, h_32972));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}