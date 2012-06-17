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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_33023)
  { 
    context.push("reverse_bagof_IsImported_1_0");
    Fail2046:
    { 
      TermReference a_33023 = new TermReference();
      TermReference b_33023 = new TermReference();
      if(b_33023.value == null)
        b_33023.value = term;
      else
        if(b_33023.value != term && !b_33023.value.match(term))
          break Fail2046;
      if(a_33023.value == null)
        a_33023.value = term;
      else
        if(a_33023.value != term && !a_33023.value.match(term))
          break Fail2046;
      Success736:
      { 
        Fail2047:
        { 
          IStrategoTerm g_33023 = null;
          g_33023 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, g_33023, trans.const275, b_33023.value);
          if(term == null)
            break Fail2047;
          if(true)
            break Success736;
        }
        term = trans.constNil4;
      }
      lifted593 lifted5930 = new lifted593();
      lifted5930.a_33023 = a_33023;
      lifted5930.b_33023 = b_33023;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted5930, d_33023);
      if(term == null)
        break Fail2046;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}