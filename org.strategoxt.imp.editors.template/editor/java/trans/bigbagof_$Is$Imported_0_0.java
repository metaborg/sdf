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

@SuppressWarnings("all") public class bigbagof_$Is$Imported_0_0 extends Strategy 
{ 
  public static bigbagof_$Is$Imported_0_0 instance = new bigbagof_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_IsImported_0_0");
    Fail2043:
    { 
      TermReference k_33022 = new TermReference();
      TermReference l_33022 = new TermReference();
      if(l_33022.value == null)
        l_33022.value = term;
      else
        if(l_33022.value != term && !l_33022.value.match(term))
          break Fail2043;
      if(k_33022.value == null)
        k_33022.value = term;
      else
        if(k_33022.value != term && !k_33022.value.match(term))
          break Fail2043;
      Success735:
      { 
        Fail2044:
        { 
          IStrategoTerm p_33022 = null;
          p_33022 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, p_33022, trans.const275, l_33022.value);
          if(term == null)
            break Fail2044;
          if(true)
            break Success735;
        }
        term = trans.constNil4;
      }
      lifted591 lifted5910 = new lifted591();
      lifted5910.k_33022 = k_33022;
      lifted5910.l_33022 = l_33022;
      term = filter_1_0.instance.invoke(context, term, lifted5910);
      if(term == null)
        break Fail2043;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}