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

@SuppressWarnings("all") final class lifted290 extends Strategy 
{ 
  public static final lifted290 instance = new lifted290();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail672:
    { 
      term = appl_2_0.instance.invoke(context, term, lifted291.instance, lifted293.instance);
      if(term == null)
        break Fail672;
      if(true)
        return term;
    }
    return null;
  }
}