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

@SuppressWarnings("all") final class lifted59 extends Strategy 
{ 
  public static final lifted59 instance = new lifted59();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail211:
    { 
      IStrategoTerm o_10734 = null;
      IStrategoTerm x_10734 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail211;
      x_10734 = term.getSubterm(0);
      IStrategoTerm arg45 = term.getSubterm(1);
      o_10734 = arg45;
      term = aux_$Is$Imported_0_2.instance.invoke(context, x_10734, arg45, o_10734);
      if(term == null)
        break Fail211;
      if(true)
        return term;
    }
    return null;
  }
}