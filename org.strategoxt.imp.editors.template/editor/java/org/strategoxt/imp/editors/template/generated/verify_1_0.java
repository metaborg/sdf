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

@SuppressWarnings("all") public class verify_1_0 extends Strategy 
{ 
  public static verify_1_0 instance = new verify_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_32788)
  { 
    context.push("verify_1_0");
    Fail1201:
    { 
      lifted447 lifted4470 = new lifted447();
      lifted4470.g_32788 = g_32788;
      term = contracts_1_0.instance.invoke(context, term, lifted4470);
      if(term == null)
        break Fail1201;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}