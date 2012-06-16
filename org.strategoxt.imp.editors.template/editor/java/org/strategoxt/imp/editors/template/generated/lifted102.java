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

@SuppressWarnings("all") final class lifted102 extends Strategy 
{ 
  TermReference w_9720;

  TermReference x_9720;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail896:
    { 
      if(w_9720.value == null)
        break Fail896;
      term = separator_to_literal_0_0.instance.invoke(context, w_9720.value);
      if(term == null)
        break Fail896;
      if(x_9720.value == null)
        x_9720.value = term;
      else
        if(x_9720.value != term && !x_9720.value.match(term))
          break Fail896;
      if(true)
        return term;
    }
    return null;
  }
}