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

@SuppressWarnings("all") final class lifted333 extends Strategy 
{ 
  public static final lifted333 instance = new lifted333();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1681:
    { 
      IStrategoTerm u_32761 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1681;
      IStrategoTerm arg356 = ((IStrategoList)term).head();
      if(arg356.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)arg356).intValue())
        break Fail1681;
      IStrategoTerm arg357 = ((IStrategoList)term).tail();
      if(arg357.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg357).isEmpty())
        break Fail1681;
      IStrategoTerm arg358 = ((IStrategoList)arg357).head();
      if(arg358.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)arg358).intValue())
        break Fail1681;
      u_32761 = ((IStrategoList)arg357).tail();
      IStrategoList list8;
      list8 = checkListTail(u_32761);
      if(list8 == null)
        break Fail1681;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const204, list8);
      if(true)
        return term;
    }
    return null;
  }
}