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

@SuppressWarnings("all") public class set_markers_0_1 extends Strategy 
{ 
  public static set_markers_0_1 instance = new set_markers_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm k_33002)
  { 
    Fail1911:
    { 
      term = context.invokePrimitive("SSL_EXT_set_markers", term, NO_STRATEGIES, new IStrategoTerm[]{k_33002});
      if(term == null)
        break Fail1911;
      if(true)
        return term;
    }
    context.push("set_markers_0_1");
    context.popOnFailure();
    return null;
  }
}