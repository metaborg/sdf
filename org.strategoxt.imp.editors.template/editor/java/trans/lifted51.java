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

@SuppressWarnings("all") final class lifted51 extends Strategy 
{ 
  public static final lifted51 instance = new lifted51();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail219:
    { 
      IStrategoTerm b_10731 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail219;
      b_10731 = term.getSubterm(0);
      IStrategoTerm arg41 = term.getSubterm(1);
      term = aux_$Current$File_0_1.instance.invoke(context, b_10731, arg41);
      if(term == null)
        break Fail219;
      if(true)
        return term;
    }
    return null;
  }
}