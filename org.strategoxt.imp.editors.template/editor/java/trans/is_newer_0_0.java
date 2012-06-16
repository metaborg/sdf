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

@SuppressWarnings("all") public class is_newer_0_0 extends Strategy 
{ 
  public static is_newer_0_0 instance = new is_newer_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("is_newer_0_0");
    Fail41:
    { 
      IStrategoTerm g_10712 = null;
      IStrategoTerm h_10712 = null;
      IStrategoTerm i_10712 = null;
      IStrategoTerm j_10712 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail41;
      g_10712 = term.getSubterm(0);
      h_10712 = term.getSubterm(1);
      i_10712 = term;
      term = file_exists_0_0.instance.invoke(context, g_10712);
      if(term == null)
        break Fail41;
      term = modification_time_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail41;
      j_10712 = term;
      term = file_exists_0_0.instance.invoke(context, h_10712);
      if(term == null)
        break Fail41;
      term = modification_time_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail41;
      term = termFactory.makeTuple(j_10712, term);
      term = gt_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail41;
      term = i_10712;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}