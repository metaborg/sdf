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

@SuppressWarnings("all") public class throw_$Template$Lang$Cached$Option_1_1 extends Strategy 
{ 
  public static throw_$Template$Lang$Cached$Option_1_1 instance = new throw_$Template$Lang$Cached$Option_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_9762, IStrategoTerm d_9762)
  { 
    context.push("throw_TemplateLangCachedOption_1_1");
    Fail589:
    { 
      IStrategoTerm g_9762 = null;
      g_9762 = term;
      term = dr_throw_1_2.instance.invoke(context, g_9762, e_9762, d_9762, generated.const116);
      if(term == null)
        break Fail589;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}