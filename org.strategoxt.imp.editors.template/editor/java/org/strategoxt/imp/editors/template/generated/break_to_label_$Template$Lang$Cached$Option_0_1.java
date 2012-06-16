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

@SuppressWarnings("all") public class break_to_label_$Template$Lang$Cached$Option_0_1 extends Strategy 
{ 
  public static break_to_label_$Template$Lang$Cached$Option_0_1 instance = new break_to_label_$Template$Lang$Cached$Option_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm o_9762)
  { 
    context.push("break_to_label_TemplateLangCachedOption_0_1");
    Fail593:
    { 
      IStrategoTerm q_9762 = null;
      q_9762 = term;
      term = dr_break_0_2.instance.invoke(context, q_9762, generated.const116, o_9762);
      if(term == null)
        break Fail593;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}