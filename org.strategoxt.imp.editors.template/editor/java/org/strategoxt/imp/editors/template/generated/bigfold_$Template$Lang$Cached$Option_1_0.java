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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_32801)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_TemplateLangCachedOption_1_0");
    Fail1416:
    { 
      IStrategoTerm f_32801 = null;
      IStrategoTerm j_32801 = null;
      IStrategoTerm l_32801 = null;
      f_32801 = term;
      l_32801 = term;
      Success536:
      { 
        Fail1417:
        { 
          IStrategoTerm n_32801 = null;
          n_32801 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, n_32801, generated.const237, f_32801);
          if(term == null)
            break Fail1417;
          if(true)
            break Success536;
        }
        term = generated.constNil3;
      }
      j_32801 = term;
      term = l_32801;
      term = termFactory.makeTuple(j_32801, term);
      term = i_32801.invoke(context, term, lifted512.instance);
      if(term == null)
        break Fail1416;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}