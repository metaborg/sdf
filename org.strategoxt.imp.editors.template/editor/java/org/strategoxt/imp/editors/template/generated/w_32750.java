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

@SuppressWarnings("all") final class w_32750 extends Strategy 
{ 
  TermReference s_32749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1804:
    { 
      if(s_32749.value == null)
        break Fail1804;
      term = SRTS_one.instance.invoke(context, s_32749.value, lifted242.instance);
      if(term == null)
        break Fail1804;
      if(true)
        return term;
    }
    return null;
  }
}