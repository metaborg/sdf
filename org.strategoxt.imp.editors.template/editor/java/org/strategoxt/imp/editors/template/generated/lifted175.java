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

@SuppressWarnings("all") final class lifted175 extends Strategy 
{ 
  TermReference t_9734;

  TermReference u_9734;

  TermReference v_9734;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail831:
    { 
      IStrategoTerm x_9734 = null;
      IStrategoTerm y_9734 = null;
      y_9734 = term;
      if(t_9734.value == null)
        break Fail831;
      term = double_quote_0_0.instance.invoke(context, t_9734.value);
      if(term == null)
        break Fail831;
      x_9734 = term;
      term = y_9734;
      if(u_9734.value == null)
        break Fail831;
      IStrategoList list22;
      list22 = checkListTail(u_9734.value);
      if(list22 == null)
        break Fail831;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{x_9734})}), (IStrategoList)generated.constNil0)})})}), list22);
      if(v_9734.value == null)
        v_9734.value = term;
      else
        if(v_9734.value != term && !v_9734.value.match(term))
          break Fail831;
      if(true)
        return term;
    }
    return null;
  }
}