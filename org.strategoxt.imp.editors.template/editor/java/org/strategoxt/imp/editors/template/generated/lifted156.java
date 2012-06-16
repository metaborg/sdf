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

@SuppressWarnings("all") final class lifted156 extends Strategy 
{ 
  public static final lifted156 instance = new lifted156();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail843:
    { 
      IStrategoTerm term220 = term;
      IStrategoConstructor cons51 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success356:
      { 
        if(cons51 == Main._consHide_0)
        { 
          Fail844:
          { 
            if(true)
              break Success356;
          }
          term = term220;
        }
        if(cons51 == Main._consText_1)
        { }
        else
        { 
          break Fail843;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}