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

@SuppressWarnings("all") public class $Expanded_0_0 extends Strategy 
{ 
  public static $Expanded_0_0 instance = new $Expanded_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("Expanded_0_0");
    Fail1405:
    { 
      TermReference y_32799 = new TermReference();
      TermReference z_32799 = new TermReference();
      IStrategoTerm d_32800 = null;
      if(z_32799.value == null)
        z_32799.value = term;
      else
        if(z_32799.value != term && !z_32799.value.match(term))
          break Fail1405;
      if(y_32799.value == null)
        y_32799.value = term;
      else
        if(y_32799.value != term && !y_32799.value.match(term))
          break Fail1405;
      d_32800 = term;
      term = dr_lookup_rule_0_2.instance.invoke(context, d_32800, generated.const217, z_32799.value);
      if(term == null)
        break Fail1405;
      lifted511 lifted5110 = new lifted511();
      lifted5110.y_32799 = y_32799;
      lifted5110.z_32799 = z_32799;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted5110);
      if(term == null)
        break Fail1405;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}