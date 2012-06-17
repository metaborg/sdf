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
    Fail1882:
    { 
      IStrategoTerm t_32997 = null;
      IStrategoTerm u_32997 = null;
      IStrategoTerm v_32997 = null;
      IStrategoTerm w_32997 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1882;
      t_32997 = term.getSubterm(0);
      u_32997 = term.getSubterm(1);
      v_32997 = term;
      term = file_exists_0_0.instance.invoke(context, t_32997);
      if(term == null)
        break Fail1882;
      term = modification_time_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1882;
      w_32997 = term;
      term = file_exists_0_0.instance.invoke(context, u_32997);
      if(term == null)
        break Fail1882;
      term = modification_time_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1882;
      term = termFactory.makeTuple(w_32997, term);
      term = gt_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1882;
      term = v_32997;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}