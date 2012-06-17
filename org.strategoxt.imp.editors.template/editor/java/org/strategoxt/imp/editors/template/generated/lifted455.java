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

@SuppressWarnings("all") final class lifted455 extends Strategy 
{ 
  public static final lifted455 instance = new lifted455();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1528:
    { 
      IStrategoTerm term640 = term;
      IStrategoConstructor cons51 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success550:
      { 
        if(cons51 == Main._consdeprecated_1)
        { 
          Fail1529:
          { 
            if(true)
              break Success550;
          }
          term = term640;
        }
        Success551:
        { 
          if(cons51 == Main._consdeprecated_0)
          { 
            Fail1530:
            { 
              if(true)
                break Success551;
            }
            term = term640;
          }
          Success552:
          { 
            if(cons51 == Main._consterm_1)
            { 
              Fail1531:
              { 
                IStrategoTerm arg738 = term.getSubterm(0);
                if(arg738.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg738).getConstructor())
                  break Fail1531;
                IStrategoTerm arg739 = arg738.getSubterm(0);
                if(arg739.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg739).getConstructor())
                  break Fail1531;
                IStrategoTerm arg740 = arg739.getSubterm(0);
                if(arg740.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg740).getConstructor())
                  break Fail1531;
                IStrategoTerm arg741 = arg740.getSubterm(0);
                if(arg741.getTermType() != IStrategoTerm.STRING || !"deprecated".equals(((IStrategoString)arg741).stringValue()))
                  break Fail1531;
                if(true)
                  break Success552;
              }
              term = term640;
            }
            if(cons51 == Main._consterm_1)
            { 
              IStrategoTerm arg742 = term.getSubterm(0);
              if(arg742.getTermType() != IStrategoTerm.APPL || Main._consdefault_1 != ((IStrategoAppl)arg742).getConstructor())
                break Fail1528;
              IStrategoTerm arg743 = arg742.getSubterm(0);
              if(arg743.getTermType() != IStrategoTerm.APPL || Main._consappl_2 != ((IStrategoAppl)arg743).getConstructor())
                break Fail1528;
              IStrategoTerm arg744 = arg743.getSubterm(0);
              if(arg744.getTermType() != IStrategoTerm.APPL || Main._consunquoted_1 != ((IStrategoAppl)arg744).getConstructor())
                break Fail1528;
              IStrategoTerm arg745 = arg744.getSubterm(0);
              if(arg745.getTermType() != IStrategoTerm.STRING || !"deprecated".equals(((IStrategoString)arg745).stringValue()))
                break Fail1528;
              IStrategoTerm arg746 = arg743.getSubterm(1);
              if(arg746.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg746).isEmpty())
                break Fail1528;
              IStrategoTerm arg747 = ((IStrategoList)arg746).head();
              if(arg747.getTermType() != IStrategoTerm.APPL || Main._consfun_1 != ((IStrategoAppl)arg747).getConstructor())
                break Fail1528;
              IStrategoTerm arg748 = arg747.getSubterm(0);
              if(arg748.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)arg748).getConstructor())
                break Fail1528;
              IStrategoTerm arg750 = ((IStrategoList)arg746).tail();
              if(arg750.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg750).isEmpty())
                break Fail1528;
            }
            else
            { 
              break Fail1528;
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