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

@SuppressWarnings("all") final class lifted392 extends Strategy 
{ 
  TermReference m_32773;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1628:
    { 
      TermReference x_32984 = new TermReference();
      IStrategoTerm d_32985 = null;
      d_32985 = term;
      if(m_32773.value == null)
        break Fail1628;
      term = m_32773.value;
      if(x_32984.value == null)
        x_32984.value = term;
      else
        if(x_32984.value != term && !x_32984.value.match(term))
          break Fail1628;
      term = d_32985;
      lifted393 lifted3930 = new lifted393();
      lifted3930.x_32984 = x_32984;
      term = $Line_1_0.instance.invoke(context, term, lifted3930);
      if(term == null)
        break Fail1628;
      if(true)
        return term;
    }
    return null;
  }
}