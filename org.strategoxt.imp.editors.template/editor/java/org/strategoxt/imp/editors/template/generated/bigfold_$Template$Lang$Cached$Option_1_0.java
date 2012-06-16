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

@SuppressWarnings("all") public class bigfold_$Template$Lang$Cached$Option_1_0 extends Strategy 
{ 
  public static bigfold_$Template$Lang$Cached$Option_1_0 instance = new bigfold_$Template$Lang$Cached$Option_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_9762)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_TemplateLangCachedOption_1_0");
    Fail596:
    { 
      IStrategoTerm w_9762 = null;
      IStrategoTerm a_9763 = null;
      IStrategoTerm c_9763 = null;
      w_9762 = term;
      c_9763 = term;
      Success280:
      { 
        Fail597:
        { 
          IStrategoTerm e_9763 = null;
          e_9763 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, e_9763, generated.const116, w_9762);
          if(term == null)
            break Fail597;
          if(true)
            break Success280;
        }
        term = generated.constNil0;
      }
      a_9763 = term;
      term = c_9763;
      term = termFactory.makeTuple(a_9763, term);
      term = z_9762.invoke(context, term, lifted313.instance);
      if(term == null)
        break Fail596;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}