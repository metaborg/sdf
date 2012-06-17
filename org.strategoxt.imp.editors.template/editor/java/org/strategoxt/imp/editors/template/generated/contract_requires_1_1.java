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

@SuppressWarnings("all") public class contract_requires_1_1 extends Strategy 
{ 
  public static contract_requires_1_1 instance = new contract_requires_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_32788, IStrategoTerm p_32788)
  { 
    context.push("contract_requires_1_1");
    Fail1206:
    { 
      term = contract_requires_1_0.instance.invoke(context, p_32788, q_32788);
      if(term == null)
        break Fail1206;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}