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
    Fail1424:
    { 
      TermReference y_32802 = new TermReference();
      TermReference z_32802 = new TermReference();
      if(z_32802.value == null)
        z_32802.value = term;
      else
        if(z_32802.value != term && !z_32802.value.match(term))
          break Fail1424;
      if(y_32802.value == null)
        y_32802.value = term;
      else
        if(y_32802.value != term && !y_32802.value.match(term))
          break Fail1424;
      Success540:
      { 
        Fail1425:
        { 
          IStrategoTerm d_32803 = null;
          d_32803 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, d_32803, generated.const237, z_32802.value);
          if(term == null)
            break Fail1425;
          if(true)
            break Success540;
        }
        term = generated.constNil3;
      }
      lifted516 lifted5160 = new lifted516();
      lifted5160.y_32802 = y_32802;
      lifted5160.z_32802 = z_32802;
      term = filter_1_0.instance.invoke(context, term, lifted5160);
      if(term == null)
        break Fail1424;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}