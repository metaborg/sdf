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

@SuppressWarnings("all") final class lifted318 extends Strategy 
{ 
  TermReference p_32760;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1688:
    { 
      if(p_32760.value == null)
        p_32760.value = term;
      else
        if(p_32760.value != term && !p_32760.value.match(term))
          break Fail1688;
      if(true)
        return term;
    }
    return null;
  }
}