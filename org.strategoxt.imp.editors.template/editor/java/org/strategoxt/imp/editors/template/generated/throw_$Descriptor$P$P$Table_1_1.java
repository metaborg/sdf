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

@SuppressWarnings("all") public class throw_$Descriptor$P$P$Table_1_1 extends Strategy 
{ 
  public static throw_$Descriptor$P$P$Table_1_1 instance = new throw_$Descriptor$P$P$Table_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_32804, IStrategoTerm o_32804)
  { 
    context.push("throw_DescriptorPPTable_1_1");
    Fail1435:
    { 
      IStrategoTerm r_32804 = null;
      r_32804 = term;
      term = dr_throw_1_2.instance.invoke(context, r_32804, p_32804, o_32804, generated.const247);
      if(term == null)
        break Fail1435;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}