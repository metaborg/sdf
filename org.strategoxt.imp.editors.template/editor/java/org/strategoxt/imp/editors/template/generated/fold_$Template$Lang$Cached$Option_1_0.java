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

@SuppressWarnings("all") public class fold_$Template$Lang$Cached$Option_1_0 extends Strategy 
{ 
  public static fold_$Template$Lang$Cached$Option_1_0 instance = new fold_$Template$Lang$Cached$Option_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_9763)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_TemplateLangCachedOption_1_0");
    Fail598:
    { 
      IStrategoTerm i_9763 = null;
      IStrategoTerm m_9763 = null;
      IStrategoTerm o_9763 = null;
      i_9763 = term;
      o_9763 = term;
      Success281:
      { 
        Fail599:
        { 
          IStrategoTerm q_9763 = null;
          q_9763 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, q_9763, generated.const116, i_9763);
          if(term == null)
            break Fail599;
          if(true)
            break Success281;
        }
        term = generated.constNil0;
      }
      m_9763 = term;
      term = o_9763;
      term = termFactory.makeTuple(m_9763, term);
      term = l_9763.invoke(context, term, lifted314.instance);
      if(term == null)
        break Fail598;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}