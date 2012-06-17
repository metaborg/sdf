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

@SuppressWarnings("all") public class reverse_bagof_$Template$Lang$Cached$Option_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Template$Lang$Cached$Option_1_0 instance = new reverse_bagof_$Template$Lang$Cached$Option_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_32803)
  { 
    context.push("reverse_bagof_TemplateLangCachedOption_1_0");
    Fail1427:
    { 
      TermReference n_32803 = new TermReference();
      TermReference o_32803 = new TermReference();
      if(o_32803.value == null)
        o_32803.value = term;
      else
        if(o_32803.value != term && !o_32803.value.match(term))
          break Fail1427;
      if(n_32803.value == null)
        n_32803.value = term;
      else
        if(n_32803.value != term && !n_32803.value.match(term))
          break Fail1427;
      Success541:
      { 
        Fail1428:
        { 
          IStrategoTerm t_32803 = null;
          t_32803 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, t_32803, generated.const237, o_32803.value);
          if(term == null)
            break Fail1428;
          if(true)
            break Success541;
        }
        term = generated.constNil3;
      }
      lifted518 lifted5180 = new lifted518();
      lifted5180.n_32803 = n_32803;
      lifted5180.o_32803 = o_32803;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted5180, q_32803);
      if(term == null)
        break Fail1427;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}