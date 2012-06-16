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

@SuppressWarnings("all") final class lifted134 extends Strategy 
{ 
  public static final lifted134 instance = new lifted134();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail861:
    { 
      IStrategoTerm l_9723 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail861;
      IStrategoTerm arg203 = ((IStrategoList)term).head();
      if(arg203.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)arg203).intValue())
        break Fail861;
      IStrategoTerm arg204 = ((IStrategoList)term).tail();
      if(arg204.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg204).isEmpty())
        break Fail861;
      IStrategoTerm arg205 = ((IStrategoList)arg204).head();
      if(arg205.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)arg205).intValue())
        break Fail861;
      l_9723 = ((IStrategoList)arg204).tail();
      IStrategoList list5;
      list5 = checkListTail(l_9723);
      if(list5 == null)
        break Fail861;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const83, list5);
      if(true)
        return term;
    }
    return null;
  }
}