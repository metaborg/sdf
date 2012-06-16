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

@SuppressWarnings("all") final class lifted186 extends Strategy 
{ 
  public static final lifted186 instance = new lifted186();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail823:
    { 
      IStrategoTerm j_9946 = null;
      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
        break Fail823;
      j_9946 = ((IStrategoList)term).head();
      IStrategoTerm arg358 = ((IStrategoList)term).tail();
      if(arg358.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg358).isEmpty())
        break Fail823;
      term = p_9735.instance.invoke(context, j_9946);
      if(term == null)
        break Fail823;
      term = generated.constNil0;
      if(true)
        return term;
    }
    return null;
  }
}