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

@SuppressWarnings("all") final class lifted301 extends Strategy 
{ 
  TermReference e_32759;

  TermReference f_32759;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1716:
    { 
      if(e_32759.value == null)
        break Fail1716;
      term = separator_to_literal_0_0.instance.invoke(context, e_32759.value);
      if(term == null)
        break Fail1716;
      if(f_32759.value == null)
        f_32759.value = term;
      else
        if(f_32759.value != term && !f_32759.value.match(term))
          break Fail1716;
      if(true)
        return term;
    }
    return null;
  }
}