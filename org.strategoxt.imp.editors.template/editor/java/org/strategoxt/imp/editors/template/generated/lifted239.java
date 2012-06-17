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

@SuppressWarnings("all") final class lifted239 extends Strategy 
{ 
  TermReference b_32752;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1807:
    { 
      term = placeholder_to_pp_one_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1807;
      if(b_32752.value == null)
        b_32752.value = term;
      else
        if(b_32752.value != term && !b_32752.value.match(term))
          break Fail1807;
      if(true)
        return term;
    }
    return null;
  }
}