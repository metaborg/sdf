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

@SuppressWarnings("all") final class lifted526 extends Strategy 
{ 
  TermReference i_32807;

  TermReference j_32807;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1462:
    { 
      term = aux_$Descriptor$P$P$Table_0_1.instance.invoke(context, term, i_32807.value);
      if(term == null)
        break Fail1462;
      if(j_32807.value == null)
        j_32807.value = term;
      else
        if(j_32807.value != term && !j_32807.value.match(term))
          break Fail1462;
      if(true)
        return term;
    }
    return null;
  }
}