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

@SuppressWarnings("all") public class $Fold$Rule$All_2_0 extends Strategy 
{ 
  public static $Fold$Rule$All_2_0 instance = new $Fold$Rule$All_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_9752, Strategy o_9752)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("FoldRuleAll_2_0");
    Fail458:
    { 
      IStrategoTerm n_9928 = null;
      IStrategoTerm l_9928 = null;
      IStrategoTerm m_9928 = null;
      IStrategoTerm o_9928 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consFoldRuleAll_2 != ((IStrategoAppl)term).getConstructor())
        break Fail458;
      l_9928 = term.getSubterm(0);
      m_9928 = term.getSubterm(1);
      IStrategoList annos32 = term.getAnnotations();
      n_9928 = annos32;
      term = n_9752.invoke(context, l_9928);
      if(term == null)
        break Fail458;
      o_9928 = term;
      term = o_9752.invoke(context, m_9928);
      if(term == null)
        break Fail458;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consFoldRuleAll_2, new IStrategoTerm[]{o_9928, term}), checkListAnnos(termFactory, n_9928));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}