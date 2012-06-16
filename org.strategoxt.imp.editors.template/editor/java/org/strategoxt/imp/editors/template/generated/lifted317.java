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

@SuppressWarnings("all") final class lifted317 extends Strategy 
{ 
  TermReference p_9764;

  TermReference q_9764;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail652:
    { 
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, term, p_9764.value, q_9764.value);
      if(term == null)
        break Fail652;
      if(true)
        return term;
    }
    return null;
  }
}