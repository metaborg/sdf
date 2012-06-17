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

@SuppressWarnings("all") final class lifted306 extends Strategy 
{ 
  TermReference u_32758;

  TermReference v_32758;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1709:
    { 
      if(u_32758.value == null)
        break Fail1709;
      term = separator_to_literal_0_0.instance.invoke(context, u_32758.value);
      if(term == null)
        break Fail1709;
      if(v_32758.value == null)
        v_32758.value = term;
      else
        if(v_32758.value != term && !v_32758.value.match(term))
          break Fail1709;
      if(true)
        return term;
    }
    return null;
  }
}