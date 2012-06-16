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

@SuppressWarnings("all") public class aux_$Template$Lang$Cached$Option_0_2 extends Strategy 
{ 
  public static aux_$Template$Lang$Cached$Option_0_2 instance = new aux_$Template$Lang$Cached$Option_0_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm x_9765, IStrategoTerm y_9765)
  { 
    Fail612:
    { 
      IStrategoTerm z_9765 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail612;
      IStrategoTerm arg625 = term.getSubterm(0);
      if(arg625.getTermType() != IStrategoTerm.STRING || !"-431918".equals(((IStrategoString)arg625).stringValue()))
        break Fail612;
      z_9765 = term.getSubterm(1);
      term = z_9765;
      if(true)
        return term;
    }
    context.push("aux_TemplateLangCachedOption_0_2");
    context.popOnFailure();
    return null;
  }
}