package trans;

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

@SuppressWarnings("all") final class lifted583 extends Strategy 
{ 
  TermReference l_33018;

  TermReference m_33018;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2064:
    { 
      term = aux_$Current$File_0_1.instance.invoke(context, term, l_33018.value);
      if(term == null)
        break Fail2064;
      if(m_33018.value == null)
        m_33018.value = term;
      else
        if(m_33018.value != term && !m_33018.value.match(term))
          break Fail2064;
      if(true)
        return term;
    }
    return null;
  }
}