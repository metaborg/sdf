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

@SuppressWarnings("all") public class bigbagof_$Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static bigbagof_$Template$Lang$Cached$Option_0_0 instance = new bigbagof_$Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_TemplateLangCachedOption_0_0");
    Fail604:
    { 
      TermReference p_9764 = new TermReference();
      TermReference q_9764 = new TermReference();
      if(q_9764.value == null)
        q_9764.value = term;
      else
        if(q_9764.value != term && !q_9764.value.match(term))
          break Fail604;
      if(p_9764.value == null)
        p_9764.value = term;
      else
        if(p_9764.value != term && !p_9764.value.match(term))
          break Fail604;
      Success284:
      { 
        Fail605:
        { 
          IStrategoTerm u_9764 = null;
          u_9764 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, u_9764, generated.const116, q_9764.value);
          if(term == null)
            break Fail605;
          if(true)
            break Success284;
        }
        term = generated.constNil0;
      }
      lifted317 lifted3170 = new lifted317();
      lifted3170.p_9764 = p_9764;
      lifted3170.q_9764 = q_9764;
      term = filter_1_0.instance.invoke(context, term, lifted3170);
      if(term == null)
        break Fail604;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}