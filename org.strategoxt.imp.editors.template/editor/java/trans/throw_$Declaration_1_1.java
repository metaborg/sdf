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

@SuppressWarnings("all") public class throw_$Declaration_1_1 extends Strategy 
{ 
  public static throw_$Declaration_1_1 instance = new throw_$Declaration_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_10723, IStrategoTerm t_10723)
  { 
    context.push("throw_Declaration_1_1");
    Fail128:
    { 
      IStrategoTerm w_10723 = null;
      w_10723 = term;
      term = dr_throw_1_2.instance.invoke(context, w_10723, u_10723, t_10723, trans.const0);
      if(term == null)
        break Fail128;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}