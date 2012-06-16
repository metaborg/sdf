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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_10737, IStrategoTerm i_10737)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("at_position_1_1");
    Fail60:
    { 
      IStrategoTerm term37 = term;
      Success23:
      { 
        Fail61:
        { 
          IStrategoTerm d_10715 = null;
          TermReference e_10715 = new TermReference();
          IStrategoTerm f_10715 = null;
          IStrategoTerm g_10715 = null;
          IStrategoTerm j_10715 = null;
          IStrategoTerm l_10715 = null;
          IStrategoTerm m_10715 = null;
          IStrategoTerm cons0 = context.invokePrimitive("SSL_get_constructor", term, NO_STRATEGIES, new IStrategoTerm[]{term});
          d_10715 = cons0;
          IStrategoTerm args0 = context.invokePrimitive("SSL_get_arguments", term, NO_STRATEGIES, new IStrategoTerm[]{term});
          g_10715 = args0;
          j_10715 = term;
          term = i_10737;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail61;
          f_10715 = ((IStrategoList)term).head();
          if(e_10715.value == null)
            e_10715.value = ((IStrategoList)term).tail();
          else
            if(e_10715.value != ((IStrategoList)term).tail() && !e_10715.value.match(((IStrategoList)term).tail()))
              break Fail61;
          term = j_10715;
          m_10715 = term;
          term = termFactory.makeTuple(f_10715, g_10715);
          lifted19 lifted190 = new lifted19();
          lifted190.h_10737 = h_10737;
          lifted190.e_10715 = e_10715;
          term = at_index_1_0.instance.invoke(context, term, lifted190);
          if(term == null)
            break Fail61;
          l_10715 = term;
          term = m_10715;
          IStrategoTerm mkterm0;
          mkterm0 = context.invokePrimitive("SSL_mkterm", term, NO_STRATEGIES, new IStrategoTerm[]{d_10715, l_10715});
          if(mkterm0 == null)
            break Fail61;
          term = mkterm0;
          if(true)
            break Success23;
        }
        term = term37;
        IStrategoTerm y_10714 = null;
        y_10714 = term;
        term = i_10737;
        if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
          break Fail60;
        term = h_10737.invoke(context, y_10714);
        if(term == null)
          break Fail60;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}