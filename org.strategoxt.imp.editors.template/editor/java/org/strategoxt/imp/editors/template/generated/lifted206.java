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

@SuppressWarnings("all") final class lifted206 extends Strategy 
{ 
  TermReference e_32744;

  TermReference f_32744;

  TermReference r_32808;

  TermReference g_32744;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1830:
    { 
      if(f_32744.value == null)
        break Fail1830;
      term = map_1_0.instance.invoke(context, f_32744.value, template_to_prettyprint_strategy_0_0.instance);
      if(term == null)
        break Fail1830;
      if(e_32744.value == null)
        e_32744.value = term;
      else
        if(e_32744.value != term && !e_32744.value.match(term))
          break Fail1830;
      if(f_32744.value == null)
        break Fail1830;
      term = f_32744.value;
      lifted208 lifted2080 = new lifted208();
      lifted2080.r_32808 = r_32808;
      term = map_1_0.instance.invoke(context, term, lifted2080);
      if(term == null)
        break Fail1830;
      term = nub_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1830;
      if(g_32744.value == null)
        g_32744.value = term;
      else
        if(g_32744.value != term && !g_32744.value.match(term))
          break Fail1830;
      if(true)
        return term;
    }
    return null;
  }
}