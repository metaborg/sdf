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

@SuppressWarnings("all") final class lifted382 extends Strategy 
{ 
  TermReference n_32773;

  TermReference m_32773;

  TermReference o_32773;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1626:
    { 
      if(n_32773.value == null)
        break Fail1626;
      term = try_1_0.instance.invoke(context, n_32773.value, lifted383.instance);
      if(term == null)
        break Fail1626;
      term = try_1_0.instance.invoke(context, term, lifted384.instance);
      if(term == null)
        break Fail1626;
      term = templatelang_element_desugar_top_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1626;
      term = map_1_0.instance.invoke(context, term, lifted386.instance);
      if(term == null)
        break Fail1626;
      IStrategoTerm term509 = term;
      Success608:
      { 
        Fail1627:
        { 
          IStrategoTerm v_32984 = null;
          v_32984 = term;
          term = filter_1_0.instance.invoke(context, term, lifted391.instance);
          if(term == null)
            break Fail1627;
          term = list_min_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1627;
          if(m_32773.value == null)
            m_32773.value = term;
          else
            if(m_32773.value != term && !m_32773.value.match(term))
              break Fail1627;
          term = v_32984;
          { 
            lifted392 lifted3920 = new lifted392();
            lifted3920.m_32773 = m_32773;
            term = map_1_0.instance.invoke(context, term, lifted3920);
            if(term == null)
              break Fail1626;
            if(true)
              break Success608;
          }
        }
        term = term509;
      }
      if(o_32773.value == null)
        o_32773.value = term;
      else
        if(o_32773.value != term && !o_32773.value.match(term))
          break Fail1626;
      if(true)
        return term;
    }
    return null;
  }
}