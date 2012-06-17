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

@SuppressWarnings("all") final class lifted269 extends Strategy 
{ 
  TermReference e_32756;

  TermReference f_32756;

  TermReference g_32756;

  TermReference h_32756;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1746:
    { 
      if(e_32756.value == null)
        break Fail1746;
      term = template_to_sdf_0_0.instance.invoke(context, e_32756.value);
      if(term == null)
        break Fail1746;
      if(f_32756.value == null)
        f_32756.value = term;
      else
        if(f_32756.value != term && !f_32756.value.match(term))
          break Fail1746;
      if(g_32756.value == null)
        break Fail1746;
      term = g_32756.value;
      IStrategoTerm term352 = term;
      Success632:
      { 
        Fail1747:
        { 
          term = attrs_1_0.instance.invoke(context, term, lifted270.instance);
          if(term == null)
            break Fail1747;
          if(true)
            break Success632;
        }
        term = no_attrs_0_0.instance.invoke(context, term352);
        if(term == null)
          break Fail1746;
      }
      if(h_32756.value == null)
        h_32756.value = term;
      else
        if(h_32756.value != term && !h_32756.value.match(term))
          break Fail1746;
      if(true)
        return term;
    }
    return null;
  }
}