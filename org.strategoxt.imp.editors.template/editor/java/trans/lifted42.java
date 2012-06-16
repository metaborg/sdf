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

@SuppressWarnings("all") final class lifted42 extends Strategy 
{ 
  public static final lifted42 instance = new lifted42();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail228:
    { 
      IStrategoTerm u_10725 = null;
      IStrategoTerm v_10725 = null;
      IStrategoTerm w_10725 = null;
      IStrategoTerm f_10726 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail228;
      f_10726 = term.getSubterm(0);
      IStrategoTerm arg36 = term.getSubterm(1);
      u_10725 = arg36;
      if(arg36.getTermType() != IStrategoTerm.TUPLE || arg36.getSubtermCount() != 2)
        break Fail228;
      v_10725 = arg36.getSubterm(0);
      w_10725 = arg36.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, f_10726, v_10725, w_10725, u_10725);
      if(term == null)
        break Fail228;
      if(true)
        return term;
    }
    return null;
  }
}