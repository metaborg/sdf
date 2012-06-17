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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_33001, IStrategoTerm h_33001)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("position_of_term_1_1");
    Fail1905:
    { 
      IStrategoTerm i_33001 = null;
      IStrategoTerm j_33001 = null;
      IStrategoTerm k_33001 = null;
      IStrategoTerm l_33001 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1905;
      i_33001 = ((IStrategoList)term).head();
      k_33001 = ((IStrategoList)term).tail();
      Success691:
      { 
        Fail1906:
        { 
          IStrategoTerm m_33001 = null;
          m_33001 = term;
          term = position_of_term_1_0.instance.invoke(context, i_33001, n_33001);
          if(term == null)
            break Fail1906;
          j_33001 = term;
          term = m_33001;
          { 
            IStrategoList list48;
            list48 = checkListTail(j_33001);
            if(list48 == null)
              break Fail1905;
            term = (IStrategoTerm)termFactory.makeListCons(h_33001, list48);
            l_33001 = term;
            if(true)
              break Success691;
          }
        }
        IStrategoTerm q_33001 = null;
        q_33001 = k_33001;
        term = inc_0_0.instance.invoke(context, h_33001);
        if(term == null)
          break Fail1905;
        term = this.invoke(context, q_33001, n_33001, term);
        if(term == null)
          break Fail1905;
        l_33001 = term;
      }
      term = l_33001;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}