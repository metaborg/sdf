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

@SuppressWarnings("all") final class lifted109 extends Strategy 
{ 
  public static final lifted109 instance = new lifted109();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail885:
    { 
      IStrategoTerm term134 = term;
      Success367:
      { 
        Fail886:
        { 
          if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
            break Fail886;
          if(true)
            break Success367;
        }
        term = term134;
        IStrategoTerm term135 = term;
        Success368:
        { 
          Fail887:
          { 
            if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
              break Fail887;
            if(true)
              break Success368;
          }
          term = term135;
          IStrategoTerm term136 = term;
          Success369:
          { 
            Fail888:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                break Fail888;
              if(true)
                break Success369;
            }
            term = term136;
            if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
              break Fail885;
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}