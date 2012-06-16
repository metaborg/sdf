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

@SuppressWarnings("all") final class lifted277 extends Strategy 
{ 
  Strategy o_9757;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail690:
    { 
      lifted278 lifted2780 = new lifted278();
      lifted2780.o_9757 = o_9757;
      term = fun_1_0.instance.invoke(context, term, lifted2780);
      if(term == null)
        break Fail690;
      if(true)
        return term;
    }
    return null;
  }
}