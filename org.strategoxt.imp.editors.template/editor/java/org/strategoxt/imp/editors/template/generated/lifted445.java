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

@SuppressWarnings("all") final class lifted445 extends Strategy 
{ 
  TermReference b_32788;

  TermReference c_32788;

  Strategy d_32788;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1538:
    { 
      term = contract_requires_1_2.instance.invoke(context, term, d_32788, b_32788.value, c_32788.value);
      if(term == null)
        break Fail1538;
      if(true)
        return term;
    }
    return null;
  }
}