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
    Fail602:
    { 
      IStrategoTerm f_9764 = null;
      IStrategoTerm i_9764 = null;
      IStrategoTerm k_9764 = null;
      f_9764 = term;
      k_9764 = term;
      Success283:
      { 
        Fail603:
        { 
          IStrategoTerm m_9764 = null;
          m_9764 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, m_9764, generated.const116, f_9764);
          if(term == null)
            break Fail603;
          if(true)
            break Success283;
        }
        term = generated.constNil0;
      }
      i_9764 = term;
      term = k_9764;
      term = termFactory.makeTuple(i_9764, term);
      term = foldl_1_0.instance.invoke(context, term, lifted316.instance);
      if(term == null)
        break Fail602;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}