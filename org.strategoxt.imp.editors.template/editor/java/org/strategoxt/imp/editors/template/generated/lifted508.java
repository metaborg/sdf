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

@SuppressWarnings("all") final class lifted508 extends Strategy 
{ 
  TermReference c_32799;

  TermReference d_32799;

  TermReference e_32799;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1480:
    { 
      term = aux_$Expanded_0_2.instance.invoke(context, term, c_32799.value, d_32799.value);
      if(term == null)
        break Fail1480;
      if(e_32799.value == null)
        e_32799.value = term;
      else
        if(e_32799.value != term && !e_32799.value.match(term))
          break Fail1480;
      if(true)
        return term;
    }
    return null;
  }
}