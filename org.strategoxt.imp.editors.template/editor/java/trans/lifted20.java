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

@SuppressWarnings("all") final class lifted20 extends Strategy 
{ 
  TermReference g_10716;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail242:
    { 
      if(g_10716.value == null)
        g_10716.value = term;
      else
        if(g_10716.value != term && !g_10716.value.match(term))
          break Fail242;
      if(true)
        return term;
    }
    return null;
  }
}