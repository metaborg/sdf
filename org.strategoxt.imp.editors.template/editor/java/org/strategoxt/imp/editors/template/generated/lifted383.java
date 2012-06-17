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

@SuppressWarnings("all") final class lifted383 extends Strategy 
{ 
  public static final lifted383 instance = new lifted383();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1644:
    { 
      IStrategoTerm q_32984 = null;
      IStrategoTerm r_32984 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1644;
      r_32984 = ((IStrategoList)term).head();
      q_32984 = ((IStrategoList)term).tail();
      term = r_32984;
      IStrategoTerm term507 = term;
      IStrategoConstructor cons62 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success611:
      { 
        if(cons62 == Main._consLine_1)
        { 
          Fail1645:
          { 
            IStrategoTerm arg506 = term.getSubterm(0);
            if(arg506.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg506).isEmpty())
              break Fail1645;
            if(true)
              break Success611;
          }
          term = term507;
        }
        if(cons62 == Main._consLine_1)
        { 
          IStrategoTerm arg507 = term.getSubterm(0);
          if(arg507.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg507).isEmpty())
            break Fail1644;
          IStrategoTerm arg508 = ((IStrategoList)arg507).head();
          if(arg508.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg508).getConstructor())
            break Fail1644;
          IStrategoTerm arg510 = ((IStrategoList)arg507).tail();
          if(arg510.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg510).isEmpty())
            break Fail1644;
        }
        else
        { 
          break Fail1644;
        }
      }
      term = q_32984;
      if(true)
        return term;
    }
    return null;
  }
}