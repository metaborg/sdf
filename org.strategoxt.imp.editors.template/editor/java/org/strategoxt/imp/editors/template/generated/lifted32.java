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

@SuppressWarnings("all") final class lifted32 extends Strategy 
{ 
  TermReference s_9710;

  TermReference t_9710;

  TermReference u_9710;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail993:
    { 
      if(t_9710.value == null)
        break Fail993;
      term = termFactory.makeTuple(generated.const49, t_9710.value);
      term = addi_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail993;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0);
      term = implode_string_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail993;
      if(s_9710.value == null)
        s_9710.value = term;
      else
        if(s_9710.value != term && !s_9710.value.match(term))
          break Fail993;
      if(t_9710.value == null)
        break Fail993;
      term = inc_0_0.instance.invoke(context, t_9710.value);
      if(term == null)
        break Fail993;
      if(u_9710.value == null)
        u_9710.value = term;
      else
        if(u_9710.value != term && !u_9710.value.match(term))
          break Fail993;
      if(true)
        return term;
    }
    return null;
  }
}