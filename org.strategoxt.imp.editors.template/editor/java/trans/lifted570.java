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

@SuppressWarnings("all") final class lifted570 extends Strategy 
{ 
  public static final lifted570 instance = new lifted570();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2077:
    { 
      IStrategoTerm u_33011 = null;
      IStrategoTerm v_33011 = null;
      IStrategoTerm w_33011 = null;
      IStrategoTerm g_33012 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2077;
      g_33012 = term.getSubterm(0);
      IStrategoTerm arg820 = term.getSubterm(1);
      u_33011 = arg820;
      if(arg820.getTermType() != IStrategoTerm.TUPLE || arg820.getSubtermCount() != 2)
        break Fail2077;
      v_33011 = arg820.getSubterm(0);
      w_33011 = arg820.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, g_33012, v_33011, w_33011, u_33011);
      if(term == null)
        break Fail2077;
      if(true)
        return term;
    }
    return null;
  }
}