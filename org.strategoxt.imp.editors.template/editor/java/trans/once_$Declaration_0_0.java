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

@SuppressWarnings("all") public class once_$Declaration_0_0 extends Strategy 
{ 
  public static once_$Declaration_0_0 instance = new once_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("once_Declaration_0_0");
    Fail1993:
    { 
      IStrategoTerm u_33013 = null;
      TermReference v_33013 = new TermReference();
      TermReference w_33013 = new TermReference();
      TermReference x_33013 = new TermReference();
      IStrategoTerm y_33013 = null;
      TermReference z_33013 = new TermReference();
      IStrategoTerm b_33014 = null;
      IStrategoTerm c_33014 = null;
      IStrategoTerm e_33014 = null;
      IStrategoTerm f_33014 = null;
      if(w_33013.value == null)
        w_33013.value = term;
      else
        if(w_33013.value != term && !w_33013.value.match(term))
          break Fail1993;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1993;
      if(z_33013.value == null)
        z_33013.value = term.getSubterm(0);
      else
        if(z_33013.value != term.getSubterm(0) && !z_33013.value.match(term.getSubterm(0)))
          break Fail1993;
      if(v_33013.value == null)
        v_33013.value = term.getSubterm(1);
      else
        if(v_33013.value != term.getSubterm(1) && !v_33013.value.match(term.getSubterm(1)))
          break Fail1993;
      b_33014 = term;
      e_33014 = term;
      c_33014 = trans.const269;
      term = e_33014;
      f_33014 = e_33014;
      if(z_33013.value == null || v_33013.value == null)
        break Fail1993;
      term = termFactory.annotateTerm(termFactory.makeTuple(z_33013.value, v_33013.value), checkListAnnos(termFactory, trans.constCons84));
      term = dr_lookup_rule_pointer_0_2.instance.invoke(context, f_33014, c_33014, term);
      if(term == null)
        break Fail1993;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
        break Fail1993;
      u_33013 = term.getSubterm(0);
      if(z_33013.value == null)
        z_33013.value = term.getSubterm(1);
      else
        if(z_33013.value != term.getSubterm(1) && !z_33013.value.match(term.getSubterm(1)))
          break Fail1993;
      y_33013 = term.getSubterm(2);
      term = u_33013;
      lifted574 lifted5740 = new lifted574();
      lifted5740.z_33013 = z_33013;
      lifted5740.v_33013 = v_33013;
      lifted5740.w_33013 = w_33013;
      lifted5740.x_33013 = x_33013;
      term = split_fetch_1_0.instance.invoke(context, term, lifted5740);
      if(term == null)
        break Fail1993;
      term = conc_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1993;
      term = hashtable_put_0_2.instance.invoke(context, y_33013, z_33013.value, term);
      if(term == null)
        break Fail1993;
      term = b_33014;
      if(x_33013.value == null)
        break Fail1993;
      term = x_33013.value;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}