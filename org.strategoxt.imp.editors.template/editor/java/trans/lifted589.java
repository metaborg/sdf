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

@SuppressWarnings("all") final class lifted589 extends Strategy 
{ 
  public static final lifted589 instance = new lifted589();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2058:
    { 
      IStrategoTerm q_33021 = null;
      IStrategoTerm y_33021 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2058;
      y_33021 = term.getSubterm(0);
      IStrategoTerm arg831 = term.getSubterm(1);
      q_33021 = arg831;
      term = aux_$Is$Imported_0_2.instance.invoke(context, y_33021, arg831, q_33021);
      if(term == null)
        break Fail2058;
      if(true)
        return term;
    }
    return null;
  }
}