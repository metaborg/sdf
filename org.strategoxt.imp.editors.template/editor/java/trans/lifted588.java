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

@SuppressWarnings("all") final class lifted588 extends Strategy 
{ 
  public static final lifted588 instance = new lifted588();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2059:
    { 
      IStrategoTerm e_33021 = null;
      IStrategoTerm n_33021 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2059;
      n_33021 = term.getSubterm(0);
      IStrategoTerm arg830 = term.getSubterm(1);
      e_33021 = arg830;
      term = aux_$Is$Imported_0_2.instance.invoke(context, n_33021, arg830, e_33021);
      if(term == null)
        break Fail2059;
      if(true)
        return term;
    }
    return null;
  }
}