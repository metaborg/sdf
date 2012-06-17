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

@SuppressWarnings("all") final class lifted289 extends Strategy 
{ 
  public static final lifted289 instance = new lifted289();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1732:
    { 
      IStrategoTerm term367 = term;
      Success630:
      { 
        Fail1733:
        { 
          term = template_element_to_sdf_sep_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1733;
          if(true)
            break Success630;
        }
        term = template_element_to_sdf_0_0.instance.invoke(context, term367);
        if(term == null)
          break Fail1732;
      }
      if(true)
        return term;
    }
    return null;
  }
}