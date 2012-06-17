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
    Fail1431:
    { 
      TermReference a_32804 = new TermReference();
      TermReference b_32804 = new TermReference();
      IStrategoTerm f_32804 = null;
      if(b_32804.value == null)
        b_32804.value = term;
      else
        if(b_32804.value != term && !b_32804.value.match(term))
          break Fail1431;
      if(a_32804.value == null)
        a_32804.value = term;
      else
        if(a_32804.value != term && !a_32804.value.match(term))
          break Fail1431;
      f_32804 = term;
      term = dr_lookup_rule_0_2.instance.invoke(context, f_32804, generated.const237, b_32804.value);
      if(term == null)
        break Fail1431;
      lifted520 lifted5200 = new lifted520();
      lifted5200.a_32804 = a_32804;
      lifted5200.b_32804 = b_32804;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted5200);
      if(term == null)
        break Fail1431;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}