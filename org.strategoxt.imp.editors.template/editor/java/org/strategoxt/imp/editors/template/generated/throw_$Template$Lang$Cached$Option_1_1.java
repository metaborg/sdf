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

@SuppressWarnings("all") public class throw_$Template$Lang$Cached$Option_1_1 extends Strategy 
{ 
  public static throw_$Template$Lang$Cached$Option_1_1 instance = new throw_$Template$Lang$Cached$Option_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32800, IStrategoTerm m_32800)
  { 
    context.push("throw_TemplateLangCachedOption_1_1");
    Fail1409:
    { 
      IStrategoTerm p_32800 = null;
      p_32800 = term;
      term = dr_throw_1_2.instance.invoke(context, p_32800, n_32800, m_32800, generated.const237);
      if(term == null)
        break Fail1409;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}