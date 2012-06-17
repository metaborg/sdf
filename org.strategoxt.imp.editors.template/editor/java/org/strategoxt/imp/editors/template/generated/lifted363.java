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

@SuppressWarnings("all") final class lifted363 extends Strategy 
{ 
  TermReference x_32770;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1659:
    { 
      IStrategoTerm a_32771 = null;
      IStrategoTerm b_32771 = null;
      b_32771 = term;
      a_32771 = term;
      term = b_32771;
      if(x_32770.value == null)
        break Fail1659;
      IStrategoList list24;
      list24 = checkListTail(a_32771);
      if(list24 == null)
        break Fail1659;
      term = (IStrategoTerm)termFactory.makeListCons(x_32770.value, list24);
      if(true)
        return term;
    }
    return null;
  }
}