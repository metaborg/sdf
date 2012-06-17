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

@SuppressWarnings("all") final class lifted422 extends Strategy 
{ 
  TermReference l_32779;

  TermReference m_32779;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1584:
    { 
      if(l_32779.value == null)
        break Fail1584;
      term = explode_string_0_0.instance.invoke(context, l_32779.value);
      if(term == null)
        break Fail1584;
      term = un_double_quote_chars_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1584;
      if(m_32779.value == null)
        m_32779.value = term;
      else
        if(m_32779.value != term && !m_32779.value.match(term))
          break Fail1584;
      if(m_32779.value == null)
        break Fail1584;
      term = termFactory.makeTuple(generated.constTokenize0, m_32779.value);
      term = templatelang_index_option_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1584;
      if(true)
        return term;
    }
    return null;
  }
}