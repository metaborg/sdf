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

@SuppressWarnings("all") final class lifted119 extends Strategy 
{ 
  TermReference g_9722;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail868:
    { 
      if(g_9722.value == null)
        g_9722.value = term;
      else
        if(g_9722.value != term && !g_9722.value.match(term))
          break Fail868;
      if(true)
        return term;
    }
    return null;
  }
}