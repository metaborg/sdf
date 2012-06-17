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

@SuppressWarnings("all") final class lifted434 extends Strategy 
{ 
  public static final lifted434 instance = new lifted434();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1550:
    { 
      term = try_1_0.instance.invoke(context, term, pp_fix_string_quotes_0_0.instance);
      if(term == null)
        break Fail1550;
      if(true)
        return term;
    }
    return null;
  }
}