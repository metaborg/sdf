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

@SuppressWarnings("all") final class lifted580 extends Strategy 
{ 
  public static final lifted580 instance = new lifted580();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2067:
    { 
      IStrategoTerm r_33017 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2067;
      r_33017 = term.getSubterm(0);
      IStrategoTerm arg826 = term.getSubterm(1);
      term = aux_$Current$File_0_1.instance.invoke(context, r_33017, arg826);
      if(term == null)
        break Fail2067;
      if(true)
        return term;
    }
    return null;
  }
}