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

@SuppressWarnings("all") final class lifted39 extends Strategy 
{ 
  TermReference x_10722;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail231:
    { 
      IStrategoTerm y_10722 = null;
      IStrategoTerm a_10723 = null;
      IStrategoTerm b_10723 = null;
      a_10723 = term;
      y_10722 = trans.constCritical0;
      b_10723 = a_10723;
      term = log_0_3.instance.invoke(context, b_10723, y_10722, trans.const37, x_10722.value);
      if(term == null)
        break Fail231;
      term = exit_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail231;
      if(true)
        return term;
    }
    return null;
  }
}