package trans;

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

@SuppressWarnings("all") final class lifted542 extends Strategy 
{ 
  public static final lifted542 instance = new lifted542();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail2099:
    { 
      IStrategoTerm term699 = term;
      Success741:
      { 
        Fail2100:
        { 
          if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
            break Fail2100;
          if(true)
            break Success741;
        }
        term = term699;
        IStrategoTerm term700 = term;
        Success742:
        { 
          Fail2101:
          { 
            if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
              break Fail2101;
            if(true)
              break Success742;
          }
          term = term700;
          IStrategoTerm term701 = term;
          Success743:
          { 
            Fail2102:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
                break Fail2102;
              if(true)
                break Success743;
            }
            term = term701;
            if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
              break Fail2099;
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}