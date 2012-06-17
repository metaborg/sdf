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

@SuppressWarnings("all") public class char_is_layout_0_0 extends Strategy 
{ 
  public static char_is_layout_0_0 instance = new char_is_layout_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail943:
    { 
      IStrategoTerm term387 = term;
      Success347:
      { 
        Fail944:
        { 
          if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
            break Fail944;
          if(true)
            break Success347;
        }
        term = term387;
        IStrategoTerm term388 = term;
        Success348:
        { 
          Fail945:
          { 
            if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
              break Fail945;
            if(true)
              break Success348;
          }
          term = term388;
          IStrategoTerm term389 = term;
          Success349:
          { 
            Fail946:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                break Fail946;
              if(true)
                break Success349;
            }
            term = term389;
            if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
              break Fail943;
          }
        }
      }
      if(true)
        return term;
    }
    context.push("char_is_layout_0_0");
    context.popOnFailure();
    return null;
  }
}