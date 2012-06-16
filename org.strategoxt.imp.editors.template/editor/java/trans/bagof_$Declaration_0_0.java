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
    Fail148:
    { 
      TermReference a_10728 = new TermReference();
      TermReference b_10728 = new TermReference();
      TermReference c_10728 = new TermReference();
      if(a_10728.value == null)
        a_10728.value = term;
      else
        if(a_10728.value != term && !a_10728.value.match(term))
          break Fail148;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail148;
      if(b_10728.value == null)
        b_10728.value = term.getSubterm(0);
      else
        if(b_10728.value != term.getSubterm(0) && !b_10728.value.match(term.getSubterm(0)))
          break Fail148;
      if(c_10728.value == null)
        c_10728.value = term.getSubterm(1);
      else
        if(c_10728.value != term.getSubterm(1) && !c_10728.value.match(term.getSubterm(1)))
          break Fail148;
      Success52:
      { 
        Fail149:
        { 
          IStrategoTerm f_10728 = null;
          IStrategoTerm h_10728 = null;
          IStrategoTerm i_10728 = null;
          h_10728 = term;
          f_10728 = trans.const0;
          term = h_10728;
          i_10728 = h_10728;
          if(b_10728.value == null || c_10728.value == null)
            break Fail149;
          term = termFactory.annotateTerm(termFactory.makeTuple(b_10728.value, c_10728.value), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_rule_0_2.instance.invoke(context, i_10728, f_10728, term);
          if(term == null)
            break Fail149;
          if(true)
            break Success52;
        }
        term = trans.constNil0;
      }
      lifted47 lifted470 = new lifted47();
      lifted470.b_10728 = b_10728;
      lifted470.c_10728 = c_10728;
      lifted470.a_10728 = a_10728;
      term = filter_1_0.instance.invoke(context, term, lifted470);
      if(term == null)
        break Fail148;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}