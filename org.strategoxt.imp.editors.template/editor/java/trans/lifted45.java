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

@SuppressWarnings("all") final class lifted45 extends Strategy 
{ 
  TermReference j_10727;

  TermReference f_10727;

  TermReference g_10727;

  TermReference h_10727;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail225:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, j_10727.value, f_10727.value, g_10727.value);
      if(term == null)
        break Fail225;
      if(h_10727.value == null)
        h_10727.value = term;
      else
        if(h_10727.value != term && !h_10727.value.match(term))
          break Fail225;
      if(true)
        return term;
    }
    return null;
  }
}