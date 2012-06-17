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

@SuppressWarnings("all") final class lifted406 extends Strategy 
{ 
  TermReference v_32774;

  TermReference w_32774;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1600:
    { 
      if(v_32774.value == null)
        break Fail1600;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, v_32774.value, lifted407.instance);
      if(term == null)
        break Fail1600;
      if(w_32774.value == null)
        w_32774.value = term;
      else
        if(w_32774.value != term && !w_32774.value.match(term))
          break Fail1600;
      if(true)
        return term;
    }
    return null;
  }
}