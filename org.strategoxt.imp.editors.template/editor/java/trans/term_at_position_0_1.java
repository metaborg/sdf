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

@SuppressWarnings("all") public class term_at_position_0_1 extends Strategy 
{ 
  public static term_at_position_0_1 instance = new term_at_position_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm r_33001)
  { 
    context.push("term_at_position_0_1");
    Fail1907:
    { 
      TermReference t_33001 = new TermReference();
      IStrategoTerm u_33001 = null;
      u_33001 = term;
      lifted550 lifted5500 = new lifted550();
      lifted5500.t_33001 = t_33001;
      term = at_position_1_1.instance.invoke(context, term, lifted5500, r_33001);
      if(term == null)
        break Fail1907;
      term = u_33001;
      if(t_33001.value == null)
        break Fail1907;
      term = t_33001.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}