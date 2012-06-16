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

@SuppressWarnings("all") final class lifted325 extends Strategy 
{ 
  public static final lifted325 instance = new lifted325();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail644:
    { 
      IStrategoTerm q_9768 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail644;
      q_9768 = term.getSubterm(0);
      IStrategoTerm arg629 = term.getSubterm(1);
      term = aux_$Descriptor$P$P$Table_0_1.instance.invoke(context, q_9768, arg629);
      if(term == null)
        break Fail644;
      if(true)
        return term;
    }
    return null;
  }
}