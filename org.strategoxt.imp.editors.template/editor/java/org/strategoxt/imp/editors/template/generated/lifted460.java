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

@SuppressWarnings("all") final class lifted460 extends Strategy 
{ 
  Strategy w_32795;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1519:
    { 
      lifted463 lifted4630 = new lifted463();
      lifted4630.w_32795 = w_32795;
      term = appl_2_0.instance.invoke(context, term, lifted461.instance, lifted4630);
      if(term == null)
        break Fail1519;
      if(true)
        return term;
    }
    return null;
  }
}