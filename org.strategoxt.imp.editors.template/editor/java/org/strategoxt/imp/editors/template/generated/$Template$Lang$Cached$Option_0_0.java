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

@SuppressWarnings("all") public class $Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static $Template$Lang$Cached$Option_0_0 instance = new $Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("TemplateLangCachedOption_0_0");
    Fail611:
    { 
      TermReference r_9765 = new TermReference();
      TermReference s_9765 = new TermReference();
      IStrategoTerm w_9765 = null;
      if(s_9765.value == null)
        s_9765.value = term;
      else
        if(s_9765.value != term && !s_9765.value.match(term))
          break Fail611;
      if(r_9765.value == null)
        r_9765.value = term;
      else
        if(r_9765.value != term && !r_9765.value.match(term))
          break Fail611;
      w_9765 = term;
      term = dr_lookup_rule_0_2.instance.invoke(context, w_9765, generated.const116, s_9765.value);
      if(term == null)
        break Fail611;
      lifted321 lifted3211 = new lifted321();
      lifted3211.r_9765 = r_9765;
      lifted3211.s_9765 = s_9765;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted3211);
      if(term == null)
        break Fail611;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}