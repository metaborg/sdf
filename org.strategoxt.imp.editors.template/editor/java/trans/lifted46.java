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

@SuppressWarnings("all") final class lifted46 extends Strategy 
{ 
  TermReference r_10727;

  TermReference s_10727;

  TermReference q_10727;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail224:
    { 
      term = aux_$Declaration_0_3.instance.invoke(context, term, r_10727.value, s_10727.value, q_10727.value);
      if(term == null)
        break Fail224;
      if(true)
        return term;
    }
    return null;
  }
}