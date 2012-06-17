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

@SuppressWarnings("all") public class bagof_$Is$Imported_0_0 extends Strategy 
{ 
  public static bagof_$Is$Imported_0_0 instance = new bagof_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_IsImported_0_0");
    Fail2048:
    { 
      TermReference h_33023 = new TermReference();
      TermReference i_33023 = new TermReference();
      if(i_33023.value == null)
        i_33023.value = term;
      else
        if(i_33023.value != term && !i_33023.value.match(term))
          break Fail2048;
      if(h_33023.value == null)
        h_33023.value = term;
      else
        if(h_33023.value != term && !h_33023.value.match(term))
          break Fail2048;
      Success737:
      { 
        Fail2049:
        { 
          IStrategoTerm m_33023 = null;
          m_33023 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, m_33023, trans.const275, i_33023.value);
          if(term == null)
            break Fail2049;
          if(true)
            break Success737;
        }
        term = trans.constNil4;
      }
      lifted594 lifted5940 = new lifted594();
      lifted5940.h_33023 = h_33023;
      lifted5940.i_33023 = i_33023;
      term = filter_1_0.instance.invoke(context, term, lifted5940);
      if(term == null)
        break Fail2048;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}