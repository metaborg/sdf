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

@SuppressWarnings("all") final class lifted133 extends Strategy 
{ 
  public static final lifted133 instance = new lifted133();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail860:
    { 
      term = try_1_0.instance.invoke(context, term, lifted134.instance);
      if(term == null)
        break Fail860;
      if(true)
        return term;
    }
    return null;
  }
}