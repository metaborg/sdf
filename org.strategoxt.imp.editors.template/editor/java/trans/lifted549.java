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

@SuppressWarnings("all") final class lifted549 extends Strategy 
{ 
  TermReference r_33000;

  Strategy x_33023;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2091:
    { 
      term = at_position_1_1.instance.invoke(context, term, x_33023, r_33000.value);
      if(term == null)
        break Fail2091;
      if(true)
        return term;
    }
    return null;
  }
}