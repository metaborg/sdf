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

@SuppressWarnings("all") public class bagof_$Declaration_0_0 extends Strategy 
{ 
  public static bagof_$Declaration_0_0 instance = new bagof_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bagof_Declaration_0_0");
    Fail1996:
    { 
      TermReference q_33014 = new TermReference();
      TermReference r_33014 = new TermReference();
      TermReference s_33014 = new TermReference();
      if(q_33014.value == null)
        q_33014.value = term;
      else
        if(q_33014.value != term && !q_33014.value.match(term))
          break Fail1996;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1996;
      if(r_33014.value == null)
        r_33014.value = term.getSubterm(0);
      else
        if(r_33014.value != term.getSubterm(0) && !r_33014.value.match(term.getSubterm(0)))
          break Fail1996;
      if(s_33014.value == null)
        s_33014.value = term.getSubterm(1);
      else
        if(s_33014.value != term.getSubterm(1) && !s_33014.value.match(term.getSubterm(1)))
          break Fail1996;
      Success723:
      { 
        Fail1997:
        { 
          IStrategoTerm v_33014 = null;
          IStrategoTerm x_33014 = null;
          IStrategoTerm y_33014 = null;
          x_33014 = term;
          v_33014 = trans.const269;
          term = x_33014;
          y_33014 = x_33014;
          if(r_33014.value == null || s_33014.value == null)
            break Fail1997;
          term = termFactory.annotateTerm(termFactory.makeTuple(r_33014.value, s_33014.value), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_rule_0_2.instance.invoke(context, y_33014, v_33014, term);
          if(term == null)
            break Fail1997;
          if(true)
            break Success723;
        }
        term = trans.constNil4;
      }
      lifted576 lifted5760 = new lifted576();
      lifted5760.r_33014 = r_33014;
      lifted5760.s_33014 = s_33014;
      lifted5760.q_33014 = q_33014;
      term = filter_1_0.instance.invoke(context, term, lifted5760);
      if(term == null)
        break Fail1996;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}