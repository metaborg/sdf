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

@SuppressWarnings("all") final class lifted256 extends Strategy 
{ 
  public static final lifted256 instance = new lifted256();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail708:
    { 
      IStrategoTerm term384 = term;
      IStrategoConstructor cons39 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success294:
      { 
        if(cons39 == Main._consdeprecated_1)
        { 
          Fail709:
          { 
            if(true)
              break Success294;
          }
          term = term384;
        }
        Success295:
        { 
          if(cons39 == Main._consdeprecated_0)
          { 
            Fail710:
            { 
              if(true)
                break Success295;
            }
            term = term384;
          }
          Success296:
          { 
            if(cons39 == Main._consterm_1)
            { 
              Fail711:
              { 
                IStrategoTerm arg585 = term.getSubterm(0);
                if(arg585.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg585).getConstructor())
                  break Fail711;
                IStrategoTerm arg586 = arg585.getSubterm(0);
                if(arg586.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg586).getConstructor())
                  break Fail711;
                IStrategoTerm arg587 = arg586.getSubterm(0);
                if(arg587.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg587).getConstructor())
                  break Fail711;
                IStrategoTerm arg588 = arg587.getSubterm(0);
                if(arg588.getTermType() != IStrategoTerm.STRING || !"deprecated".equals(((IStrategoString)arg588).stringValue()))
                  break Fail711;
                if(true)
                  break Success296;
              }
              term = term384;
            }
            if(cons39 == Main._consterm_1)
            { 
              IStrategoTerm arg589 = term.getSubterm(0);
              if(arg589.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg589).getConstructor())
                break Fail708;
              IStrategoTerm arg590 = arg589.getSubterm(0);
              if(arg590.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg590).getConstructor())
                break Fail708;
              IStrategoTerm arg591 = arg590.getSubterm(0);
              if(arg591.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg591).getConstructor())
                break Fail708;
              IStrategoTerm arg592 = arg591.getSubterm(0);
              if(arg592.getTermType() != IStrategoTerm.STRING || !"deprecated".equals(((IStrategoString)arg592).stringValue()))
                break Fail708;
              IStrategoTerm arg593 = arg590.getSubterm(1);
              if(arg593.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg593).isEmpty())
                break Fail708;
              IStrategoTerm arg594 = ((IStrategoList)arg593).head();
              if(arg594.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg594).getConstructor())
                break Fail708;
              IStrategoTerm arg595 = arg594.getSubterm(0);
              if(arg595.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)arg595).getConstructor())
                break Fail708;
              IStrategoTerm arg597 = ((IStrategoList)arg593).tail();
              if(arg597.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg597).isEmpty())
                break Fail708;
            }
            else
            { 
              break Fail708;
            }
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}