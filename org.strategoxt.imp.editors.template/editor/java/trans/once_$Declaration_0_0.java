package trans;

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

@SuppressWarnings("all") public class once_$Declaration_0_0 extends Strategy 
{ 
  public static once_$Declaration_0_0 instance = new once_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("once_Declaration_0_0");
    Fail145:
    { 
      IStrategoTerm e_10727 = null;
      TermReference f_10727 = new TermReference();
      TermReference g_10727 = new TermReference();
      TermReference h_10727 = new TermReference();
      IStrategoTerm i_10727 = null;
      TermReference j_10727 = new TermReference();
      IStrategoTerm l_10727 = null;
      IStrategoTerm m_10727 = null;
      IStrategoTerm o_10727 = null;
      IStrategoTerm p_10727 = null;
      if(g_10727.value == null)
        g_10727.value = term;
      else
        if(g_10727.value != term && !g_10727.value.match(term))
          break Fail145;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail145;
      if(j_10727.value == null)
        j_10727.value = term.getSubterm(0);
      else
        if(j_10727.value != term.getSubterm(0) && !j_10727.value.match(term.getSubterm(0)))
          break Fail145;
      if(f_10727.value == null)
        f_10727.value = term.getSubterm(1);
      else
        if(f_10727.value != term.getSubterm(1) && !f_10727.value.match(term.getSubterm(1)))
          break Fail145;
      l_10727 = term;
      o_10727 = term;
      m_10727 = trans.const0;
      term = o_10727;
      p_10727 = o_10727;
      if(j_10727.value == null || f_10727.value == null)
        break Fail145;
      term = termFactory.annotateTerm(termFactory.makeTuple(j_10727.value, f_10727.value), checkListAnnos(termFactory, trans.constCons0));
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, p_10727, m_10727, term);
      if(term == null)
        break Fail145;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail145;
      e_10727 = term.getSubterm(0);
      if(j_10727.value == null)
        j_10727.value = term.getSubterm(1);
      else
        if(j_10727.value != term.getSubterm(1) && !j_10727.value.match(term.getSubterm(1)))
          break Fail145;
      i_10727 = term.getSubterm(2);
      term = e_10727;
      lifted45 lifted450 = new lifted45();
      lifted450.j_10727 = j_10727;
      lifted450.f_10727 = f_10727;
      lifted450.g_10727 = g_10727;
      lifted450.h_10727 = h_10727;
      term = split_fetch_1_0.instance.invoke(context, term, lifted450);
      if(term == null)
        break Fail145;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail145;
      term = hashtable_put_0_2.instance.invoke(context, i_10727, j_10727.value, term);
      if(term == null)
        break Fail145;
      term = l_10727;
      if(h_10727.value == null)
        break Fail145;
      term = h_10727.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}