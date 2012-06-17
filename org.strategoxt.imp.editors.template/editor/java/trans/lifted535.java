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

@SuppressWarnings("all") final class lifted535 extends Strategy 
{ 
  TermReference e_32993;

  TermReference f_32993;

  Strategy p_32993;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail2116:
    { 
      IStrategoTerm k_32993 = null;
      IStrategoTerm l_32993 = null;
      IStrategoTerm x_32993 = null;
      IStrategoTerm y_32993 = null;
      IStrategoTerm a_32994 = null;
      IStrategoTerm b_32994 = null;
      IStrategoTerm c_32994 = null;
      k_32993 = term;
      if(e_32993.value == null)
        break Fail2116;
      term = e_32993.value;
      l_32993 = e_32993.value;
      a_32994 = term;
      x_32993 = trans.const273;
      b_32994 = a_32994;
      y_32993 = trans.constCons84;
      c_32994 = b_32994;
      term = termFactory.makeTuple(trans.const274, l_32993);
      term = dr_set_rule_0_3.instance.invoke(context, c_32994, x_32993, y_32993, term);
      if(term == null)
        break Fail2116;
      term = k_32993;
      if(f_32993.value == null)
        break Fail2116;
      term = p_32993.invoke(context, f_32993.value);
      if(term == null)
        break Fail2116;
      if(true)
        return term;
    }
    return null;
  }
}