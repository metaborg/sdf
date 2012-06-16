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

@SuppressWarnings("all") final class lifted51 extends Strategy 
{ 
  TermReference s_9715;

  TermReference t_9715;

  TermReference u_9715;

  TermReference v_9715;

  TermReference w_9715;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail947:
    { 
      if(s_9715.value == null)
        break Fail947;
      term = filter_1_0.instance.invoke(context, s_9715.value, lifted52.instance);
      if(term == null)
        break Fail947;
      if(u_9715.value == null)
        u_9715.value = term;
      else
        if(u_9715.value != term && !u_9715.value.match(term))
          break Fail947;
      if(t_9715.value == null || (u_9715.value == null || v_9715.value == null))
        break Fail947;
      term = termFactory.makeTuple(t_9715.value, u_9715.value, v_9715.value);
      term = templatelang_to_signature_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail947;
      if(w_9715.value == null)
        w_9715.value = term;
      else
        if(w_9715.value != term && !w_9715.value.match(term))
          break Fail947;
      if(true)
        return term;
    }
    return null;
  }
}