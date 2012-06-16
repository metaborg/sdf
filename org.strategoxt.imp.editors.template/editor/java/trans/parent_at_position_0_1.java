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

@SuppressWarnings("all") public class parent_at_position_0_1 extends Strategy 
{ 
  public static parent_at_position_0_1 instance = new parent_at_position_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm k_10737)
  { 
    context.push("parent_at_position_0_1");
    Fail67:
    { 
      IStrategoTerm term40 = term;
      Success26:
      { 
        Fail68:
        { 
          IStrategoTerm p_10716 = null;
          IStrategoTerm q_10716 = null;
          q_10716 = term;
          term = k_10737;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail68;
          p_10716 = ((IStrategoList)term).head();
          IStrategoTerm arg15 = ((IStrategoList)term).tail();
          if(arg15.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg15).isEmpty())
            break Fail68;
          IStrategoTerm arg17 = ((IStrategoList)arg15).tail();
          if(arg17.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg17).isEmpty())
            break Fail68;
          term = subterm_at_0_1.instance.invoke(context, q_10716, p_10716);
          if(term == null)
            break Fail68;
          if(true)
            break Success26;
        }
        term = term40;
        IStrategoTerm j_10716 = null;
        IStrategoTerm k_10716 = null;
        IStrategoTerm l_10716 = null;
        l_10716 = term;
        term = k_10737;
        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
          break Fail67;
        k_10716 = ((IStrategoList)term).head();
        IStrategoTerm arg18 = ((IStrategoList)term).tail();
        j_10716 = arg18;
        if(arg18.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg18).isEmpty())
          break Fail67;
        IStrategoTerm arg20 = ((IStrategoList)arg18).tail();
        if(arg20.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg20).isEmpty())
          break Fail67;
        term = subterm_at_0_1.instance.invoke(context, l_10716, k_10716);
        if(term == null)
          break Fail67;
        term = this.invoke(context, term, j_10716);
        if(term == null)
          break Fail67;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}