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

@SuppressWarnings("all") public class once_$Current$File_0_0 extends Strategy 
{ 
  public static once_$Current$File_0_0 instance = new once_$Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("once_CurrentFile_0_0");
    Fail2019:
    { 
      IStrategoTerm k_33018 = null;
      TermReference l_33018 = new TermReference();
      TermReference m_33018 = new TermReference();
      IStrategoTerm n_33018 = null;
      IStrategoTerm o_33018 = null;
      IStrategoTerm q_33018 = null;
      IStrategoTerm r_33018 = null;
      IStrategoTerm t_33018 = null;
      IStrategoTerm u_33018 = null;
      if(l_33018.value == null)
        l_33018.value = term;
      else
        if(l_33018.value != term && !l_33018.value.match(term))
          break Fail2019;
      q_33018 = term;
      t_33018 = term;
      r_33018 = trans.const273;
      u_33018 = t_33018;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, u_33018, r_33018, trans.constCons84);
      if(term == null)
        break Fail2019;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail2019;
      k_33018 = term.getSubterm(0);
      o_33018 = term.getSubterm(1);
      n_33018 = term.getSubterm(2);
      term = k_33018;
      lifted583 lifted5830 = new lifted583();
      lifted5830.l_33018 = l_33018;
      lifted5830.m_33018 = m_33018;
      term = split_fetch_1_0.instance.invoke(context, term, lifted5830);
      if(term == null)
        break Fail2019;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail2019;
      term = hashtable_put_0_2.instance.invoke(context, n_33018, o_33018, term);
      if(term == null)
        break Fail2019;
      term = q_33018;
      if(m_33018.value == null)
        break Fail2019;
      term = m_33018.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}