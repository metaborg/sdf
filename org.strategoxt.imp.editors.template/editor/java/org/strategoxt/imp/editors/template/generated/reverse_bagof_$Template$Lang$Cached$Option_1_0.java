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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_9765)
  { 
    context.push("reverse_bagof_TemplateLangCachedOption_1_0");
    Fail607:
    { 
      TermReference e_9765 = new TermReference();
      TermReference f_9765 = new TermReference();
      if(f_9765.value == null)
        f_9765.value = term;
      else
        if(f_9765.value != term && !f_9765.value.match(term))
          break Fail607;
      if(e_9765.value == null)
        e_9765.value = term;
      else
        if(e_9765.value != term && !e_9765.value.match(term))
          break Fail607;
      Success285:
      { 
        Fail608:
        { 
          IStrategoTerm k_9765 = null;
          k_9765 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, k_9765, generated.const116, f_9765.value);
          if(term == null)
            break Fail608;
          if(true)
            break Success285;
        }
        term = generated.constNil0;
      }
      lifted319 lifted3190 = new lifted319();
      lifted3190.e_9765 = e_9765;
      lifted3190.f_9765 = f_9765;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted3190, h_9765);
      if(term == null)
        break Fail607;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}