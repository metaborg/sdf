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

@SuppressWarnings("all") final class lifted374 extends Strategy 
{ 
  TermReference c_32773;

  TermReference d_32773;

  TermReference e_32773;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1651:
    { 
      IStrategoTerm g_32773 = null;
      IStrategoTerm h_32773 = null;
      h_32773 = term;
      if(c_32773.value == null)
        break Fail1651;
      term = double_quote_0_0.instance.invoke(context, c_32773.value);
      if(term == null)
        break Fail1651;
      g_32773 = term;
      term = h_32773;
      if(d_32773.value == null)
        break Fail1651;
      IStrategoList list25;
      list25 = checkListTail(d_32773.value);
      if(list25 == null)
        break Fail1651;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{g_32773})}), (IStrategoList)generated.constNil3)})})}), list25);
      if(e_32773.value == null)
        e_32773.value = term;
      else
        if(e_32773.value != term && !e_32773.value.match(term))
          break Fail1651;
      if(true)
        return term;
    }
    return null;
  }
}