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

@SuppressWarnings("all") final class lifted313 extends Strategy 
{ 
  public static final lifted313 instance = new lifted313();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1693:
    { 
      IStrategoTerm term397 = term;
      Success615:
      { 
        Fail1694:
        { 
          IStrategoTerm term398 = term;
          Success616:
          { 
            Fail1695:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
                break Fail1695;
              if(true)
                break Success616;
            }
            term = term398;
            IStrategoTerm term399 = term;
            Success617:
            { 
              Fail1696:
              { 
                if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
                  break Fail1696;
                if(true)
                  break Success617;
              }
              term = term399;
              IStrategoTerm term400 = term;
              Success618:
              { 
                Fail1697:
                { 
                  if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                    break Fail1697;
                  if(true)
                    break Success618;
                }
                term = term400;
                if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
                  break Fail1694;
              }
            }
          }
          { 
            if(true)
              break Fail1693;
            if(true)
              break Success615;
          }
        }
        term = term397;
      }
      if(true)
        return term;
    }
    return null;
  }
}