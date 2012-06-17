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

@SuppressWarnings("all") public class bigbagof_$Declaration_0_0 extends Strategy 
{ 
  public static bigbagof_$Declaration_0_0 instance = new bigbagof_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigbagof_Declaration_0_0");
    Fail1991:
    { 
      TermReference l_33013 = new TermReference();
      TermReference m_33013 = new TermReference();
      TermReference n_33013 = new TermReference();
      if(l_33013.value == null)
        l_33013.value = term;
      else
        if(l_33013.value != term && !l_33013.value.match(term))
          break Fail1991;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1991;
      if(m_33013.value == null)
        m_33013.value = term.getSubterm(0);
      else
        if(m_33013.value != term.getSubterm(0) && !m_33013.value.match(term.getSubterm(0)))
          break Fail1991;
      if(n_33013.value == null)
        n_33013.value = term.getSubterm(1);
      else
        if(n_33013.value != term.getSubterm(1) && !n_33013.value.match(term.getSubterm(1)))
          break Fail1991;
      Success721:
      { 
        Fail1992:
        { 
          IStrategoTerm q_33013 = null;
          IStrategoTerm s_33013 = null;
          IStrategoTerm t_33013 = null;
          s_33013 = term;
          q_33013 = trans.const269;
          term = s_33013;
          t_33013 = s_33013;
          if(m_33013.value == null || n_33013.value == null)
            break Fail1992;
          term = termFactory.annotateTerm(termFactory.makeTuple(m_33013.value, n_33013.value), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_all_rules_0_2.instance.invoke(context, t_33013, q_33013, term);
          if(term == null)
            break Fail1992;
          if(true)
            break Success721;
        }
        term = trans.constNil4;
      }
      lifted573 lifted5730 = new lifted573();
      lifted5730.m_33013 = m_33013;
      lifted5730.n_33013 = n_33013;
      lifted5730.l_33013 = l_33013;
      term = filter_1_0.instance.invoke(context, term, lifted5730);
      if(term == null)
        break Fail1991;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}