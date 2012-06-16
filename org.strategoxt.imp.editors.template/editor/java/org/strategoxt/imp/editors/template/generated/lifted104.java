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

@SuppressWarnings("all") final class lifted104 extends Strategy 
{ 
  public static final lifted104 instance = new lifted104();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail894:
    { 
      IStrategoTerm term129 = term;
      Success371:
      { 
        Fail895:
        { 
          term = string_is_layout_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail895;
          { 
            if(true)
              break Fail894;
            if(true)
              break Success371;
          }
        }
        term = term129;
      }
      if(true)
        return term;
    }
    return null;
  }
}