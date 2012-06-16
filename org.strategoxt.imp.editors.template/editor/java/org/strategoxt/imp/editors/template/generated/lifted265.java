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

@SuppressWarnings("all") final class lifted265 extends Strategy 
{ 
  Strategy n_9757;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail701:
    { 
      lifted266 lifted2660 = new lifted266();
      lifted2660.n_9757 = n_9757;
      term = fun_1_0.instance.invoke(context, term, lifted2660);
      if(term == null)
        break Fail701;
      if(true)
        return term;
    }
    return null;
  }
}