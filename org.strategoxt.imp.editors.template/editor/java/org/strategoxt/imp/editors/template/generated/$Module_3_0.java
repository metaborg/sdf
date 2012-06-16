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

@SuppressWarnings("all") public class $Module_3_0 extends Strategy 
{ 
  public static $Module_3_0 instance = new $Module_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_9751, Strategy l_9751, Strategy m_9751)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Module_3_0");
    Fail417:
    { 
      IStrategoTerm t_9925 = null;
      IStrategoTerm q_9925 = null;
      IStrategoTerm r_9925 = null;
      IStrategoTerm s_9925 = null;
      IStrategoTerm u_9925 = null;
      IStrategoTerm v_9925 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consModule_3 != ((IStrategoAppl)term).getConstructor())
        break Fail417;
      q_9925 = term.getSubterm(0);
      r_9925 = term.getSubterm(1);
      s_9925 = term.getSubterm(2);
      IStrategoList annos17 = term.getAnnotations();
      t_9925 = annos17;
      term = k_9751.invoke(context, q_9925);
      if(term == null)
        break Fail417;
      u_9925 = term;
      term = l_9751.invoke(context, r_9925);
      if(term == null)
        break Fail417;
      v_9925 = term;
      term = m_9751.invoke(context, s_9925);
      if(term == null)
        break Fail417;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consModule_3, new IStrategoTerm[]{u_9925, v_9925, term}), checkListAnnos(termFactory, t_9925));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}