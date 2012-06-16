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

@SuppressWarnings("all") public class fold_$Declaration_1_0 extends Strategy 
{ 
  public static fold_$Declaration_1_0 instance = new fold_$Declaration_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_10725)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_Declaration_1_0");
    Fail137:
    { 
      IStrategoTerm c_10725 = null;
      IStrategoTerm d_10725 = null;
      IStrategoTerm i_10725 = null;
      IStrategoTerm k_10725 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail137;
      c_10725 = term.getSubterm(0);
      d_10725 = term.getSubterm(1);
      k_10725 = term;
      Success47:
      { 
        Fail138:
        { 
          IStrategoTerm l_10725 = null;
          IStrategoTerm n_10725 = null;
          IStrategoTerm o_10725 = null;
          n_10725 = term;
          l_10725 = trans.const0;
          o_10725 = n_10725;
          term = termFactory.annotateTerm(termFactory.makeTuple(c_10725, d_10725), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_rule_0_2.instance.invoke(context, o_10725, l_10725, term);
          if(term == null)
            break Fail138;
          if(true)
            break Success47;
        }
        term = trans.constNil0;
      }
      i_10725 = term;
      term = k_10725;
      term = termFactory.makeTuple(i_10725, term);
      term = h_10725.invoke(context, term, lifted41.instance);
      if(term == null)
        break Fail137;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}