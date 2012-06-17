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
    Fail1057:
    { 
      IStrategoTerm r_32770 = null;
      IStrategoTerm t_32770 = null;
      IStrategoTerm v_32770 = null;
      IStrategoTerm w_32770 = null;
      r_32770 = term;
      v_32770 = term;
      t_32770 = generated.const217;
      w_32770 = v_32770;
      term = termFactory.makeTuple(generated.const218, r_32770);
      term = dr_set_rule_0_3.instance.invoke(context, w_32770, t_32770, r_32770, term);
      if(term == null)
        break Fail1057;
      term = termFactory.makeTuple(r_32770, generated.constTemplateBySort0);
      term = resolve_all_symbol_definitions_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1057;
      IStrategoTerm term488 = term;
      Success434:
      { 
        Fail1058:
        { 
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail1058;
          { 
            if(true)
              break Fail1057;
            if(true)
              break Success434;
          }
        }
        term = term488;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}