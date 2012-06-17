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

@SuppressWarnings("all") final class lifted538 extends Strategy 
{ 
  TermReference f_32994;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2115:
    { 
      if(f_32994.value == null)
        f_32994.value = term;
      else
        if(f_32994.value != term && !f_32994.value.match(term))
          break Fail2115;
      if(true)
        return term;
    }
    return null;
  }
}