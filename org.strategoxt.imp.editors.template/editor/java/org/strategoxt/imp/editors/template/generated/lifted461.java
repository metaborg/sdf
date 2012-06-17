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

@SuppressWarnings("all") final class lifted461 extends Strategy 
{ 
  public static final lifted461 instance = new lifted461();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1523:
    { 
      term = unquoted_1_0.instance.invoke(context, term, lifted462.instance);
      if(term == null)
        break Fail1523;
      if(true)
        return term;
    }
    return null;
  }
}