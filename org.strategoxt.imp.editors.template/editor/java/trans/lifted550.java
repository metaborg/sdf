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

@SuppressWarnings("all") final class lifted550 extends Strategy 
{ 
  TermReference t_33001;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2090:
    { 
      if(t_33001.value == null)
        t_33001.value = term;
      else
        if(t_33001.value != term && !t_33001.value.match(term))
          break Fail2090;
      if(true)
        return term;
    }
    return null;
  }
}