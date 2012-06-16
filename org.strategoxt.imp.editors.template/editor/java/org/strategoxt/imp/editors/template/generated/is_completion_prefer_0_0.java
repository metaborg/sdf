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

@SuppressWarnings("all") public class is_completion_prefer_0_0 extends Strategy 
{ 
  public static is_completion_prefer_0_0 instance = new is_completion_prefer_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("is_completion_prefer_0_0");
    Fail406:
    { 
      IStrategoTerm f_9751 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consattrs_1 != ((IStrategoAppl)term).getConstructor())
        break Fail406;
      f_9751 = term.getSubterm(0);
      term = SRTS_one.instance.invoke(context, f_9751, lifted258.instance);
      if(term == null)
        break Fail406;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}