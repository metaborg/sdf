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
    Fail1450:
    { 
      TermReference a_32807 = new TermReference();
      if(a_32807.value == null)
        a_32807.value = term;
      else
        if(a_32807.value != term && !a_32807.value.match(term))
          break Fail1450;
      Success547:
      { 
        Fail1451:
        { 
          IStrategoTerm d_32807 = null;
          IStrategoTerm f_32807 = null;
          IStrategoTerm g_32807 = null;
          f_32807 = term;
          d_32807 = generated.const247;
          g_32807 = f_32807;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, g_32807, d_32807, generated.constCons83);
          if(term == null)
            break Fail1451;
          if(true)
            break Success547;
        }
        term = generated.constNil3;
      }
      lifted525 lifted5250 = new lifted525();
      lifted5250.a_32807 = a_32807;
      term = filter_1_0.instance.invoke(context, term, lifted5250);
      if(term == null)
        break Fail1450;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}