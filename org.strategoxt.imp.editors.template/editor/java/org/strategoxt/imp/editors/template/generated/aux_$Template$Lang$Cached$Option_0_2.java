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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm g_32804, IStrategoTerm h_32804)
  { 
    Fail1432:
    { 
      IStrategoTerm i_32804 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1432;
      IStrategoTerm arg778 = term.getSubterm(0);
      if(arg778.getTermType() != IStrategoTerm.STRING || !"-431918".equals(((IStrategoString)arg778).stringValue()))
        break Fail1432;
      i_32804 = term.getSubterm(1);
      term = i_32804;
      if(true)
        return term;
    }
    context.push("aux_TemplateLangCachedOption_0_2");
    context.popOnFailure();
    return null;
  }
}