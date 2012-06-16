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

@SuppressWarnings("all") final class lifted208 extends Strategy 
{ 
  public static final lifted208 instance = new lifted208();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail781:
    { 
      IStrategoTerm p_9736 = null;
      IStrategoTerm r_9736 = null;
      IStrategoTerm s_9736 = null;
      r_9736 = term;
      p_9736 = generated.const85;
      s_9736 = r_9736;
      term = string_replace_0_2.instance.invoke(context, s_9736, p_9736, generated.const84);
      if(term == null)
        break Fail781;
      if(true)
        return term;
    }
    return null;
  }
}