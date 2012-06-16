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

@SuppressWarnings("all") public class position_of_term_1_0 extends Strategy 
{ 
  public static position_of_term_1_0 instance = new position_of_term_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_10737)
  { 
    context.push("position_of_term_1_0");
    Fail62:
    { 
      IStrategoTerm term38 = term;
      Success24:
      { 
        Fail63:
        { 
          term = j_10737.invoke(context, term);
          if(term == null)
            break Fail63;
          term = trans.constNil0;
          if(true)
            break Success24;
        }
        term = term38;
        IStrategoTerm q_10715 = null;
        IStrategoTerm args1 = context.invokePrimitive("SSL_get_arguments", term, NO_STRATEGIES, new IStrategoTerm[]{term});
        q_10715 = args1;
        term = position_of_term_1_1.instance.invoke(context, q_10715, j_10737, trans.const20);
        if(term == null)
          break Fail62;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}