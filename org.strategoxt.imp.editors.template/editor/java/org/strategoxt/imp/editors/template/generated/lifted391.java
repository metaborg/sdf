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

@SuppressWarnings("all") final class lifted391 extends Strategy 
{ 
  public static final lifted391 instance = new lifted391();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1635:
    { 
      IStrategoTerm w_32984 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1635;
      IStrategoTerm arg519 = term.getSubterm(0);
      if(arg519.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg519).isEmpty())
        break Fail1635;
      IStrategoTerm arg520 = ((IStrategoList)arg519).head();
      if(arg520.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg520).getConstructor())
        break Fail1635;
      w_32984 = arg520.getSubterm(0);
      IStrategoTerm arg521 = ((IStrategoList)arg519).tail();
      if(arg521.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg521).isEmpty())
        break Fail1635;
      term = string_length_0_0.instance.invoke(context, w_32984);
      if(term == null)
        break Fail1635;
      if(true)
        return term;
    }
    return null;
  }
}