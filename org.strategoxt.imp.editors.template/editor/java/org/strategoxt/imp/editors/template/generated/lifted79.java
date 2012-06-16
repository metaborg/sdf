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

@SuppressWarnings("all") final class lifted79 extends Strategy 
{ 
  public static final lifted79 instance = new lifted79();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail920:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail920;
      IStrategoTerm arg127 = term.getSubterm(0);
      if(arg127.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg127).isEmpty())
        break Fail920;
      IStrategoTerm arg128 = ((IStrategoList)arg127).head();
      if(arg128.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg128).getConstructor())
        break Fail920;
      IStrategoTerm arg130 = ((IStrategoList)arg127).tail();
      if(arg130.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg130).isEmpty())
        break Fail920;
      if(true)
        return term;
    }
    return null;
  }
}