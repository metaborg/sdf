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

@SuppressWarnings("all") final class lifted61 extends Strategy 
{ 
  public static final lifted61 instance = new lifted61();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail209:
    { 
      IStrategoTerm l_10735 = null;
      IStrategoTerm t_10735 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail209;
      t_10735 = term.getSubterm(0);
      IStrategoTerm arg47 = term.getSubterm(1);
      l_10735 = arg47;
      term = aux_$Is$Imported_0_2.instance.invoke(context, t_10735, arg47, l_10735);
      if(term == null)
        break Fail209;
      if(true)
        return term;
    }
    return null;
  }
}