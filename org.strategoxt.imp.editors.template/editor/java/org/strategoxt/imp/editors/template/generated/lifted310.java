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

@SuppressWarnings("all") final class lifted310 extends Strategy 
{ 
  public static final lifted310 instance = new lifted310();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1699:
    { 
      IStrategoTerm term393 = term;
      Success619:
      { 
        Fail1700:
        { 
          IStrategoTerm term394 = term;
          Success620:
          { 
            Fail1701:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
                break Fail1701;
              if(true)
                break Success620;
            }
            term = term394;
            IStrategoTerm term395 = term;
            Success621:
            { 
              Fail1702:
              { 
                if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
                  break Fail1702;
                if(true)
                  break Success621;
              }
              term = term395;
              IStrategoTerm term396 = term;
              Success622:
              { 
                Fail1703:
                { 
                  if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                    break Fail1703;
                  if(true)
                    break Success622;
                }
                term = term396;
                if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
                  break Fail1700;
              }
            }
          }
          { 
            if(true)
              break Fail1699;
            if(true)
              break Success619;
          }
        }
        term = term393;
      }
      if(true)
        return term;
    }
    return null;
  }
}