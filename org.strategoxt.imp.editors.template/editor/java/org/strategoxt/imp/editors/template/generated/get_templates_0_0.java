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

@SuppressWarnings("all") public class get_templates_0_0 extends Strategy 
{ 
  public static get_templates_0_0 instance = new get_templates_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("get_templates_0_0");
    Fail237:
    { 
      IStrategoTerm i_9732 = null;
      IStrategoTerm k_9732 = null;
      IStrategoTerm m_9732 = null;
      IStrategoTerm n_9732 = null;
      i_9732 = term;
      m_9732 = term;
      k_9732 = generated.const96;
      n_9732 = m_9732;
      term = termFactory.makeTuple(generated.const97, i_9732);
      term = dr_set_rule_0_3.instance.invoke(context, n_9732, k_9732, i_9732, term);
      if(term == null)
        break Fail237;
      term = termFactory.makeTuple(i_9732, generated.constTemplateBySort0);
      term = resolve_all_symbol_definitions_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail237;
      IStrategoTerm term232 = term;
      Success178:
      { 
        Fail238:
        { 
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail238;
          { 
            if(true)
              break Fail237;
            if(true)
              break Success178;
          }
        }
        term = term232;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}