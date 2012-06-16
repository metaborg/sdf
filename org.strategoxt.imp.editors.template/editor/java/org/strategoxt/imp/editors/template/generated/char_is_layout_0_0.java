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
    Fail123:
    { 
      IStrategoTerm term131 = term;
      Success91:
      { 
        Fail124:
        { 
          if(term.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)term).intValue())
            break Fail124;
          if(true)
            break Success91;
        }
        term = term131;
        IStrategoTerm term132 = term;
        Success92:
        { 
          Fail125:
          { 
            if(term.getTermType() != IStrategoTerm.INT || 9 != ((IStrategoInt)term).intValue())
              break Fail125;
            if(true)
              break Success92;
          }
          term = term132;
          IStrategoTerm term133 = term;
          Success93:
          { 
            Fail126:
            { 
              if(term.getTermType() != IStrategoTerm.INT || 13 != ((IStrategoInt)term).intValue())
                break Fail126;
              if(true)
                break Success93;
            }
            term = term133;
            if(term.getTermType() != IStrategoTerm.INT || 10 != ((IStrategoInt)term).intValue())
              break Fail123;
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