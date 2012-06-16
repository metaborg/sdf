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

@SuppressWarnings("all") final class lifted48 extends Strategy 
{ 
  TermReference k_10728;

  TermReference l_10728;

  TermReference j_10728;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail222:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, k_10728.value, l_10728.value, j_10728.value);
      if(term == null)
        break Fail222;
      if(true)
        return term;
    }
    return null;
  }
}