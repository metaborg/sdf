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

@SuppressWarnings("all") public class templatelang_get_option_0_0 extends Strategy 
{ 
  public static templatelang_get_option_0_0 instance = new templatelang_get_option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_get_option_0_0");
    Fail292:
    { 
      TermReference r_9740 = new TermReference();
      TermReference s_9740 = new TermReference();
      IStrategoTerm term288 = term;
      Success212:
      { 
        Fail293:
        { 
          IStrategoTerm t_9740 = null;
          t_9740 = term;
          IStrategoTerm term289 = term;
          Success213:
          { 
            Fail294:
            { 
              term = $Template$Lang$Cached$Option_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail294;
              if(s_9740.value == null)
                s_9740.value = term;
              else
                if(s_9740.value != term && !s_9740.value.match(term))
                  break Fail294;
              { 
                if(true)
                  break Fail293;
                if(true)
                  break Success213;
              }
            }
            term = term289;
          }
          term = t_9740;
          { 
            IStrategoTerm u_9740 = null;
            IStrategoTerm v_9740 = null;
            IStrategoTerm x_9740 = null;
            IStrategoTerm y_9740 = null;
            if(r_9740.value == null)
              r_9740.value = term;
            else
              if(r_9740.value != term && !r_9740.value.match(term))
                break Fail292;
            lifted216 lifted2160 = new lifted216();
            lifted2160.r_9740 = r_9740;
            lifted2160.s_9740 = s_9740;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted2160, lifted217.instance);
            if(term == null)
              break Fail292;
            u_9740 = term;
            x_9740 = term;
            v_9740 = generated.const116;
            term = x_9740;
            y_9740 = x_9740;
            if(s_9740.value == null)
              break Fail292;
            term = termFactory.makeTuple(generated.const117, s_9740.value);
            term = dr_set_rule_0_3.instance.invoke(context, y_9740, v_9740, r_9740.value, term);
            if(term == null)
              break Fail292;
            term = u_9740;
            if(true)
              break Success212;
          }
        }
        term = term288;
      }
      if(s_9740.value == null)
        break Fail292;
      term = s_9740.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}