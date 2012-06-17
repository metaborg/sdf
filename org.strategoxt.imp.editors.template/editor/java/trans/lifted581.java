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

@SuppressWarnings("all") final class lifted581 extends Strategy 
{ 
  public static final lifted581 instance = new lifted581();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2066:
    { 
      IStrategoTerm c_33018 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail2066;
      c_33018 = term.getSubterm(0);
      IStrategoTerm arg827 = term.getSubterm(1);
      term = aux_$Current$File_0_1.instance.invoke(context, c_33018, arg827);
      if(term == null)
        break Fail2066;
      if(true)
        return term;
    }
    return null;
  }
}