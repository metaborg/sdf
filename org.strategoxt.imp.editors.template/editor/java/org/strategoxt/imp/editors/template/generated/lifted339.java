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

@SuppressWarnings("all") final class lifted339 extends Strategy 
{ 
  public static final lifted339 instance = new lifted339();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1673:
    { 
      IStrategoTerm term425 = term;
      IStrategoConstructor cons65 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success614:
      { 
        if(cons65 == Main._consText_1)
        { 
          Fail1674:
          { 
            if(true)
              break Success614;
          }
          term = term425;
        }
        if(cons65 == Main._consHide_0)
        { }
        else
        { 
          break Fail1673;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}