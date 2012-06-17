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

@SuppressWarnings("all") final class lifted574 extends Strategy 
{ 
  TermReference z_33013;

  TermReference v_33013;

  TermReference w_33013;

  TermReference x_33013;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2073:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, z_33013.value, v_33013.value, w_33013.value);
      if(term == null)
        break Fail2073;
      if(x_33013.value == null)
        x_33013.value = term;
      else
        if(x_33013.value != term && !x_33013.value.match(term))
          break Fail2073;
      if(true)
        return term;
    }
    return null;
  }
}