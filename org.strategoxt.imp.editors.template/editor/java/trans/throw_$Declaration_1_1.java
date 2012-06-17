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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_33010, IStrategoTerm j_33010)
  { 
    context.push("throw_Declaration_1_1");
    Fail1976:
    { 
      IStrategoTerm m_33010 = null;
      m_33010 = term;
      term = dr_throw_1_2.instance.invoke(context, m_33010, k_33010, j_33010, trans.const269);
      if(term == null)
        break Fail1976;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}