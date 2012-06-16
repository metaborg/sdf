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

@SuppressWarnings("all") public class reverse_bagof_$Declaration_1_0 extends Strategy 
{ 
  public static reverse_bagof_$Declaration_1_0 instance = new reverse_bagof_$Declaration_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_10727)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("reverse_bagof_Declaration_1_0");
    Fail146:
    { 
      TermReference q_10727 = new TermReference();
      TermReference r_10727 = new TermReference();
      TermReference s_10727 = new TermReference();
      if(q_10727.value == null)
        q_10727.value = term;
      else
        if(q_10727.value != term && !q_10727.value.match(term))
          break Fail146;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail146;
      if(r_10727.value == null)
        r_10727.value = term.getSubterm(0);
      else
        if(r_10727.value != term.getSubterm(0) && !r_10727.value.match(term.getSubterm(0)))
          break Fail146;
      if(s_10727.value == null)
        s_10727.value = term.getSubterm(1);
      else
        if(s_10727.value != term.getSubterm(1) && !s_10727.value.match(term.getSubterm(1)))
          break Fail146;
      Success51:
      { 
        Fail147:
        { 
          IStrategoTerm w_10727 = null;
          IStrategoTerm y_10727 = null;
          IStrategoTerm z_10727 = null;
          y_10727 = term;
          w_10727 = trans.const0;
          term = y_10727;
          z_10727 = y_10727;
          if(r_10727.value == null || s_10727.value == null)
            break Fail147;
          term = termFactory.annotateTerm(termFactory.makeTuple(r_10727.value, s_10727.value), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_rule_0_2.instance.invoke(context, z_10727, w_10727, term);
          if(term == null)
            break Fail147;
          if(true)
            break Success51;
        }
        term = trans.constNil0;
      }
      lifted46 lifted460 = new lifted46();
      lifted460.r_10727 = r_10727;
      lifted460.s_10727 = s_10727;
      lifted460.q_10727 = q_10727;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted460, u_10727);
      if(term == null)
        break Fail146;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}