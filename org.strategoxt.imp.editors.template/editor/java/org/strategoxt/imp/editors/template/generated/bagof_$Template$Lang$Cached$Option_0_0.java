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

@SuppressWarnings("all") public class bagof_$Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static bagof_$Template$Lang$Cached$Option_0_0 instance = new bagof_$Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_TemplateLangCachedOption_0_0");
    Fail1429:
    { 
      TermReference u_32803 = new TermReference();
      TermReference v_32803 = new TermReference();
      if(v_32803.value == null)
        v_32803.value = term;
      else
        if(v_32803.value != term && !v_32803.value.match(term))
          break Fail1429;
      if(u_32803.value == null)
        u_32803.value = term;
      else
        if(u_32803.value != term && !u_32803.value.match(term))
          break Fail1429;
      Success542:
      { 
        Fail1430:
        { 
          IStrategoTerm z_32803 = null;
          z_32803 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, z_32803, generated.const237, v_32803.value);
          if(term == null)
            break Fail1430;
          if(true)
            break Success542;
        }
        term = generated.constNil3;
      }
      lifted519 lifted5190 = new lifted519();
      lifted5190.u_32803 = u_32803;
      lifted5190.v_32803 = v_32803;
      term = filter_1_0.instance.invoke(context, term, lifted5190);
      if(term == null)
        break Fail1429;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}