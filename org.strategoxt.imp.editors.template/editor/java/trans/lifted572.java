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

@SuppressWarnings("all") final class lifted572 extends Strategy 
{ 
  public static final lifted572 instance = new lifted572();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2075:
    { 
      IStrategoTerm z_33012 = null;
      IStrategoTerm a_33013 = null;
      IStrategoTerm b_33013 = null;
      IStrategoTerm k_33013 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2075;
      k_33013 = term.getSubterm(0);
      IStrategoTerm arg822 = term.getSubterm(1);
      z_33012 = arg822;
      if(arg822.getTermType() != IStrategoTerm.TUPLE || arg822.getSubtermCount() != 2)
        break Fail2075;
      a_33013 = arg822.getSubterm(0);
      b_33013 = arg822.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, k_33013, a_33013, b_33013, z_33012);
      if(term == null)
        break Fail2075;
      if(true)
        return term;
    }
    return null;
  }
}