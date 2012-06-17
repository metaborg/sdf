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

@SuppressWarnings("all") final class lifted573 extends Strategy 
{ 
  TermReference m_33013;

  TermReference n_33013;

  TermReference l_33013;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2074:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, m_33013.value, n_33013.value, l_33013.value);
      if(term == null)
        break Fail2074;
      if(true)
        return term;
    }
    return null;
  }
}