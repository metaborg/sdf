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

@SuppressWarnings("all") final class lifted140 extends Strategy 
{ 
  public static final lifted140 instance = new lifted140();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail853:
    { 
      IStrategoTerm term169 = term;
      IStrategoConstructor cons53 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success358:
      { 
        if(cons53 == Main._consText_1)
        { 
          Fail854:
          { 
            if(true)
              break Success358;
          }
          term = term169;
        }
        if(cons53 == Main._consHide_0)
        { }
        else
        { 
          break Fail853;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}