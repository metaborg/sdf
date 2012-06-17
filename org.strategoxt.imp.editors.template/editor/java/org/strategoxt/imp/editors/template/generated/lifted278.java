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

@SuppressWarnings("all") final class lifted278 extends Strategy 
{ 
  public static final lifted278 instance = new lifted278();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1740:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1740;
      IStrategoTerm arg275 = term.getSubterm(0);
      if(arg275.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg275).isEmpty())
        break Fail1740;
      IStrategoTerm arg276 = ((IStrategoList)arg275).head();
      if(arg276.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg276).getConstructor())
        break Fail1740;
      IStrategoTerm arg278 = ((IStrategoList)arg275).tail();
      if(arg278.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg278).isEmpty())
        break Fail1740;
      if(true)
        return term;
    }
    return null;
  }
}