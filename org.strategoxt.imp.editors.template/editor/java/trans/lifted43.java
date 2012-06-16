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

@SuppressWarnings("all") final class lifted43 extends Strategy 
{ 
  public static final lifted43 instance = new lifted43();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail227:
    { 
      IStrategoTerm j_10726 = null;
      IStrategoTerm k_10726 = null;
      IStrategoTerm l_10726 = null;
      IStrategoTerm u_10726 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail227;
      u_10726 = term.getSubterm(0);
      IStrategoTerm arg37 = term.getSubterm(1);
      j_10726 = arg37;
      if(arg37.getTermType() != IStrategoTerm.TUPLE || arg37.getSubtermCount() != 2)
        break Fail227;
      k_10726 = arg37.getSubterm(0);
      l_10726 = arg37.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, u_10726, k_10726, l_10726, j_10726);
      if(term == null)
        break Fail227;
      if(true)
        return term;
    }
    return null;
  }
}