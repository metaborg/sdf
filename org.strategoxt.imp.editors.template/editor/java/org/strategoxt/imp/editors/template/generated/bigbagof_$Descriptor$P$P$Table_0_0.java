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

@SuppressWarnings("all") public class bigbagof_$Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static bigbagof_$Descriptor$P$P$Table_0_0 instance = new bigbagof_$Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_DescriptorPPTable_0_0");
    Fail630:
    { 
      TermReference r_9768 = new TermReference();
      if(r_9768.value == null)
        r_9768.value = term;
      else
        if(r_9768.value != term && !r_9768.value.match(term))
          break Fail630;
      Success291:
      { 
        Fail631:
        { 
          IStrategoTerm u_9768 = null;
          IStrategoTerm w_9768 = null;
          IStrategoTerm x_9768 = null;
          w_9768 = term;
          u_9768 = generated.const126;
          x_9768 = w_9768;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, x_9768, u_9768, generated.constCons70);
          if(term == null)
            break Fail631;
          if(true)
            break Success291;
        }
        term = generated.constNil0;
      }
      lifted326 lifted3260 = new lifted326();
      lifted3260.r_9768 = r_9768;
      term = filter_1_0.instance.invoke(context, term, lifted3260);
      if(term == null)
        break Fail630;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}