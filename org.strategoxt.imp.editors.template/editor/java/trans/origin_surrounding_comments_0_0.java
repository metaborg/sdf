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
    Fail55:
    { 
      IStrategoTerm b_10714 = null;
      IStrategoTerm d_10714 = null;
      IStrategoTerm e_10714 = null;
      d_10714 = term;
      b_10714 = trans.const19;
      term = d_10714;
      e_10714 = d_10714;
      term = context.invokePrimitive("SSL_EXT_origin_surrounding_comments", e_10714, NO_STRATEGIES, new IStrategoTerm[]{b_10714, term});
      if(term == null)
        break Fail55;
      if(true)
        return term;
    }
    context.push("origin_surrounding_comments_0_0");
    context.popOnFailure();
    return null;
  }
}