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

@SuppressWarnings("all") final class lifted190 extends Strategy 
{ 
  public static final lifted190 instance = new lifted190();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail821:
    { 
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail821;
      IStrategoTerm arg359 = ((IStrategoList)term).head();
      if(arg359.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg359).getConstructor())
        break Fail821;
      IStrategoTerm arg361 = ((IStrategoList)term).tail();
      if(arg361.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg361).isEmpty())
        break Fail821;
      term = generated.constNil0;
      if(true)
        return term;
    }
    return null;
  }
}