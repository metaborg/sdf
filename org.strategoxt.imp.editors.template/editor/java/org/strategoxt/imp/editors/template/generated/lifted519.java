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

@SuppressWarnings("all") final class lifted519 extends Strategy 
{ 
  TermReference u_32803;

  TermReference v_32803;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1469:
    { 
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, term, u_32803.value, v_32803.value);
      if(term == null)
        break Fail1469;
      if(true)
        return term;
    }
    return null;
  }
}