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

@SuppressWarnings("all") public class contract_requires_1_0 extends Strategy 
{ 
  public static contract_requires_1_0 instance = new contract_requires_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_32788)
  { 
    context.push("contract_requires_1_0");
    Fail1207:
    { 
      IStrategoTerm term634 = term;
      Success521:
      { 
        Fail1208:
        { 
          IStrategoTerm r_32788 = null;
          r_32788 = term;
          term = t_32788.invoke(context, term);
          if(term == null)
            break Fail1208;
          term = r_32788;
          if(true)
            break Success521;
        }
        term = term634;
        IStrategoTerm s_32788 = null;
        s_32788 = term;
        term = debug_0_0.instance.invoke(context, generated.const265);
        if(term == null)
          break Fail1207;
        term = debug_1_0.instance.invoke(context, s_32788, lifted450.instance);
        if(term == null)
          break Fail1207;
        if(true)
          break Fail1207;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}