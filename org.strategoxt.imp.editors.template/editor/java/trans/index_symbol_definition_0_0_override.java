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

@SuppressWarnings("all") final class index_symbol_definition_0_0_override extends index_symbol_definition_0_0 
{ 
  private static final index_symbol_definition_0_0 proceed = new index_symbol_definition_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("index_symbol_definition_0_0");
    Fail2:
    { 
      IStrategoTerm f_10706 = null;
      IStrategoTerm g_10706 = null;
      IStrategoTerm h_10706 = null;
      IStrategoTerm i_10706 = null;
      IStrategoTerm j_10706 = null;
      IStrategoTerm k_10706 = null;
      IStrategoTerm m_10706 = null;
      IStrategoTerm n_10706 = null;
      IStrategoTerm o_10706 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail2;
      f_10706 = term.getSubterm(0);
      g_10706 = term.getSubterm(1);
      h_10706 = term.getSubterm(2);
      i_10706 = term;
      m_10706 = term;
      j_10706 = trans.const0;
      n_10706 = m_10706;
      term = termFactory.annotateTerm(termFactory.makeTuple(f_10706, g_10706), checkListAnnos(termFactory, trans.constCons0));
      k_10706 = term;
      o_10706 = n_10706;
      term = termFactory.makeTuple(trans.const1, h_10706);
      term = dr_add_rule_0_3.instance.invoke(context, o_10706, j_10706, k_10706, term);
      if(term == null)
        break Fail2;
      term = i_10706;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }

  @Override public String getName()
  { 
    return "index_symbol_definition_0_0";
  }
}