package trans;

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

@SuppressWarnings("all") public class origin_strip_0_0 extends Strategy 
{ 
  public static origin_strip_0_0 instance = new origin_strip_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail52:
    { 
      IStrategoTerm p_10713 = null;
      p_10713 = term;
      term = context.invokePrimitive("SSL_EXT_origin_strip", p_10713, NO_STRATEGIES, new IStrategoTerm[]{term});
      if(term == null)
        break Fail52;
      if(true)
        return term;
    }
    context.push("origin_strip_0_0");
    context.popOnFailure();
    return null;
  }
}