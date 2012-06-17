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

@SuppressWarnings("all") final class lifted268 extends Strategy 
{ 
  TermReference y_32755;

  TermReference z_32755;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1751:
    { 
      if(y_32755.value == null)
        break Fail1751;
      term = template_to_sdf_0_0.instance.invoke(context, y_32755.value);
      if(term == null)
        break Fail1751;
      if(z_32755.value == null)
        z_32755.value = term;
      else
        if(z_32755.value != term && !z_32755.value.match(term))
          break Fail1751;
      if(true)
        return term;
    }
    return null;
  }
}