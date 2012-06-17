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

@SuppressWarnings("all") final class lifted308 extends Strategy 
{ 
  public static final lifted308 instance = new lifted308();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1705:
    { 
      IStrategoTerm term390 = term;
      Success623:
      { 
        Fail1706:
        { 
          if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
            break Fail1706;
          if(true)
            break Success623;
        }
        term = term390;
        IStrategoTerm term391 = term;
        Success624:
        { 
          Fail1707:
          { 
            if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
              break Fail1707;
            if(true)
              break Success624;
          }
          term = term391;
          IStrategoTerm term392 = term;
          Success625:
          { 
            Fail1708:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                break Fail1708;
              if(true)
                break Success625;
            }
            term = term392;
            if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
              break Fail1705;
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}