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

@SuppressWarnings("all") public class $Color$Rule$All_2_0 extends Strategy 
{ 
  public static $Color$Rule$All_2_0 instance = new $Color$Rule$All_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_9752, Strategy l_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("ColorRuleAll_2_0");
    Fail455:
    { 
      IStrategoTerm f_9928 = null;
      IStrategoTerm d_9928 = null;
      IStrategoTerm e_9928 = null;
      IStrategoTerm g_9928 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consColorRuleAll_2 != ((IStrategoAppl)term).getConstructor())
        break Fail455;
      d_9928 = term.getSubterm(0);
      e_9928 = term.getSubterm(1);
      IStrategoList annos30 = term.getAnnotations();
      f_9928 = annos30;
      term = k_9752.invoke(context, d_9928);
      if(term == null)
        break Fail455;
      g_9928 = term;
      term = l_9752.invoke(context, e_9928);
      if(term == null)
        break Fail455;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consColorRuleAll_2, new IStrategoTerm[]{g_9928, term}), checkListAnnos(termFactory, f_9928));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}