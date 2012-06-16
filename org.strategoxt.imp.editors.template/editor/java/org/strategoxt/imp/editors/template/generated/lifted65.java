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

@SuppressWarnings("all") final class lifted65 extends Strategy 
{ 
  public static final lifted65 instance = new lifted65();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail940:
    { 
      IStrategoTerm k_9717 = null;
      IStrategoTerm p_9945 = null;
      IStrategoTerm r_9945 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)term).getConstructor())
        break Fail940;
      k_9717 = term.getSubterm(0);
      term = k_9717;
      p_9945 = k_9717;
      term = explode_string_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail940;
      term = reverse_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail940;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail940;
      r_9945 = ((IStrategoList)term).head();
      term = r_9945;
      IStrategoTerm term91 = term;
      Success382:
      { 
        Fail941:
        { 
          term = is_alphanum_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail941;
          if(true)
            break Success382;
        }
        term = term91;
        if(term.getTermType() != IStrategoTerm.INT || 95 != ((IStrategoInt)term).intValue())
          break Fail940;
      }
      term = p_9945;
      if(true)
        return term;
    }
    return null;
  }
}