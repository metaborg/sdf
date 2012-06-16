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

@SuppressWarnings("all") public class origin_track_forced_1_0 extends Strategy 
{ 
  public static origin_track_forced_1_0 instance = new origin_track_forced_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_10714)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("origin_track_forced_1_0");
    Fail58:
    { 
      IStrategoTerm l_10714 = null;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)trans.constNil0);
      term = SRTS_all.instance.invoke(context, term, i_10714);
      if(term == null)
        break Fail58;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail58;
      l_10714 = ((IStrategoList)term).head();
      IStrategoTerm arg14 = ((IStrategoList)term).tail();
      if(arg14.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg14).isEmpty())
        break Fail58;
      term = l_10714;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}