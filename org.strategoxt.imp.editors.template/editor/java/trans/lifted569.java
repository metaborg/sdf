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

@SuppressWarnings("all") final class lifted569 extends Strategy 
{ 
  public static final lifted569 instance = new lifted569();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2078:
    { 
      IStrategoTerm e_33011 = null;
      IStrategoTerm f_33011 = null;
      IStrategoTerm g_33011 = null;
      IStrategoTerm q_33011 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2078;
      q_33011 = term.getSubterm(0);
      IStrategoTerm arg819 = term.getSubterm(1);
      e_33011 = arg819;
      if(arg819.getTermType() != IStrategoTerm.TUPLE || arg819.getSubtermCount() != 2)
        break Fail2078;
      f_33011 = arg819.getSubterm(0);
      g_33011 = arg819.getSubterm(1);
      term = aux_$Declaration_0_3.instance.invoke(context, q_33011, f_33011, g_33011, e_33011);
      if(term == null)
        break Fail2078;
      if(true)
        return term;
    }
    return null;
  }
}