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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_33023)
  { 
    context.push("position_of_term_1_0");
    Fail1903:
    { 
      IStrategoTerm term704 = term;
      Success690:
      { 
        Fail1904:
        { 
          term = z_33023.invoke(context, term);
          if(term == null)
            break Fail1904;
          term = trans.constNil4;
          if(true)
            break Success690;
        }
        term = term704;
        IStrategoTerm d_33001 = null;
        IStrategoTerm args10 = context.invokePrimitive("SSL_get_arguments", term, NO_STRATEGIES, new IStrategoTerm[]{term});
        d_33001 = args10;
        term = position_of_term_1_1.instance.invoke(context, d_33001, z_33023, trans.const289);
        if(term == null)
          break Fail1903;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}