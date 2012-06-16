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

@SuppressWarnings("all") final class lifted193 extends Strategy 
{ 
  TermReference d_9735;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail808:
    { 
      TermReference o_9946 = new TermReference();
      IStrategoTerm u_9946 = null;
      u_9946 = term;
      if(d_9735.value == null)
        break Fail808;
      term = d_9735.value;
      if(o_9946.value == null)
        o_9946.value = term;
      else
        if(o_9946.value != term && !o_9946.value.match(term))
          break Fail808;
      term = u_9946;
      lifted194 lifted1940 = new lifted194();
      lifted1940.o_9946 = o_9946;
      term = $Line_1_0.instance.invoke(context, term, lifted1940);
      if(term == null)
        break Fail808;
      if(true)
        return term;
    }
    return null;
  }
}