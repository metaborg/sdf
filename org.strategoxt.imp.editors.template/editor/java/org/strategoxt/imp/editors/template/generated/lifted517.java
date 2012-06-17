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

@SuppressWarnings("all") final class lifted517 extends Strategy 
{ 
  TermReference i_32803;

  TermReference f_32803;

  TermReference g_32803;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1471:
    { 
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, term, i_32803.value, f_32803.value);
      if(term == null)
        break Fail1471;
      if(g_32803.value == null)
        g_32803.value = term;
      else
        if(g_32803.value != term && !g_32803.value.match(term))
          break Fail1471;
      if(true)
        return term;
    }
    return null;
  }
}