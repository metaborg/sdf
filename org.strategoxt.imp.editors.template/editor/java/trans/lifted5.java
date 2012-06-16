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

@SuppressWarnings("all") final class lifted5 extends Strategy 
{ 
  TermReference r_10707;

  TermReference s_10707;

  Strategy c_10708;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail268:
    { 
      IStrategoTerm x_10707 = null;
      IStrategoTerm y_10707 = null;
      IStrategoTerm k_10708 = null;
      IStrategoTerm l_10708 = null;
      IStrategoTerm n_10708 = null;
      IStrategoTerm o_10708 = null;
      IStrategoTerm p_10708 = null;
      x_10707 = term;
      if(r_10707.value == null)
        break Fail268;
      term = r_10707.value;
      y_10707 = r_10707.value;
      n_10708 = term;
      k_10708 = trans.const3;
      o_10708 = n_10708;
      l_10708 = trans.constCons0;
      p_10708 = o_10708;
      term = termFactory.makeTuple(trans.const4, y_10707);
      term = dr_set_rule_0_3.instance.invoke(context, p_10708, k_10708, l_10708, term);
      if(term == null)
        break Fail268;
      term = x_10707;
      if(s_10707.value == null)
        break Fail268;
      term = c_10708.invoke(context, s_10707.value);
      if(term == null)
        break Fail268;
      if(true)
        return term;
    }
    return null;
  }
}