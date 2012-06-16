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

@SuppressWarnings("all") final class lifted183 extends Strategy 
{ 
  TermReference e_9735;

  TermReference d_9735;

  TermReference f_9735;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail806:
    { 
      if(e_9735.value == null)
        break Fail806;
      term = try_1_0.instance.invoke(context, e_9735.value, lifted184.instance);
      if(term == null)
        break Fail806;
      term = try_1_0.instance.invoke(context, term, lifted185.instance);
      if(term == null)
        break Fail806;
      term = templatelang_element_desugar_top_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail806;
      term = map_1_0.instance.invoke(context, term, lifted187.instance);
      if(term == null)
        break Fail806;
      IStrategoTerm term253 = term;
      Success352:
      { 
        Fail807:
        { 
          IStrategoTerm m_9946 = null;
          m_9946 = term;
          term = filter_1_0.instance.invoke(context, term, lifted192.instance);
          if(term == null)
            break Fail807;
          term = list_min_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail807;
          if(d_9735.value == null)
            d_9735.value = term;
          else
            if(d_9735.value != term && !d_9735.value.match(term))
              break Fail807;
          term = m_9946;
          { 
            lifted193 lifted1930 = new lifted193();
            lifted1930.d_9735 = d_9735;
            term = map_1_0.instance.invoke(context, term, lifted1930);
            if(term == null)
              break Fail806;
            if(true)
              break Success352;
          }
        }
        term = term253;
      }
      if(f_9735.value == null)
        f_9735.value = term;
      else
        if(f_9735.value != term && !f_9735.value.match(term))
          break Fail806;
      if(true)
        return term;
    }
    return null;
  }
}