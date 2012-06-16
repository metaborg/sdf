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

@SuppressWarnings("all") final class lifted70 extends Strategy 
{ 
  TermReference w_9717;

  TermReference x_9717;

  TermReference y_9717;

  TermReference z_9717;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail926:
    { 
      if(w_9717.value == null)
        break Fail926;
      term = template_to_sdf_0_0.instance.invoke(context, w_9717.value);
      if(term == null)
        break Fail926;
      if(x_9717.value == null)
        x_9717.value = term;
      else
        if(x_9717.value != term && !x_9717.value.match(term))
          break Fail926;
      if(y_9717.value == null)
        break Fail926;
      term = y_9717.value;
      IStrategoTerm term97 = term;
      Success376:
      { 
        Fail927:
        { 
          term = attrs_1_0.instance.invoke(context, term, lifted71.instance);
          if(term == null)
            break Fail927;
          if(true)
            break Success376;
        }
        term = no_attrs_0_0.instance.invoke(context, term97);
        if(term == null)
          break Fail926;
      }
      if(z_9717.value == null)
        z_9717.value = term;
      else
        if(z_9717.value != term && !z_9717.value.match(term))
          break Fail926;
      if(true)
        return term;
    }
    return null;
  }
}