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

@SuppressWarnings("all") final class lifted587 extends Strategy 
{ 
  public static final lifted587 instance = new lifted587();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2060:
    { 
      IStrategoTerm s_33020 = null;
      IStrategoTerm b_33021 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2060;
      b_33021 = term.getSubterm(0);
      IStrategoTerm arg829 = term.getSubterm(1);
      s_33020 = arg829;
      term = aux_$Is$Imported_0_2.instance.invoke(context, b_33021, arg829, s_33020);
      if(term == null)
        break Fail2060;
      if(true)
        return term;
    }
    return null;
  }
}