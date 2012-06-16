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

@SuppressWarnings("all") public class $Declaration_0_0 extends Strategy 
{ 
  public static $Declaration_0_0 instance = new $Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("Declaration_0_0");
    Fail150:
    { 
      TermReference j_10728 = new TermReference();
      TermReference k_10728 = new TermReference();
      TermReference l_10728 = new TermReference();
      IStrategoTerm o_10728 = null;
      IStrategoTerm q_10728 = null;
      IStrategoTerm r_10728 = null;
      if(j_10728.value == null)
        j_10728.value = term;
      else
        if(j_10728.value != term && !j_10728.value.match(term))
          break Fail150;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail150;
      if(k_10728.value == null)
        k_10728.value = term.getSubterm(0);
      else
        if(k_10728.value != term.getSubterm(0) && !k_10728.value.match(term.getSubterm(0)))
          break Fail150;
      if(l_10728.value == null)
        l_10728.value = term.getSubterm(1);
      else
        if(l_10728.value != term.getSubterm(1) && !l_10728.value.match(term.getSubterm(1)))
          break Fail150;
      q_10728 = term;
      o_10728 = trans.const0;
      term = q_10728;
      r_10728 = q_10728;
      if(k_10728.value == null || l_10728.value == null)
        break Fail150;
      term = termFactory.annotateTerm(termFactory.makeTuple(k_10728.value, l_10728.value), checkListAnnos(termFactory, trans.constCons0));
      term = dr_lookup_rule_0_2.instance.invoke(context, r_10728, o_10728, term);
      if(term == null)
        break Fail150;
      lifted48 lifted480 = new lifted48();
      lifted480.k_10728 = k_10728;
      lifted480.l_10728 = l_10728;
      lifted480.j_10728 = j_10728;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted480);
      if(term == null)
        break Fail150;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}