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

@SuppressWarnings("all") final class lifted319 extends Strategy 
{ 
  TermReference e_9765;

  TermReference f_9765;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail650:
    { 
      term = aux_$Template$Lang$Cached$Option_0_2.instance.invoke(context, term, e_9765.value, f_9765.value);
      if(term == null)
        break Fail650;
      if(true)
        return term;
    }
    return null;
  }
}