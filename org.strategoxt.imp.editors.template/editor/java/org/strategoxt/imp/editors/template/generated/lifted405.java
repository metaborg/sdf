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

@SuppressWarnings("all") final class lifted405 extends Strategy 
{ 
  public static final lifted405 instance = new lifted405();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1622:
    { 
      IStrategoTerm term527 = term;
      Success607:
      { 
        Fail1623:
        { 
          term = is_hexnum_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1623;
          { 
            if(true)
              break Fail1622;
            if(true)
              break Success607;
          }
        }
        term = term527;
      }
      if(true)
        return term;
    }
    return null;
  }
}