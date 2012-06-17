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
    Fail1998:
    { 
      TermReference z_33014 = new TermReference();
      TermReference a_33015 = new TermReference();
      TermReference b_33015 = new TermReference();
      IStrategoTerm e_33015 = null;
      IStrategoTerm g_33015 = null;
      IStrategoTerm h_33015 = null;
      if(z_33014.value == null)
        z_33014.value = term;
      else
        if(z_33014.value != term && !z_33014.value.match(term))
          break Fail1998;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1998;
      if(a_33015.value == null)
        a_33015.value = term.getSubterm(0);
      else
        if(a_33015.value != term.getSubterm(0) && !a_33015.value.match(term.getSubterm(0)))
          break Fail1998;
      if(b_33015.value == null)
        b_33015.value = term.getSubterm(1);
      else
        if(b_33015.value != term.getSubterm(1) && !b_33015.value.match(term.getSubterm(1)))
          break Fail1998;
      g_33015 = term;
      e_33015 = trans.const269;
      term = g_33015;
      h_33015 = g_33015;
      if(a_33015.value == null || b_33015.value == null)
        break Fail1998;
      term = termFactory.annotateTerm(termFactory.makeTuple(a_33015.value, b_33015.value), checkListAnnos(termFactory, trans.constCons84));
      term = dr_lookup_rule_0_2.instance.invoke(context, h_33015, e_33015, term);
      if(term == null)
        break Fail1998;
      lifted577 lifted5770 = new lifted577();
      lifted5770.a_33015 = a_33015;
      lifted5770.b_33015 = b_33015;
      lifted5770.z_33014 = z_33014;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted5770);
      if(term == null)
        break Fail1998;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}