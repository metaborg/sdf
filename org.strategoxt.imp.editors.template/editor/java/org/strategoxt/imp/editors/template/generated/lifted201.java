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

@SuppressWarnings("all") final class lifted201 extends Strategy 
{ 
  public static final lifted201 instance = new lifted201();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1835:
    { 
      IStrategoTerm term263 = term;
      IStrategoConstructor cons67 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success664:
      { 
        if(cons67 == Main._consText_1)
        { 
          Fail1836:
          { 
            if(true)
              break Success664;
          }
          term = term263;
        }
        if(cons67 == Main._consHide_0)
        { }
        else
        { 
          break Fail1835;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}