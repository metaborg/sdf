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

@SuppressWarnings("all") public class break_to_label_$Descriptor$P$P$Table_0_1 extends Strategy 
{ 
  public static break_to_label_$Descriptor$P$P$Table_0_1 instance = new break_to_label_$Descriptor$P$P$Table_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm q_9766)
  { 
    context.push("break_to_label_DescriptorPPTable_0_1");
    Fail619:
    { 
      IStrategoTerm s_9766 = null;
      s_9766 = term;
      term = dr_break_0_2.instance.invoke(context, s_9766, generated.const126, q_9766);
      if(term == null)
        break Fail619;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}