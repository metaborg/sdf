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

@SuppressWarnings("all") public class contract_requires_1_2 extends Strategy 
{ 
  public static contract_requires_1_2 instance = new contract_requires_1_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy o_32788, IStrategoTerm l_32788, IStrategoTerm m_32788)
  { 
    context.push("contract_requires_1_2");
    Fail1204:
    { 
      Success520:
      { 
        Fail1205:
        { 
          IStrategoTerm n_32788 = null;
          n_32788 = term;
          term = o_32788.invoke(context, l_32788);
          if(term == null)
            break Fail1205;
          term = n_32788;
          if(true)
            break Success520;
        }
        term = debug_0_0.instance.invoke(context, generated.const265);
        if(term == null)
          break Fail1204;
        term = debug_1_0.instance.invoke(context, l_32788, lifted448.instance);
        if(term == null)
          break Fail1204;
        term = debug_1_0.instance.invoke(context, m_32788, lifted449.instance);
        if(term == null)
          break Fail1204;
        if(true)
          break Fail1204;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}