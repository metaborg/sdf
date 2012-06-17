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

@SuppressWarnings("all") final class lifted227 extends Strategy 
{ 
  TermReference r_32748;

  TermReference s_32748;

  TermReference t_32748;

  TermReference u_32748;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1815:
    { 
      if(r_32748.value == null || s_32748.value == null)
        break Fail1815;
      term = termFactory.makeTuple(r_32748.value, s_32748.value);
      term = thread_map_1_0.instance.invoke(context, term, lifted228.instance);
      if(term == null)
        break Fail1815;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1815;
      if(t_32748.value == null)
        t_32748.value = term.getSubterm(0);
      else
        if(t_32748.value != term.getSubterm(0) && !t_32748.value.match(term.getSubterm(0)))
          break Fail1815;
      if(u_32748.value == null)
        u_32748.value = term.getSubterm(1);
      else
        if(u_32748.value != term.getSubterm(1) && !u_32748.value.match(term.getSubterm(1)))
          break Fail1815;
      if(true)
        return term;
    }
    return null;
  }
}