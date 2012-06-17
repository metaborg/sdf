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

@SuppressWarnings("all") public class throw_$Expanded_1_1 extends Strategy 
{ 
  public static throw_$Expanded_1_1 instance = new throw_$Expanded_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_32796, IStrategoTerm j_32796)
  { 
    context.push("throw_Expanded_1_1");
    Fail1383:
    { 
      IStrategoTerm m_32796 = null;
      m_32796 = term;
      term = dr_throw_1_2.instance.invoke(context, m_32796, k_32796, j_32796, generated.const217);
      if(term == null)
        break Fail1383;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}