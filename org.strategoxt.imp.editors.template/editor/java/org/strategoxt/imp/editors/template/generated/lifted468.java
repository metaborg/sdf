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

@SuppressWarnings("all") final class lifted468 extends Strategy 
{ 
  public static final lifted468 instance = new lifted468();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1515:
    { 
      term = fun_1_0.instance.invoke(context, term, lifted469.instance);
      if(term == null)
        break Fail1515;
      if(true)
        return term;
    }
    return null;
  }
}