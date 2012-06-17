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

@SuppressWarnings("all") final class lifted215 extends Strategy 
{ 
  TermReference o_32744;

  TermReference p_32744;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1825:
    { 
      if(o_32744.value == null)
        break Fail1825;
      term = map_1_0.instance.invoke(context, o_32744.value, template_to_prettyprint_strategy_0_0.instance);
      if(term == null)
        break Fail1825;
      if(p_32744.value == null)
        p_32744.value = term;
      else
        if(p_32744.value != term && !p_32744.value.match(term))
          break Fail1825;
      if(true)
        return term;
    }
    return null;
  }
}