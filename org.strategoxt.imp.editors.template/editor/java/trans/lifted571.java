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

@SuppressWarnings("all") final class lifted571 extends Strategy 
{ 
  public static final lifted571 instance = new lifted571();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2076:
    { 
      IStrategoTerm k_33012 = null;
      IStrategoTerm l_33012 = null;
      IStrategoTerm m_33012 = null;
      IStrategoTerm v_33012 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2076;
      v_33012 = term.getSubterm(0);
      IStrategoTerm arg821 = term.getSubterm(1);
      k_33012 = arg821;
      if(arg821.getTermType() != IStrategoTerm.TUPLE || arg821.getSubtermCount() != 2)
        break Fail2076;
      l_33012 = arg821.getSubterm(0);
      m_33012 = arg821.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, v_33012, l_33012, m_33012, k_33012);
      if(term == null)
        break Fail2076;
      if(true)
        return term;
    }
    return null;
  }
}