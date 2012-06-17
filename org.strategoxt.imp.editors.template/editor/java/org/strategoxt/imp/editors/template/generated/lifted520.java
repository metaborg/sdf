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

@SuppressWarnings("all") final class lifted520 extends Strategy 
{ 
  TermReference a_32804;

  TermReference b_32804;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1468:
    { 
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, term, a_32804.value, b_32804.value);
      if(term == null)
        break Fail1468;
      if(true)
        return term;
    }
    return null;
  }
}