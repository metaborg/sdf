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

@SuppressWarnings("all") final class lifted164 extends Strategy 
{ 
  TermReference o_9732;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail839:
    { 
      IStrategoTerm r_9732 = null;
      IStrategoTerm s_9732 = null;
      s_9732 = term;
      r_9732 = term;
      term = s_9732;
      if(o_9732.value == null)
        break Fail839;
      IStrategoList list21;
      list21 = checkListTail(r_9732);
      if(list21 == null)
        break Fail839;
      term = (IStrategoTerm)termFactory.makeListCons(o_9732.value, list21);
      if(true)
        return term;
    }
    return null;
  }
}