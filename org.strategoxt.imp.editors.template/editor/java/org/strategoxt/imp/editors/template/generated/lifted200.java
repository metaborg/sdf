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

@SuppressWarnings("all") final class lifted200 extends Strategy 
{ 
  public static final lifted200 instance = new lifted200();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1837:
    { 
      IStrategoTerm term259 = term;
      IStrategoConstructor cons68 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success665:
      { 
        if(cons68 == Main._consText_1)
        { 
          Fail1838:
          { 
            if(true)
              break Success665;
          }
          term = term259;
        }
        if(cons68 == Main._consHide_0)
        { }
        else
        { 
          break Fail1837;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}