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

@SuppressWarnings("all") public class desugar_position_1_1 extends Strategy 
{ 
  public static desugar_position_1_1 instance = new desugar_position_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_33000, IStrategoTerm z_32999)
  { 
    context.push("desugar_position_1_1");
    Fail1900:
    { 
      IStrategoTerm a_33000 = null;
      a_33000 = term;
      term = at_position_1_1.instance.invoke(context, z_32999, lifted543.instance, a_33000);
      if(term == null)
        break Fail1900;
      lifted544 lifted5440 = new lifted544();
      lifted5440.g_33000 = g_33000;
      term = topdown_1_0.instance.invoke(context, term, lifted5440);
      if(term == null)
        break Fail1900;
      term = position_of_term_1_0.instance.invoke(context, term, lifted547.instance);
      if(term == null)
        break Fail1900;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}