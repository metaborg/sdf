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

@SuppressWarnings("all") public class bagof_$Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static bagof_$Descriptor$P$P$Table_0_0 instance = new bagof_$Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_DescriptorPPTable_0_0");
    Fail1455:
    { 
      TermReference a_32808 = new TermReference();
      if(a_32808.value == null)
        a_32808.value = term;
      else
        if(a_32808.value != term && !a_32808.value.match(term))
          break Fail1455;
      Success549:
      { 
        Fail1456:
        { 
          IStrategoTerm d_32808 = null;
          IStrategoTerm f_32808 = null;
          IStrategoTerm g_32808 = null;
          f_32808 = term;
          d_32808 = generated.const247;
          g_32808 = f_32808;
          term = dr_lookup_rule_0_2.instance.invoke(context, g_32808, d_32808, generated.constCons83);
          if(term == null)
            break Fail1456;
          if(true)
            break Success549;
        }
        term = generated.constNil3;
      }
      lifted528 lifted5280 = new lifted528();
      lifted5280.a_32808 = a_32808;
      term = filter_1_0.instance.invoke(context, term, lifted5280);
      if(term == null)
        break Fail1455;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}