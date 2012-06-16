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

@SuppressWarnings("all") public class term_at_position_0_1 extends Strategy 
{ 
  public static term_at_position_0_1 instance = new term_at_position_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm e_10716)
  { 
    context.push("term_at_position_0_1");
    Fail66:
    { 
      TermReference g_10716 = new TermReference();
      IStrategoTerm h_10716 = null;
      h_10716 = term;
      lifted20 lifted200 = new lifted20();
      lifted200.g_10716 = g_10716;
      term = at_position_1_1.instance.invoke(context, term, lifted200, e_10716);
      if(term == null)
        break Fail66;
      term = h_10716;
      if(g_10716.value == null)
        break Fail66;
      term = g_10716.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}