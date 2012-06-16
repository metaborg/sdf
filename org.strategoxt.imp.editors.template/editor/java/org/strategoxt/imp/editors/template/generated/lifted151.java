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

@SuppressWarnings("all") final class lifted151 extends Strategy 
{ 
  public static final lifted151 instance = new lifted151();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail848:
    { 
      IStrategoTerm term201 = term;
      IStrategoConstructor cons52 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success357:
      { 
        if(cons52 == Main._consHide_0)
        { 
          Fail849:
          { 
            if(true)
              break Success357;
          }
          term = term201;
        }
        if(cons52 == Main._consText_1)
        { }
        else
        { 
          break Fail848;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}