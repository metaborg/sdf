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

@SuppressWarnings("all") public class bigchain_$Declaration_0_0 extends Strategy 
{ 
  public static bigchain_$Declaration_0_0 instance = new bigchain_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_Declaration_0_0");
    Fail1987:
    { 
      IStrategoTerm i_33012 = null;
      IStrategoTerm j_33012 = null;
      IStrategoTerm n_33012 = null;
      IStrategoTerm p_33012 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1987;
      i_33012 = term.getSubterm(0);
      j_33012 = term.getSubterm(1);
      p_33012 = term;
      Success719:
      { 
        Fail1988:
        { 
          IStrategoTerm q_33012 = null;
          IStrategoTerm s_33012 = null;
          IStrategoTerm t_33012 = null;
          s_33012 = term;
          q_33012 = trans.const269;
          t_33012 = s_33012;
          term = termFactory.annotateTerm(termFactory.makeTuple(i_33012, j_33012), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_all_rules_0_2.instance.invoke(context, t_33012, q_33012, term);
          if(term == null)
            break Fail1988;
          if(true)
            break Success719;
        }
        term = trans.constNil4;
      }
      n_33012 = term;
      term = p_33012;
      term = termFactory.makeTuple(n_33012, term);
      term = foldl_1_0.instance.invoke(context, term, lifted571.instance);
      if(term == null)
        break Fail1987;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}