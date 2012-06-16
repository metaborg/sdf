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

@SuppressWarnings("all") public class origin_column_0_0 extends Strategy 
{ 
  public static origin_column_0_0 instance = new origin_column_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail50:
    { 
      IStrategoTerm j_10713 = null;
      IStrategoTerm e_10902 = null;
      e_10902 = term;
      term = context.invokePrimitive("SSL_EXT_origin_location", e_10902, NO_STRATEGIES, new IStrategoTerm[]{term});
      if(term == null)
        break Fail50;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 4)
        break Fail50;
      j_10713 = term.getSubterm(1);
      term = j_10713;
      if(true)
        return term;
    }
    context.push("origin_column_0_0");
    context.popOnFailure();
    return null;
  }
}