package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") final class lifted179 extends Strategy 
{ 
  TermReference u_9733;

  TermReference v_9733;

  TermReference w_9733;

  TermReference x_9733;

  TermReference y_9733;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail828:
    { 
      IStrategoTerm a_9734 = null;
      IStrategoTerm c_9734 = null;
      IStrategoTerm b_9734 = null;
      IStrategoTerm d_9734 = null;
      if(u_9733.value == null)
        break Fail828;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, u_9733.value, templatelang_template_desugar_0_0.instance);
      if(term == null)
        break Fail828;
      if(v_9733.value == null)
        v_9733.value = term;
      else
        if(v_9733.value != term && !v_9733.value.match(term))
          break Fail828;
      c_9734 = term;
      if(w_9733.value == null)
        break Fail828;
      term = double_quote_0_0.instance.invoke(context, w_9733.value);
      if(term == null)
        break Fail828;
      a_9734 = term;
      term = c_9734;
      d_9734 = c_9734;
      if(x_9733.value == null)
        break Fail828;
      term = templatelang_get_attrs_0_0.instance.invoke(context, x_9733.value);
      if(term == null)
        break Fail828;
      b_9734 = term;
      term = d_9734;
      IStrategoList list23;
      list23 = checkListTail(b_9734);
      if(list23 == null)
        break Fail828;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{a_9734})}), (IStrategoList)generated.constNil0)})})}), list23);
      if(y_9733.value == null)
        y_9733.value = term;
      else
        if(y_9733.value != term && !y_9733.value.match(term))
          break Fail828;
      if(true)
        return term;
    }
    return null;
  }
}