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

@SuppressWarnings("all") final class lifted1 extends Strategy 
{ 
  public static final lifted1 instance = new lifted1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1017:
    { 
      IStrategoTerm term4 = term;
      IStrategoConstructor cons56 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success409:
      { 
        if(cons56 == Main._consText_1)
        { 
          Fail1018:
          { 
            if(true)
              break Success409;
          }
          term = term4;
        }
        if(cons56 == Main._consHide_0)
        { }
        else
        { 
          break Fail1017;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}