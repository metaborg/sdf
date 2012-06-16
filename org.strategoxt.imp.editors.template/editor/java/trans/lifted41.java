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

@SuppressWarnings("all") final class lifted41 extends Strategy 
{ 
  public static final lifted41 instance = new lifted41();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail229:
    { 
      IStrategoTerm e_10725 = null;
      IStrategoTerm f_10725 = null;
      IStrategoTerm g_10725 = null;
      IStrategoTerm q_10725 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail229;
      q_10725 = term.getSubterm(0);
      IStrategoTerm arg35 = term.getSubterm(1);
      e_10725 = arg35;
      if(arg35.getTermType() != IStrategoTerm.TUPLE || arg35.getSubtermCount() != 2)
        break Fail229;
      f_10725 = arg35.getSubterm(0);
      g_10725 = arg35.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, q_10725, f_10725, g_10725, e_10725);
      if(term == null)
        break Fail229;
      if(true)
        return term;
    }
    return null;
  }
}