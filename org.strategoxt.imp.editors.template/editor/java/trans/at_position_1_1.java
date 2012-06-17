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

@SuppressWarnings("all") public class at_position_1_1 extends Strategy 
{ 
  public static at_position_1_1 instance = new at_position_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_33023, IStrategoTerm y_33023)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("at_position_1_1");
    Fail1901:
    { 
      IStrategoTerm term703 = term;
      Success689:
      { 
        Fail1902:
        { 
          IStrategoTerm q_33000 = null;
          TermReference r_33000 = new TermReference();
          IStrategoTerm s_33000 = null;
          IStrategoTerm t_33000 = null;
          IStrategoTerm w_33000 = null;
          IStrategoTerm y_33000 = null;
          IStrategoTerm z_33000 = null;
          IStrategoTerm cons69 = context.invokePrimitive("SSL_get_constructor", term, NO_STRATEGIES, new IStrategoTerm[]{term});
          q_33000 = cons69;
          IStrategoTerm args9 = context.invokePrimitive("SSL_get_arguments", term, NO_STRATEGIES, new IStrategoTerm[]{term});
          t_33000 = args9;
          w_33000 = term;
          term = y_33023;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1902;
          s_33000 = ((IStrategoList)term).head();
          if(r_33000.value == null)
            r_33000.value = ((IStrategoList)term).tail();
          else
            if(r_33000.value != ((IStrategoList)term).tail() && !r_33000.value.match(((IStrategoList)term).tail()))
              break Fail1902;
          term = w_33000;
          z_33000 = term;
          term = termFactory.makeTuple(s_33000, t_33000);
          lifted549 lifted5490 = new lifted549();
          lifted5490.x_33023 = x_33023;
          lifted5490.r_33000 = r_33000;
          term = at_index_1_0.instance.invoke(context, term, lifted5490);
          if(term == null)
            break Fail1902;
          y_33000 = term;
          term = z_33000;
          IStrategoTerm mkterm3;
          mkterm3 = context.invokePrimitive("SSL_mkterm", term, NO_STRATEGIES, new IStrategoTerm[]{q_33000, y_33000});
          if(mkterm3 == null)
            break Fail1902;
          term = mkterm3;
          if(true)
            break Success689;
        }
        term = term703;
        IStrategoTerm l_33000 = null;
        l_33000 = term;
        term = y_33023;
        if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
          break Fail1901;
        term = x_33023.invoke(context, l_33000);
        if(term == null)
          break Fail1901;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}