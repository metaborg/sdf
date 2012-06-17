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

@SuppressWarnings("all") public class $Sdf$Production$With$Cons_3_0 extends Strategy 
{ 
  public static $Sdf$Production$With$Cons_3_0 instance = new $Sdf$Production$With$Cons_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_32794, Strategy w_32794, Strategy x_32794)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SdfProductionWithCons_3_0");
    Fail1346:
    { 
      IStrategoTerm h_32977 = null;
      IStrategoTerm e_32977 = null;
      IStrategoTerm f_32977 = null;
      IStrategoTerm g_32977 = null;
      IStrategoTerm i_32977 = null;
      IStrategoTerm j_32977 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSdfProductionWithCons_3 != ((IStrategoAppl)term).getConstructor())
        break Fail1346;
      e_32977 = term.getSubterm(0);
      f_32977 = term.getSubterm(1);
      g_32977 = term.getSubterm(2);
      IStrategoList annos114 = term.getAnnotations();
      h_32977 = annos114;
      term = v_32794.invoke(context, e_32977);
      if(term == null)
        break Fail1346;
      i_32977 = term;
      term = w_32794.invoke(context, f_32977);
      if(term == null)
        break Fail1346;
      j_32977 = term;
      term = x_32794.invoke(context, g_32977);
      if(term == null)
        break Fail1346;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consSdfProductionWithCons_3, new IStrategoTerm[]{i_32977, j_32977, term}), checkListAnnos(termFactory, h_32977));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}