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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_32801)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_TemplateLangCachedOption_1_0");
    Fail1418:
    { 
      IStrategoTerm r_32801 = null;
      IStrategoTerm v_32801 = null;
      IStrategoTerm x_32801 = null;
      r_32801 = term;
      x_32801 = term;
      Success537:
      { 
        Fail1419:
        { 
          IStrategoTerm z_32801 = null;
          z_32801 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, z_32801, generated.const237, r_32801);
          if(term == null)
            break Fail1419;
          if(true)
            break Success537;
        }
        term = generated.constNil3;
      }
      v_32801 = term;
      term = x_32801;
      term = termFactory.makeTuple(v_32801, term);
      term = u_32801.invoke(context, term, lifted513.instance);
      if(term == null)
        break Fail1418;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}