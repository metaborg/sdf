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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy t_10714, IStrategoTerm m_10714)
  { 
    context.push("desugar_position_1_1");
    Fail59:
    { 
      IStrategoTerm n_10714 = null;
      n_10714 = term;
      term = at_position_1_1.instance.invoke(context, m_10714, lifted13.instance, n_10714);
      if(term == null)
        break Fail59;
      lifted14 lifted140 = new lifted14();
      lifted140.t_10714 = t_10714;
      term = topdown_1_0.instance.invoke(context, term, lifted140);
      if(term == null)
        break Fail59;
      term = position_of_term_1_0.instance.invoke(context, term, lifted17.instance);
      if(term == null)
        break Fail59;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}