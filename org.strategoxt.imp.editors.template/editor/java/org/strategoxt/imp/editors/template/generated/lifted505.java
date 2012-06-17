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

@SuppressWarnings("all") final class lifted505 extends Strategy 
{ 
  public static final lifted505 instance = new lifted505();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1483:
    { 
      IStrategoTerm b_32798 = null;
      IStrategoTerm j_32798 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1483;
      j_32798 = term.getSubterm(0);
      IStrategoTerm arg771 = term.getSubterm(1);
      b_32798 = arg771;
      term = aux_$Expanded_0_2.instance.invoke(context, j_32798, arg771, b_32798);
      if(term == null)
        break Fail1483;
      if(true)
        return term;
    }
    return null;
  }
}