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

@SuppressWarnings("all") public class reverse_bagof_$Is$Imported_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Is$Imported_1_0 instance = new reverse_bagof_$Is$Imported_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_10736)
  { 
    context.push("reverse_bagof_IsImported_1_0");
    Fail198:
    { 
      TermReference k_10736 = new TermReference();
      TermReference l_10736 = new TermReference();
      if(l_10736.value == null)
        l_10736.value = term;
      else
        if(l_10736.value != term && !l_10736.value.match(term))
          break Fail198;
      if(k_10736.value == null)
        k_10736.value = term;
      else
        if(k_10736.value != term && !k_10736.value.match(term))
          break Fail198;
      Success65:
      { 
        Fail199:
        { 
          IStrategoTerm q_10736 = null;
          q_10736 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, q_10736, trans.const5, l_10736.value);
          if(term == null)
            break Fail199;
          if(true)
            break Success65;
        }
        term = trans.constNil0;
      }
      lifted64 lifted640 = new lifted64();
      lifted640.k_10736 = k_10736;
      lifted640.l_10736 = l_10736;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted640, n_10736);
      if(term == null)
        break Fail198;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}