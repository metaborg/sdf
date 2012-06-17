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

@SuppressWarnings("all") final class lifted385 extends Strategy 
{ 
  public static final lifted385 instance = new lifted385();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1643:
    { 
      IStrategoTerm s_32984 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail1643;
      s_32984 = ((IStrategoList)term).head();
      IStrategoTerm arg511 = ((IStrategoList)term).tail();
      if(arg511.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg511).isEmpty())
        break Fail1643;
      term = y_32773.instance.invoke(context, s_32984);
      if(term == null)
        break Fail1643;
      term = generated.constNil3;
      if(true)
        return term;
    }
    return null;
  }
}