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

@SuppressWarnings("all") final class lifted264 extends Strategy 
{ 
  public static final lifted264 instance = new lifted264();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1760:
    { 
      IStrategoTerm s_32755 = null;
      IStrategoTerm y_32983 = null;
      IStrategoTerm a_32984 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1760;
      s_32755 = term.getSubterm(0);
      term = s_32755;
      y_32983 = s_32755;
      term = explode_string_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1760;
      term = reverse_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1760;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1760;
      a_32984 = ((IStrategoList)term).head();
      term = a_32984;
      IStrategoTerm term346 = term;
      Success638:
      { 
        Fail1761:
        { 
          term = is_alphanum_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1761;
          if(true)
            break Success638;
        }
        term = term346;
        if(term.getTermType() != IStrategoTerm.INT || 95 != ((IStrategoInt)term).intValue())
          break Fail1760;
      }
      term = y_32983;
      if(true)
        return term;
    }
    return null;
  }
}