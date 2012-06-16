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

@SuppressWarnings("all") final class lifted138 extends Strategy 
{ 
  public static final lifted138 instance = new lifted138();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail857:
    { 
      IStrategoTerm i_9724 = null;
      IStrategoTerm k_9724 = null;
      IStrategoTerm l_9724 = null;
      k_9724 = term;
      i_9724 = generated.const84;
      l_9724 = k_9724;
      term = string_replace_0_2.instance.invoke(context, l_9724, i_9724, generated.const85);
      if(term == null)
        break Fail857;
      if(true)
        return term;
    }
    return null;
  }
}