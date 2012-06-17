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

@SuppressWarnings("all") final class lifted592 extends Strategy 
{ 
  TermReference r_33022;

  TermReference s_33022;

  TermReference t_33022;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2055:
    { 
      term = aux_$Is$Imported_0_2.instance.invoke(context, term, r_33022.value, s_33022.value);
      if(term == null)
        break Fail2055;
      if(t_33022.value == null)
        t_33022.value = term;
      else
        if(t_33022.value != term && !t_33022.value.match(term))
          break Fail2055;
      if(true)
        return term;
    }
    return null;
  }
}