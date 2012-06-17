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

@SuppressWarnings("all") final class lifted355 extends Strategy 
{ 
  public static final lifted355 instance = new lifted355();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1663:
    { 
      IStrategoTerm term476 = term;
      IStrategoConstructor cons63 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success612:
      { 
        if(cons63 == Main._consHide_0)
        { 
          Fail1664:
          { 
            if(true)
              break Success612;
          }
          term = term476;
        }
        if(cons63 == Main._consText_1)
        { }
        else
        { 
          break Fail1663;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}