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

@SuppressWarnings("all") public class $Completion$Template$Ex_4_0 extends Strategy 
{ 
  public static $Completion$Template$Ex_4_0 instance = new $Completion$Template$Ex_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_32793, Strategy b_32793, Strategy c_32793, Strategy d_32793)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("CompletionTemplateEx_4_0");
    Fail1317:
    { 
      IStrategoTerm s_32972 = null;
      IStrategoTerm o_32972 = null;
      IStrategoTerm p_32972 = null;
      IStrategoTerm q_32972 = null;
      IStrategoTerm r_32972 = null;
      IStrategoTerm t_32972 = null;
      IStrategoTerm u_32972 = null;
      IStrategoTerm v_32972 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consCompletionTemplateEx_4 != ((IStrategoAppl)term).getConstructor())
        break Fail1317;
      o_32972 = term.getSubterm(0);
      p_32972 = term.getSubterm(1);
      q_32972 = term.getSubterm(2);
      r_32972 = term.getSubterm(3);
      IStrategoList annos88 = term.getAnnotations();
      s_32972 = annos88;
      term = a_32793.invoke(context, o_32972);
      if(term == null)
        break Fail1317;
      t_32972 = term;
      term = b_32793.invoke(context, p_32972);
      if(term == null)
        break Fail1317;
      u_32972 = term;
      term = c_32793.invoke(context, q_32972);
      if(term == null)
        break Fail1317;
      v_32972 = term;
      term = d_32793.invoke(context, r_32972);
      if(term == null)
        break Fail1317;
      term = termFactory.annotateTerm(termFactory.makeAppl(Main._consCompletionTemplateEx_4, new IStrategoTerm[]{t_32972, u_32972, v_32972, term}), checkListAnnos(termFactory, s_32972));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}