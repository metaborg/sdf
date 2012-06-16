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

@SuppressWarnings("all") final class lifted191 extends Strategy 
{ 
  public static final lifted191 instance = new lifted191();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail818:
    { 
      IStrategoTerm k_9946 = null;
      IStrategoTerm l_9946 = null;
      l_9946 = term;
      k_9946 = term;
      term = l_9946;
      IStrategoList list24;
      list24 = checkListTail(k_9946);
      if(list24 == null)
        break Fail818;
      term = (IStrategoTerm)termFactory.makeListCons(generated.constLayout0, list24);
      if(true)
        return term;
    }
    return null;
  }
}