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
    Fail600:
    { 
      IStrategoTerm u_9763 = null;
      IStrategoTerm x_9763 = null;
      IStrategoTerm z_9763 = null;
      u_9763 = term;
      z_9763 = term;
      Success282:
      { 
        Fail601:
        { 
          IStrategoTerm b_9764 = null;
          b_9764 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, b_9764, generated.const116, u_9763);
          if(term == null)
            break Fail601;
          if(true)
            break Success282;
        }
        term = generated.constNil0;
      }
      x_9763 = term;
      term = z_9763;
      term = termFactory.makeTuple(x_9763, term);
      term = foldl_1_0.instance.invoke(context, term, lifted315.instance);
      if(term == null)
        break Fail600;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}