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

@SuppressWarnings("all") public class rename_template_element_0_0 extends Strategy 
{ 
  public static rename_template_element_0_0 instance = new rename_template_element_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("rename_template_element_0_0");
    Fail53:
    { 
      IStrategoTerm o_9710 = null;
      IStrategoTerm p_9710 = null;
      IStrategoTerm q_9710 = null;
      IStrategoTerm r_9710 = null;
      TermReference s_9710 = new TermReference();
      TermReference t_9710 = new TermReference();
      TermReference u_9710 = new TermReference();
      IStrategoTerm v_9710 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail53;
      IStrategoTerm arg33 = term.getSubterm(0);
      if(arg33.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg33).getConstructor())
        break Fail53;
      o_9710 = arg33.getSubterm(0);
      p_9710 = arg33.getSubterm(1);
      q_9710 = arg33.getSubterm(2);
      r_9710 = arg33.getSubterm(3);
      if(t_9710.value == null)
        t_9710.value = term.getSubterm(1);
      else
        if(t_9710.value != term.getSubterm(1) && !t_9710.value.match(term.getSubterm(1)))
          break Fail53;
      v_9710 = term;
      lifted32 lifted3210 = new lifted32();
      lifted3210.s_9710 = s_9710;
      lifted3210.t_9710 = t_9710;
      lifted3210.u_9710 = u_9710;
      term = with_spxverify_2_0.instance.invoke(context, term, lifted3210, lifted33.instance);
      if(term == null)
        break Fail53;
      term = v_9710;
      if(s_9710.value == null || u_9710.value == null)
        break Fail53;
      term = termFactory.makeTuple(termFactory.annotateTerm(termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{o_9710, p_9710, q_9710, r_9710}), checkListAnnos(termFactory, (IStrategoTerm)termFactory.makeListCons(s_9710.value, (IStrategoList)generated.constNil0))), u_9710.value);
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}