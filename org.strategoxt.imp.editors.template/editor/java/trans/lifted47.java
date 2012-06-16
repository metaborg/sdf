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

@SuppressWarnings("all") final class lifted47 extends Strategy 
{ 
  TermReference b_10728;

  TermReference c_10728;

  TermReference a_10728;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail223:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, b_10728.value, c_10728.value, a_10728.value);
      if(term == null)
        break Fail223;
      if(true)
        return term;
    }
    return null;
  }
}