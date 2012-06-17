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

@SuppressWarnings("all") final class lifted498 extends Strategy 
{ 
  Strategy y_32795;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1487:
    { 
      lifted501 lifted5010 = new lifted501();
      lifted5010.y_32795 = y_32795;
      term = appl_2_0.instance.invoke(context, term, lifted499.instance, lifted5010);
      if(term == null)
        break Fail1487;
      if(true)
        return term;
    }
    return null;
  }
}