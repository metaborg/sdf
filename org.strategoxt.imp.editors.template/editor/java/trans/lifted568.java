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

@SuppressWarnings("all") final class lifted568 extends Strategy 
{ 
  TermReference n_33009;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2079:
    { 
      IStrategoTerm o_33009 = null;
      IStrategoTerm q_33009 = null;
      IStrategoTerm r_33009 = null;
      q_33009 = term;
      o_33009 = trans.constCritical1;
      r_33009 = q_33009;
      term = log_0_3.instance.invoke(context, r_33009, o_33009, trans.const309, n_33009.value);
      if(term == null)
        break Fail2079;
      term = exit_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail2079;
      if(true)
        return term;
    }
    return null;
  }
}