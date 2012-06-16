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

@SuppressWarnings("all") public class position_of_term_1_1 extends Strategy 
{ 
  public static position_of_term_1_1 instance = new position_of_term_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_10716, IStrategoTerm u_10715)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("position_of_term_1_1");
    Fail64:
    { 
      IStrategoTerm v_10715 = null;
      IStrategoTerm w_10715 = null;
      IStrategoTerm x_10715 = null;
      IStrategoTerm y_10715 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail64;
      v_10715 = ((IStrategoList)term).head();
      x_10715 = ((IStrategoList)term).tail();
      Success25:
      { 
        Fail65:
        { 
          IStrategoTerm z_10715 = null;
          z_10715 = term;
          term = position_of_term_1_0.instance.invoke(context, v_10715, a_10716);
          if(term == null)
            break Fail65;
          w_10715 = term;
          term = z_10715;
          { 
            IStrategoList list0;
            list0 = checkListTail(w_10715);
            if(list0 == null)
              break Fail64;
            term = (IStrategoTerm)termFactory.makeListCons(u_10715, list0);
            y_10715 = term;
            if(true)
              break Success25;
          }
        }
        IStrategoTerm d_10716 = null;
        d_10716 = x_10715;
        term = inc_0_0.instance.invoke(context, u_10715);
        if(term == null)
          break Fail64;
        term = this.invoke(context, d_10716, a_10716, term);
        if(term == null)
          break Fail64;
        y_10715 = term;
      }
      term = y_10715;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}