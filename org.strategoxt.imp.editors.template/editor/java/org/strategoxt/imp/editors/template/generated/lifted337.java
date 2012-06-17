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

@SuppressWarnings("all") final class lifted337 extends Strategy 
{ 
  public static final lifted337 instance = new lifted337();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1677:
    { 
      IStrategoTerm r_32762 = null;
      IStrategoTerm t_32762 = null;
      IStrategoTerm u_32762 = null;
      t_32762 = term;
      r_32762 = generated.const205;
      u_32762 = t_32762;
      term = string_replace_0_2.instance.invoke(context, u_32762, r_32762, generated.const206);
      if(term == null)
        break Fail1677;
      if(true)
        return term;
    }
    return null;
  }
}