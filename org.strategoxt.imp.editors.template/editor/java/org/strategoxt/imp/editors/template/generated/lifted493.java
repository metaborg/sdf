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

@SuppressWarnings("all") final class lifted493 extends Strategy 
{ 
  public static final lifted493 instance = new lifted493();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1494:
    { 
      term = fun_1_0.instance.invoke(context, term, lifted494.instance);
      if(term == null)
        break Fail1494;
      if(true)
        return term;
    }
    return null;
  }
}