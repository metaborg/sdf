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

@SuppressWarnings("all") final class lifted327 extends Strategy 
{ 
  TermReference z_9768;

  TermReference a_9769;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail642:
    { 
      term = aux_$Descriptor$P$P$Table_0_1.instance.invoke(context, term, z_9768.value);
      if(term == null)
        break Fail642;
      if(a_9769.value == null)
        a_9769.value = term;
      else
        if(a_9769.value != term && !a_9769.value.match(term))
          break Fail642;
      if(true)
        return term;
    }
    return null;
  }
}