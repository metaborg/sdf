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

@SuppressWarnings("all") final class lifted218 extends Strategy 
{ 
  TermReference k_32744;

  TermReference l_32744;

  TermReference m_32744;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1823:
    { 
      if(k_32744.value == null)
        break Fail1823;
      term = filter_1_0.instance.invoke(context, k_32744.value, templatelang_prod_to_sort_0_0.instance);
      if(term == null)
        break Fail1823;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1823;
      if(l_32744.value == null)
        l_32744.value = term;
      else
        if(l_32744.value != term && !l_32744.value.match(term))
          break Fail1823;
      if(l_32744.value == null)
        break Fail1823;
      term = map_1_0.instance.invoke(context, l_32744.value, templatelang_sort_to_strategy_0_0.instance);
      if(term == null)
        break Fail1823;
      if(m_32744.value == null)
        m_32744.value = term;
      else
        if(m_32744.value != term && !m_32744.value.match(term))
          break Fail1823;
      if(true)
        return term;
    }
    return null;
  }
}