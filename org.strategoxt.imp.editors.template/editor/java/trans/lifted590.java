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

@SuppressWarnings("all") final class lifted590 extends Strategy 
{ 
  public static final lifted590 instance = new lifted590();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2057:
    { 
      IStrategoTerm b_33022 = null;
      IStrategoTerm j_33022 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2057;
      j_33022 = term.getSubterm(0);
      IStrategoTerm arg832 = term.getSubterm(1);
      b_33022 = arg832;
      term = aux_$Is$Imported_0_2.instance.invoke(context, j_33022, arg832, b_33022);
      if(term == null)
        break Fail2057;
      if(true)
        return term;
    }
    return null;
  }
}