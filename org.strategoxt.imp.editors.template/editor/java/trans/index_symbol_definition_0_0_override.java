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
    Fail1842:
    { 
      IStrategoTerm s_32991 = null;
      IStrategoTerm t_32991 = null;
      IStrategoTerm u_32991 = null;
      IStrategoTerm v_32991 = null;
      IStrategoTerm w_32991 = null;
      IStrategoTerm x_32991 = null;
      IStrategoTerm z_32991 = null;
      IStrategoTerm a_32992 = null;
      IStrategoTerm b_32992 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail1842;
      s_32991 = term.getSubterm(0);
      t_32991 = term.getSubterm(1);
      u_32991 = term.getSubterm(2);
      v_32991 = term;
      z_32991 = term;
      w_32991 = trans.const269;
      a_32992 = z_32991;
      term = termFactory.annotateTerm(termFactory.makeTuple(s_32991, t_32991), checkListAnnos(termFactory, trans.constCons84));
      x_32991 = term;
      b_32992 = a_32992;
      term = termFactory.makeTuple(trans.const270, u_32991);
      term = dr_add_rule_0_3.instance.invoke(context, b_32992, w_32991, x_32991, term);
      if(term == null)
        break Fail1842;
      term = v_32991;
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