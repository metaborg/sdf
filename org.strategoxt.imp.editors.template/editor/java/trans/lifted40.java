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

@SuppressWarnings("all") final class lifted40 extends Strategy 
{ 
  public static final lifted40 instance = new lifted40();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail230:
    { 
      IStrategoTerm o_10724 = null;
      IStrategoTerm p_10724 = null;
      IStrategoTerm q_10724 = null;
      IStrategoTerm a_10725 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail230;
      a_10725 = term.getSubterm(0);
      IStrategoTerm arg34 = term.getSubterm(1);
      o_10724 = arg34;
      if(arg34.getTermType() != IStrategoTerm.TUPLE || arg34.getSubtermCount() != 2)
        break Fail230;
      p_10724 = arg34.getSubterm(0);
      q_10724 = arg34.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, a_10725, p_10724, q_10724, o_10724);
      if(term == null)
        break Fail230;
      if(true)
        return term;
    }
    return null;
  }
}