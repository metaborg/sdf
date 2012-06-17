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

@SuppressWarnings("all") final class lifted350 extends Strategy 
{ 
  public static final lifted350 instance = new lifted350();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1668:
    { 
      IStrategoTerm term457 = term;
      IStrategoConstructor cons64 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success613:
      { 
        if(cons64 == Main._consHide_0)
        { 
          Fail1669:
          { 
            if(true)
              break Success613;
          }
          term = term457;
        }
        if(cons64 == Main._consText_1)
        { }
        else
        { 
          break Fail1668;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}