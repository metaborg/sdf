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

@SuppressWarnings("all") final class lifted390 extends Strategy 
{ 
  public static final lifted390 instance = new lifted390();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1638:
    { 
      IStrategoTerm t_32984 = null;
      IStrategoTerm u_32984 = null;
      u_32984 = term;
      t_32984 = term;
      term = u_32984;
      IStrategoList list27;
      list27 = checkListTail(t_32984);
      if(list27 == null)
        break Fail1638;
      term = (IStrategoTerm)termFactory.makeListCons(generated.constLayout0, list27);
      if(true)
        return term;
    }
    return null;
  }
}