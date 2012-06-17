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

@SuppressWarnings("all") final class lifted378 extends Strategy 
{ 
  TermReference d_32772;

  TermReference e_32772;

  TermReference f_32772;

  TermReference g_32772;

  TermReference h_32772;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1648:
    { 
      IStrategoTerm j_32772 = null;
      IStrategoTerm l_32772 = null;
      IStrategoTerm k_32772 = null;
      IStrategoTerm m_32772 = null;
      if(d_32772.value == null)
        break Fail1648;
      term = templatelang_origin_track_forced_1_0.instance.invoke(context, d_32772.value, templatelang_template_desugar_0_0.instance);
      if(term == null)
        break Fail1648;
      if(e_32772.value == null)
        e_32772.value = term;
      else
        if(e_32772.value != term && !e_32772.value.match(term))
          break Fail1648;
      l_32772 = term;
      if(f_32772.value == null)
        break Fail1648;
      term = double_quote_0_0.instance.invoke(context, f_32772.value);
      if(term == null)
        break Fail1648;
      j_32772 = term;
      term = l_32772;
      m_32772 = l_32772;
      if(g_32772.value == null)
        break Fail1648;
      term = templatelang_get_attrs_0_0.instance.invoke(context, g_32772.value);
      if(term == null)
        break Fail1648;
      k_32772 = term;
      term = m_32772;
      IStrategoList list26;
      list26 = checkListTail(k_32772);
      if(list26 == null)
        break Fail1648;
      term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{j_32772})}), (IStrategoList)generated.constNil3)})})}), list26);
      if(h_32772.value == null)
        h_32772.value = term;
      else
        if(h_32772.value != term && !h_32772.value.match(term))
          break Fail1648;
      if(true)
        return term;
    }
    return null;
  }
}