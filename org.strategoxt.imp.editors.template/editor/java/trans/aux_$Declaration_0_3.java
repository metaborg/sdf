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

@SuppressWarnings("all") public class aux_$Declaration_0_3 extends Strategy 
{ 
  public static aux_$Declaration_0_3 instance = new aux_$Declaration_0_3();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm s_10728, IStrategoTerm t_10728, IStrategoTerm u_10728)
  { 
    Fail151:
    { 
      IStrategoTerm v_10728 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail151;
      IStrategoTerm arg38 = term.getSubterm(0);
      if(arg38.getTermType() != IStrategoTerm.STRING || !"-220620".equals(((IStrategoString)arg38).stringValue()))
        break Fail151;
      v_10728 = term.getSubterm(1);
      term = v_10728;
      if(true)
        return term;
    }
    context.push("aux_Declaration_0_3");
    context.popOnFailure();
    return null;
  }
}