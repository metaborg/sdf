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
    Fail171:
    { 
      IStrategoTerm u_10731 = null;
      TermReference v_10731 = new TermReference();
      TermReference w_10731 = new TermReference();
      IStrategoTerm x_10731 = null;
      IStrategoTerm y_10731 = null;
      IStrategoTerm a_10732 = null;
      IStrategoTerm b_10732 = null;
      IStrategoTerm d_10732 = null;
      IStrategoTerm e_10732 = null;
      if(v_10731.value == null)
        v_10731.value = term;
      else
        if(v_10731.value != term && !v_10731.value.match(term))
          break Fail171;
      a_10732 = term;
      d_10732 = term;
      b_10732 = trans.const3;
      e_10732 = d_10732;
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, e_10732, b_10732, trans.constCons0);
      if(term == null)
        break Fail171;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail171;
      u_10731 = term.getSubterm(0);
      y_10731 = term.getSubterm(1);
      x_10731 = term.getSubterm(2);
      term = u_10731;
      lifted54 lifted540 = new lifted54();
      lifted540.v_10731 = v_10731;
      lifted540.w_10731 = w_10731;
      term = split_fetch_1_0.instance.invoke(context, term, lifted540);
      if(term == null)
        break Fail171;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail171;
      term = hashtable_put_0_2.instance.invoke(context, x_10731, y_10731, term);
      if(term == null)
        break Fail171;
      term = a_10732;
      if(w_10731.value == null)
        break Fail171;
      term = w_10731.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}