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

@SuppressWarnings("all") public class innermost_scope_$Expanded_1_0 extends Strategy 
{ 
  public static innermost_scope_$Expanded_1_0 instance = new innermost_scope_$Expanded_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_9757)
  { 
    context.push("innermost_scope_Expanded_1_0");
    Fail558:
    { 
      IStrategoTerm s_9757 = null;
      s_9757 = term;
      term = dr_get_first_scope_label_1_1.instance.invoke(context, s_9757, q_9757, generated.const96);
      if(term == null)
        break Fail558;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}