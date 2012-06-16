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

@SuppressWarnings("all") public class bigbagof_$Declaration_0_0 extends Strategy 
{ 
  public static bigbagof_$Declaration_0_0 instance = new bigbagof_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigbagof_Declaration_0_0");
    Fail143:
    { 
      TermReference v_10726 = new TermReference();
      TermReference w_10726 = new TermReference();
      TermReference x_10726 = new TermReference();
      if(v_10726.value == null)
        v_10726.value = term;
      else
        if(v_10726.value != term && !v_10726.value.match(term))
          break Fail143;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail143;
      if(w_10726.value == null)
        w_10726.value = term.getSubterm(0);
      else
        if(w_10726.value != term.getSubterm(0) && !w_10726.value.match(term.getSubterm(0)))
          break Fail143;
      if(x_10726.value == null)
        x_10726.value = term.getSubterm(1);
      else
        if(x_10726.value != term.getSubterm(1) && !x_10726.value.match(term.getSubterm(1)))
          break Fail143;
      Success50:
      { 
        Fail144:
        { 
          IStrategoTerm a_10727 = null;
          IStrategoTerm c_10727 = null;
          IStrategoTerm d_10727 = null;
          c_10727 = term;
          a_10727 = trans.const0;
          term = c_10727;
          d_10727 = c_10727;
          if(w_10726.value == null || x_10726.value == null)
            break Fail144;
          term = termFactory.annotateTerm(termFactory.makeTuple(w_10726.value, x_10726.value), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_all_rules_0_2.instance.invoke(context, d_10727, a_10727, term);
          if(term == null)
            break Fail144;
          if(true)
            break Success50;
        }
        term = trans.constNil0;
      }
      lifted44 lifted440 = new lifted44();
      lifted440.w_10726 = w_10726;
      lifted440.x_10726 = x_10726;
      lifted440.v_10726 = v_10726;
      term = filter_1_0.instance.invoke(context, term, lifted440);
      if(term == null)
        break Fail143;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}