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

@SuppressWarnings("all") public class bigfold_$Declaration_1_0 extends Strategy 
{ 
  public static bigfold_$Declaration_1_0 instance = new bigfold_$Declaration_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy r_10724)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_Declaration_1_0");
    Fail135:
    { 
      IStrategoTerm m_10724 = null;
      IStrategoTerm n_10724 = null;
      IStrategoTerm s_10724 = null;
      IStrategoTerm u_10724 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail135;
      m_10724 = term.getSubterm(0);
      n_10724 = term.getSubterm(1);
      u_10724 = term;
      Success46:
      { 
        Fail136:
        { 
          IStrategoTerm v_10724 = null;
          IStrategoTerm x_10724 = null;
          IStrategoTerm y_10724 = null;
          x_10724 = term;
          v_10724 = trans.const0;
          y_10724 = x_10724;
          term = termFactory.annotateTerm(termFactory.makeTuple(m_10724, n_10724), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_all_rules_0_2.instance.invoke(context, y_10724, v_10724, term);
          if(term == null)
            break Fail136;
          if(true)
            break Success46;
        }
        term = trans.constNil0;
      }
      s_10724 = term;
      term = u_10724;
      term = termFactory.makeTuple(s_10724, term);
      term = r_10724.invoke(context, term, lifted40.instance);
      if(term == null)
        break Fail135;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}