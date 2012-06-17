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

@SuppressWarnings("all") public class origin_surrounding_comments_0_0 extends Strategy 
{ 
  public static origin_surrounding_comments_0_0 instance = new origin_surrounding_comments_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1896:
    { 
      IStrategoTerm o_32999 = null;
      IStrategoTerm q_32999 = null;
      IStrategoTerm r_32999 = null;
      q_32999 = term;
      o_32999 = trans.const272;
      term = q_32999;
      r_32999 = q_32999;
      term = context.invokePrimitive("SSL_EXT_origin_surrounding_comments", r_32999, NO_STRATEGIES, new IStrategoTerm[]{o_32999, term});
      if(term == null)
        break Fail1896;
      if(true)
        return term;
    }
    context.push("origin_surrounding_comments_0_0");
    context.popOnFailure();
    return null;
  }
}