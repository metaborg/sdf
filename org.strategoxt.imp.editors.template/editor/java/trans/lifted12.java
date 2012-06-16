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

@SuppressWarnings("all") final class lifted12 extends Strategy 
{ 
  public static final lifted12 instance = new lifted12();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail251:
    { 
      IStrategoTerm term33 = term;
      Success70:
      { 
        Fail252:
        { 
          if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
            break Fail252;
          if(true)
            break Success70;
        }
        term = term33;
        IStrategoTerm term34 = term;
        Success71:
        { 
          Fail253:
          { 
            if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
              break Fail253;
            if(true)
              break Success71;
          }
          term = term34;
          IStrategoTerm term35 = term;
          Success72:
          { 
            Fail254:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
                break Fail254;
              if(true)
                break Success72;
            }
            term = term35;
            if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
              break Fail251;
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}