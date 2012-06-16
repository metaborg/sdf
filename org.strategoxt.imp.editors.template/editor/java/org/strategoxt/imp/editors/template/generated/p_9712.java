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

@SuppressWarnings("all") final class p_9712 extends Strategy 
{ 
  TermReference k_9711;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail982:
    { 
      if(k_9711.value == null)
        break Fail982;
      term = SRTS_one.instance.invoke(context, k_9711.value, lifted44.instance);
      if(term == null)
        break Fail982;
      if(true)
        return term;
    }
    return null;
  }
}