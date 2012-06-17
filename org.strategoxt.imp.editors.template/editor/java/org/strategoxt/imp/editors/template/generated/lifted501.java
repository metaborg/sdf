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

@SuppressWarnings("all") final class lifted501 extends Strategy 
{ 
  Strategy y_32795;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1488:
    { 
      term = $Cons_2_0.instance.invoke(context, term, y_32795, $Nil_0_0.instance);
      if(term == null)
        break Fail1488;
      if(true)
        return term;
    }
    return null;
  }
}