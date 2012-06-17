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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy k_33014)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("reverse_bagof_Declaration_1_0");
    Fail1994:
    { 
      TermReference g_33014 = new TermReference();
      TermReference h_33014 = new TermReference();
      TermReference i_33014 = new TermReference();
      if(g_33014.value == null)
        g_33014.value = term;
      else
        if(g_33014.value != term && !g_33014.value.match(term))
          break Fail1994;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1994;
      if(h_33014.value == null)
        h_33014.value = term.getSubterm(0);
      else
        if(h_33014.value != term.getSubterm(0) && !h_33014.value.match(term.getSubterm(0)))
          break Fail1994;
      if(i_33014.value == null)
        i_33014.value = term.getSubterm(1);
      else
        if(i_33014.value != term.getSubterm(1) && !i_33014.value.match(term.getSubterm(1)))
          break Fail1994;
      Success722:
      { 
        Fail1995:
        { 
          IStrategoTerm m_33014 = null;
          IStrategoTerm o_33014 = null;
          IStrategoTerm p_33014 = null;
          o_33014 = term;
          m_33014 = trans.const269;
          term = o_33014;
          p_33014 = o_33014;
          if(h_33014.value == null || i_33014.value == null)
            break Fail1995;
          term = termFactory.annotateTerm(termFactory.makeTuple(h_33014.value, i_33014.value), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_rule_0_2.instance.invoke(context, p_33014, m_33014, term);
          if(term == null)
            break Fail1995;
          if(true)
            break Success722;
        }
        term = trans.constNil4;
      }
      lifted575 lifted5750 = new lifted575();
      lifted5750.h_33014 = h_33014;
      lifted5750.i_33014 = i_33014;
      lifted5750.g_33014 = g_33014;
      term = reverse_filter_2_0.instance.invoke(context, term, lifted5750, k_33014);
      if(term == null)
        break Fail1994;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}