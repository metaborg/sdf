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

@SuppressWarnings("all") final class lifted111 extends Strategy 
{ 
  public static final lifted111 instance = new lifted111();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail879:
    { 
      IStrategoTerm term137 = term;
      Success363:
      { 
        Fail880:
        { 
          IStrategoTerm term138 = term;
          Success364:
          { 
            Fail881:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
                break Fail881;
              if(true)
                break Success364;
            }
            term = term138;
            IStrategoTerm term139 = term;
            Success365:
            { 
              Fail882:
              { 
                if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
                  break Fail882;
                if(true)
                  break Success365;
              }
              term = term139;
              IStrategoTerm term140 = term;
              Success366:
              { 
                Fail883:
                { 
                  if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                    break Fail883;
                  if(true)
                    break Success366;
                }
                term = term140;
                if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
                  break Fail880;
              }
            }
          }
          { 
            if(true)
              break Fail879;
            if(true)
              break Success363;
          }
        }
        term = term137;
      }
      if(true)
        return term;
    }
    return null;
  }
}