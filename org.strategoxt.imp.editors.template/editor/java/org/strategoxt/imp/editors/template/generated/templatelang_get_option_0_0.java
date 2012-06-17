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
    Fail1112:
    { 
      TermReference a_32779 = new TermReference();
      TermReference b_32779 = new TermReference();
      IStrategoTerm term544 = term;
      Success468:
      { 
        Fail1113:
        { 
          IStrategoTerm c_32779 = null;
          c_32779 = term;
          IStrategoTerm term545 = term;
          Success469:
          { 
            Fail1114:
            { 
              term = $Template$Lang$Cached$Option_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1114;
              if(b_32779.value == null)
                b_32779.value = term;
              else
                if(b_32779.value != term && !b_32779.value.match(term))
                  break Fail1114;
              { 
                if(true)
                  break Fail1113;
                if(true)
                  break Success469;
              }
            }
            term = term545;
          }
          term = c_32779;
          { 
            IStrategoTerm d_32779 = null;
            IStrategoTerm e_32779 = null;
            IStrategoTerm g_32779 = null;
            IStrategoTerm h_32779 = null;
            if(a_32779.value == null)
              a_32779.value = term;
            else
              if(a_32779.value != term && !a_32779.value.match(term))
                break Fail1112;
            lifted415 lifted4150 = new lifted415();
            lifted4150.a_32779 = a_32779;
            lifted4150.b_32779 = b_32779;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted4150, lifted416.instance);
            if(term == null)
              break Fail1112;
            d_32779 = term;
            g_32779 = term;
            e_32779 = generated.const237;
            term = g_32779;
            h_32779 = g_32779;
            if(b_32779.value == null)
              break Fail1112;
            term = termFactory.makeTuple(generated.const238, b_32779.value);
            term = dr_set_rule_0_3.instance.invoke(context, h_32779, e_32779, a_32779.value, term);
            if(term == null)
              break Fail1112;
            term = d_32779;
            if(true)
              break Success468;
          }
        }
        term = term544;
      }
      if(b_32779.value == null)
        break Fail1112;
      term = b_32779.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}