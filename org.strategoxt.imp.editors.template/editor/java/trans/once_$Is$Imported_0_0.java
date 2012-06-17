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

@SuppressWarnings("all") public class once_$Is$Imported_0_0 extends Strategy 
{ 
  public static once_$Is$Imported_0_0 instance = new once_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("once_IsImported_0_0");
    Fail2045:
    { 
      IStrategoTerm q_33022 = null;
      TermReference r_33022 = new TermReference();
      TermReference s_33022 = new TermReference();
      TermReference t_33022 = new TermReference();
      IStrategoTerm u_33022 = null;
      IStrategoTerm v_33022 = null;
      IStrategoTerm x_33022 = null;
      IStrategoTerm z_33022 = null;
      if(s_33022.value == null)
        s_33022.value = term;
      else
        if(s_33022.value != term && !s_33022.value.match(term))
          break Fail2045;
      if(r_33022.value == null)
        r_33022.value = term;
      else
        if(r_33022.value != term && !r_33022.value.match(term))
          break Fail2045;
      x_33022 = term;
      z_33022 = term;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, z_33022, trans.const275, s_33022.value);
      if(term == null)
        break Fail2045;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail2045;
      q_33022 = term.getSubterm(0);
      v_33022 = term.getSubterm(1);
      u_33022 = term.getSubterm(2);
      term = q_33022;
      lifted592 lifted5920 = new lifted592();
      lifted5920.r_33022 = r_33022;
      lifted5920.s_33022 = s_33022;
      lifted5920.t_33022 = t_33022;
      term = split_fetch_1_0.instance.invoke(context, term, lifted5920);
      if(term == null)
        break Fail2045;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail2045;
      term = hashtable_put_0_2.instance.invoke(context, u_33022, v_33022, term);
      if(term == null)
        break Fail2045;
      term = x_33022;
      if(t_33022.value == null)
        break Fail2045;
      term = t_33022.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}