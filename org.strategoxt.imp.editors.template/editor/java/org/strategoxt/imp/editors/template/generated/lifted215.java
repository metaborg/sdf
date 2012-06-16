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

@SuppressWarnings("all") final class lifted215 extends Strategy 
{ 
  TermReference h_9740;

  TermReference i_9740;

  TermReference j_9740;

  TermReference k_9740;

  TermReference l_9740;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail774:
    { 
      if(i_9740.value == null || l_9740.value == null)
        break Fail774;
      term = termFactory.makeTuple(i_9740.value, generated.constTemplateBySort0, l_9740.value);
      term = index_symbol_definition_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail774;
      IStrategoTerm term287 = term;
      Success334:
      { 
        Fail775:
        { 
          IStrategoTerm m_9740 = null;
          m_9740 = term;
          if(h_9740.value == null)
            break Fail775;
          term = fetch_cons_name_0_0.instance.invoke(context, h_9740.value);
          if(term == null)
            break Fail775;
          if(j_9740.value == null)
            j_9740.value = term;
          else
            if(j_9740.value != term && !j_9740.value.match(term))
              break Fail775;
          term = m_9740;
          { 
            if(i_9740.value == null || j_9740.value == null)
              break Fail774;
            term = termFactory.makeTuple(i_9740.value, j_9740.value);
            if(k_9740.value == null)
              k_9740.value = term;
            else
              if(k_9740.value != term && !k_9740.value.match(term))
                break Fail774;
            if(k_9740.value == null || l_9740.value == null)
              break Fail774;
            term = termFactory.makeTuple(k_9740.value, generated.constTemplateBySortCons0, l_9740.value);
            term = index_symbol_definition_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail774;
            if(true)
              break Success334;
          }
        }
        term = term287;
      }
      if(true)
        return term;
    }
    return null;
  }
}