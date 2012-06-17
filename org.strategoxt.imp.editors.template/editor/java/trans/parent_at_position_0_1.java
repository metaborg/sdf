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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm a_33024)
  { 
    context.push("parent_at_position_0_1");
    Fail1908:
    { 
      IStrategoTerm term706 = term;
      Success692:
      { 
        Fail1909:
        { 
          IStrategoTerm c_33002 = null;
          IStrategoTerm d_33002 = null;
          d_33002 = term;
          term = a_33024;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1909;
          c_33002 = ((IStrategoList)term).head();
          IStrategoTerm arg799 = ((IStrategoList)term).tail();
          if(arg799.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg799).isEmpty())
            break Fail1909;
          IStrategoTerm arg801 = ((IStrategoList)arg799).tail();
          if(arg801.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg801).isEmpty())
            break Fail1909;
          term = subterm_at_0_1.instance.invoke(context, d_33002, c_33002);
          if(term == null)
            break Fail1909;
          if(true)
            break Success692;
        }
        term = term706;
        IStrategoTerm w_33001 = null;
        IStrategoTerm x_33001 = null;
        IStrategoTerm y_33001 = null;
        y_33001 = term;
        term = a_33024;
        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
          break Fail1908;
        x_33001 = ((IStrategoList)term).head();
        IStrategoTerm arg802 = ((IStrategoList)term).tail();
        w_33001 = arg802;
        if(arg802.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg802).isEmpty())
          break Fail1908;
        IStrategoTerm arg804 = ((IStrategoList)arg802).tail();
        if(arg804.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg804).isEmpty())
          break Fail1908;
        term = subterm_at_0_1.instance.invoke(context, y_33001, x_33001);
        if(term == null)
          break Fail1908;
        term = this.invoke(context, term, w_33001);
        if(term == null)
          break Fail1908;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}