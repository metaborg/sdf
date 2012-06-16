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

@SuppressWarnings("all") final class lifted176 extends Strategy 
{ 
  TermReference m_9734;

  TermReference n_9734;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail830:
    { 
      if(m_9734.value == null)
        break Fail830;
      term = double_quote_0_0.instance.invoke(context, m_9734.value);
      if(term == null)
        break Fail830;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil0)})})}), (IStrategoList)generated.constNil0);
      if(n_9734.value == null)
        n_9734.value = term;
      else
        if(n_9734.value != term && !n_9734.value.match(term))
          break Fail830;
      if(true)
        return term;
    }
    return null;
  }
}