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

@SuppressWarnings("all") final class lifted516 extends Strategy 
{ 
  TermReference y_32802;

  TermReference z_32802;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1472:
    { 
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, term, y_32802.value, z_32802.value);
      if(term == null)
        break Fail1472;
      if(true)
        return term;
    }
    return null;
  }
}