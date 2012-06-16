package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") public class bagof_$Expanded_0_0 extends Strategy 
{ 
  public static bagof_$Expanded_0_0 instance = new bagof_$Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_Expanded_0_0");
    Fail583:
    { 
      TermReference j_9761 = new TermReference();
      TermReference k_9761 = new TermReference();
      if(k_9761.value == null)
        k_9761.value = term;
      else
        if(k_9761.value != term && !k_9761.value.match(term))
          break Fail583;
      if(j_9761.value == null)
        j_9761.value = term;
      else
        if(j_9761.value != term && !j_9761.value.match(term))
          break Fail583;
      Success279:
      { 
        Fail584:
        { 
          IStrategoTerm o_9761 = null;
          o_9761 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, o_9761, generated.const96, k_9761.value);
          if(term == null)
            break Fail584;
          if(true)
            break Success279;
        }
        term = generated.constNil0;
      }
      lifted311 lifted3110 = new lifted311();
      lifted3110.j_9761 = j_9761;
      lifted3110.k_9761 = k_9761;
      term = filter_1_0.instance.invoke(context, term, lifted3110);
      if(term == null)
        break Fail583;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}