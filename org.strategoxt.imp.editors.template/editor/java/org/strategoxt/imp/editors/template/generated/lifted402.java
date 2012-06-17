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

@SuppressWarnings("all") final class lifted402 extends Strategy 
{ 
  TermReference c_32775;

  TermReference d_32775;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1602:
    { 
      if(c_32775.value == null)
        break Fail1602;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, c_32775.value, lifted403.instance);
      if(term == null)
        break Fail1602;
      if(d_32775.value == null)
        d_32775.value = term;
      else
        if(d_32775.value != term && !d_32775.value.match(term))
          break Fail1602;
      if(true)
        return term;
    }
    return null;
  }
}