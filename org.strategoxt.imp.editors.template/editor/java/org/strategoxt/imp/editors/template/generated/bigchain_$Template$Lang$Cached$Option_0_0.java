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

@SuppressWarnings("all") public class bigchain_$Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static bigchain_$Template$Lang$Cached$Option_0_0 instance = new bigchain_$Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_TemplateLangCachedOption_0_0");
    Fail1420:
    { 
      IStrategoTerm d_32802 = null;
      IStrategoTerm g_32802 = null;
      IStrategoTerm i_32802 = null;
      d_32802 = term;
      i_32802 = term;
      Success538:
      { 
        Fail1421:
        { 
          IStrategoTerm k_32802 = null;
          k_32802 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, k_32802, generated.const237, d_32802);
          if(term == null)
            break Fail1421;
          if(true)
            break Success538;
        }
        term = generated.constNil3;
      }
      g_32802 = term;
      term = i_32802;
      term = termFactory.makeTuple(g_32802, term);
      term = foldl_1_0.instance.invoke(context, term, lifted514.instance);
      if(term == null)
        break Fail1420;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}