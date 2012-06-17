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

@SuppressWarnings("all") final class lifted389 extends Strategy 
{ 
  public static final lifted389 instance = new lifted389();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1641:
    { 
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1641;
      IStrategoTerm arg512 = ((IStrategoList)term).head();
      if(arg512.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg512).getConstructor())
        break Fail1641;
      IStrategoTerm arg514 = ((IStrategoList)term).tail();
      if(arg514.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg514).isEmpty())
        break Fail1641;
      term = generated.constNil3;
      if(true)
        return term;
    }
    return null;
  }
}