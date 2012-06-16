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

@SuppressWarnings("all") final class lifted118 extends Strategy 
{ 
  TermReference d_9722;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail867:
    { 
      IStrategoTerm f_9722 = null;
      TermReference g_9722 = new TermReference();
      f_9722 = term;
      if(g_9722.value == null)
        g_9722.value = term;
      else
        if(g_9722.value != term && !g_9722.value.match(term))
          break Fail867;
      if(d_9722.value == null)
        break Fail867;
      term = d_9722.value;
      lifted119 lifted1190 = new lifted119();
      lifted1190.g_9722 = g_9722;
      term = SRTS_one.instance.invoke(context, term, lifted1190);
      if(term == null)
        break Fail867;
      term = f_9722;
      if(true)
        return term;
    }
    return null;
  }
}