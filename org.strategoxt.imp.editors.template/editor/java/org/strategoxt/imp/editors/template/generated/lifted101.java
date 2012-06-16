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

@SuppressWarnings("all") final class lifted101 extends Strategy 
{ 
  public static final lifted101 instance = new lifted101();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail898:
    { 
      IStrategoTerm term126 = term;
      Success372:
      { 
        Fail899:
        { 
          term = string_is_layout_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail899;
          { 
            if(true)
              break Fail898;
            if(true)
              break Success372;
          }
        }
        term = term126;
      }
      if(true)
        return term;
    }
    return null;
  }
}