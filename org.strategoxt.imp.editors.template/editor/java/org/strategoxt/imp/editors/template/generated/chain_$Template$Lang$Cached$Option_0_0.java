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

@SuppressWarnings("all") public class chain_$Template$Lang$Cached$Option_0_0 extends Strategy 
{ 
  public static chain_$Template$Lang$Cached$Option_0_0 instance = new chain_$Template$Lang$Cached$Option_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("chain_TemplateLangCachedOption_0_0");
    Fail1422:
    { 
      IStrategoTerm o_32802 = null;
      IStrategoTerm r_32802 = null;
      IStrategoTerm t_32802 = null;
      o_32802 = term;
      t_32802 = term;
      Success539:
      { 
        Fail1423:
        { 
          IStrategoTerm v_32802 = null;
          v_32802 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, v_32802, generated.const237, o_32802);
          if(term == null)
            break Fail1423;
          if(true)
            break Success539;
        }
        term = generated.constNil3;
      }
      r_32802 = term;
      term = t_32802;
      term = termFactory.makeTuple(r_32802, term);
      term = foldl_1_0.instance.invoke(context, term, lifted515.instance);
      if(term == null)
        break Fail1422;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}