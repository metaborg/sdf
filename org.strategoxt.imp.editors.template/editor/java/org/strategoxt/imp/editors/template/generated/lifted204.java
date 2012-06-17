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

@SuppressWarnings("all") final class lifted204 extends Strategy 
{ 
  TermReference u_32743;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1832:
    { 
      term = template_section_to_stratego_0_1.instance.invoke(context, term, u_32743.value);
      if(term == null)
        break Fail1832;
      if(true)
        return term;
    }
    return null;
  }
}