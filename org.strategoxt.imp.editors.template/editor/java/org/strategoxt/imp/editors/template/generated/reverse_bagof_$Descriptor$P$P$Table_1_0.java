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

@SuppressWarnings("all") public class reverse_bagof_$Descriptor$P$P$Table_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Descriptor$P$P$Table_1_0 instance = new reverse_bagof_$Descriptor$P$P$Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_32807)
  { 
    context.push("reverse_bagof_DescriptorPPTable_1_0");
    Fail1453:
    { 
      TermReference s_32807 = new TermReference();
      if(s_32807.value == null)
        s_32807.value = term;
      else
        if(s_32807.value != term && !s_32807.value.match(term))
          break Fail1453;
      Success548:
      { 
        Fail1454:
        { 
          IStrategoTerm w_32807 = null;
          IStrategoTerm y_32807 = null;
          IStrategoTerm z_32807 = null;
          y_32807 = term;
          w_32807 = generated.const247;
          z_32807 = y_32807;
          term = dr_lookup_rule_0_2.instance.invoke(context, z_32807, w_32807, generated.constCons83);
          if(term == null)
            break Fail1454;
          if(true)
            break Success548;
        }
        term = generated.constNil3;
      }
      lifted527 lifted5270 = new lifted527();
      lifted5270.s_32807 = s_32807;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted5270, u_32807);
      if(term == null)
        break Fail1453;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}