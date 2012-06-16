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

@SuppressWarnings("all") public class reverse_bagof_$Expanded_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Expanded_1_0 instance = new reverse_bagof_$Expanded_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_9761)
  { 
    context.push("reverse_bagof_Expanded_1_0");
    Fail581:
    { 
      TermReference c_9761 = new TermReference();
      TermReference d_9761 = new TermReference();
      if(d_9761.value == null)
        d_9761.value = term;
      else
        if(d_9761.value != term && !d_9761.value.match(term))
          break Fail581;
      if(c_9761.value == null)
        c_9761.value = term;
      else
        if(c_9761.value != term && !c_9761.value.match(term))
          break Fail581;
      Success278:
      { 
        Fail582:
        { 
          IStrategoTerm i_9761 = null;
          i_9761 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, i_9761, generated.const96, d_9761.value);
          if(term == null)
            break Fail582;
          if(true)
            break Success278;
        }
        term = generated.constNil0;
      }
      lifted310 lifted3100 = new lifted310();
      lifted3100.c_9761 = c_9761;
      lifted3100.d_9761 = d_9761;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted3100, f_9761);
      if(term == null)
        break Fail581;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}