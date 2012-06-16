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

@SuppressWarnings("all") final class lifted206 extends Strategy 
{ 
  public static final lifted206 instance = new lifted206();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail802:
    { 
      IStrategoTerm term271 = term;
      Success351:
      { 
        Fail803:
        { 
          term = is_hexnum_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail803;
          { 
            if(true)
              break Fail802;
            if(true)
              break Success351;
          }
        }
        term = term271;
      }
      if(true)
        return term;
    }
    return null;
  }
}