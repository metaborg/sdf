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

@SuppressWarnings("all") final class lifted253 extends Strategy 
{ 
  TermReference t_32753;

  TermReference u_32753;

  TermReference v_32753;

  TermReference w_32753;

  TermReference x_32753;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1763:
    { 
      if(t_32753.value == null)
        break Fail1763;
      term = mapconcat_1_0.instance.invoke(context, t_32753.value, lifted254.instance);
      if(term == null)
        break Fail1763;
      if(v_32753.value == null)
        v_32753.value = term;
      else
        if(v_32753.value != term && !v_32753.value.match(term))
          break Fail1763;
      if(u_32753.value == null || (v_32753.value == null || w_32753.value == null))
        break Fail1763;
      term = termFactory.makeTuple(u_32753.value, v_32753.value, w_32753.value);
      term = templatelang_to_signature_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1763;
      if(x_32753.value == null)
        x_32753.value = term;
      else
        if(x_32753.value != term && !x_32753.value.match(term))
          break Fail1763;
      if(true)
        return term;
    }
    return null;
  }
}