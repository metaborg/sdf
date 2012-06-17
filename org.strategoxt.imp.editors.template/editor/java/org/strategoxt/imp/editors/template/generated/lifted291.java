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

@SuppressWarnings("all") final class lifted291 extends Strategy 
{ 
  public static final lifted291 instance = new lifted291();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1727:
    { 
      term = is_substring_1_0.instance.invoke(context, term, lifted292.instance);
      if(term == null)
        break Fail1727;
      if(true)
        return term;
    }
    return null;
  }
}