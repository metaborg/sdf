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

@SuppressWarnings("all") final class lifted577 extends Strategy 
{ 
  TermReference a_33015;

  TermReference b_33015;

  TermReference z_33014;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2070:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, a_33015.value, b_33015.value, z_33014.value);
      if(term == null)
        break Fail2070;
      if(true)
        return term;
    }
    return null;
  }
}