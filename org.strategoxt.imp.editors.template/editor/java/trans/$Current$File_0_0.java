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

@SuppressWarnings("all") public class $Current$File_0_0 extends Strategy 
{ 
  public static $Current$File_0_0 instance = new $Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("CurrentFile_0_0");
    Fail2024:
    { 
      TermReference k_33019 = new TermReference();
      IStrategoTerm n_33019 = null;
      IStrategoTerm p_33019 = null;
      IStrategoTerm q_33019 = null;
      if(k_33019.value == null)
        k_33019.value = term;
      else
        if(k_33019.value != term && !k_33019.value.match(term))
          break Fail2024;
      p_33019 = term;
      n_33019 = trans.const273;
      q_33019 = p_33019;
      term = dr_lookup_rule_0_2.instance.invoke(context, q_33019, n_33019, trans.constCons84);
      if(term == null)
        break Fail2024;
      lifted586 lifted5860 = new lifted586();
      lifted5860.k_33019 = k_33019;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted5860);
      if(term == null)
        break Fail2024;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}