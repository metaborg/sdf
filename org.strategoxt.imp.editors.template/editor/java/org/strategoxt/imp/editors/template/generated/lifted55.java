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

@SuppressWarnings("all") final class lifted55 extends Strategy 
{ 
  public static final lifted55 instance = new lifted55();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail944:
    { 
      IStrategoTerm r_9715 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail944;
      r_9715 = term.getSubterm(0);
      term = filter_1_0.instance.invoke(context, r_9715, lifted56.instance);
      if(term == null)
        break Fail944;
      if(true)
        return term;
    }
    return null;
  }
}