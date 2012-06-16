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

@SuppressWarnings("all") final class lifted58 extends Strategy 
{ 
  public static final lifted58 instance = new lifted58();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail212:
    { 
      IStrategoTerm c_10734 = null;
      IStrategoTerm l_10734 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail212;
      l_10734 = term.getSubterm(0);
      IStrategoTerm arg44 = term.getSubterm(1);
      c_10734 = arg44;
      term = aux_$Is$Imported_0_2.instance.invoke(context, l_10734, arg44, c_10734);
      if(term == null)
        break Fail212;
      if(true)
        return term;
    }
    return null;
  }
}