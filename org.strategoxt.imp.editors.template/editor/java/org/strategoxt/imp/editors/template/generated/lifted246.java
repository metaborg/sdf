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

@SuppressWarnings("all") final class lifted246 extends Strategy 
{ 
  TermReference s_9749;

  TermReference t_9749;

  Strategy u_9749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail718:
    { 
      term = contract_requires_1_2.instance.invoke(context, term, u_9749, s_9749.value, t_9749.value);
      if(term == null)
        break Fail718;
      if(true)
        return term;
    }
    return null;
  }
}