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

@SuppressWarnings("all") final class lifted114 extends Strategy 
{ 
  public static final lifted114 instance = new lifted114();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail873:
    { 
      IStrategoTerm term141 = term;
      Success359:
      { 
        Fail874:
        { 
          IStrategoTerm term142 = term;
          Success360:
          { 
            Fail875:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
                break Fail875;
              if(true)
                break Success360;
            }
            term = term142;
            IStrategoTerm term143 = term;
            Success361:
            { 
              Fail876:
              { 
                if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
                  break Fail876;
                if(true)
                  break Success361;
              }
              term = term143;
              IStrategoTerm term144 = term;
              Success362:
              { 
                Fail877:
                { 
                  if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                    break Fail877;
                  if(true)
                    break Success362;
                }
                term = term144;
                if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
                  break Fail874;
              }
            }
          }
          { 
            if(true)
              break Fail873;
            if(true)
              break Success359;
          }
        }
        term = term141;
      }
      if(true)
        return term;
    }
    return null;
  }
}