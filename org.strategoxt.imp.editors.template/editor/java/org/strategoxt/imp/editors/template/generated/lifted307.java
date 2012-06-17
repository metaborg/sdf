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

@SuppressWarnings("all") final class lifted307 extends Strategy 
{ 
  public static final lifted307 instance = new lifted307();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1704:
    { 
      term = SRTS_all.instance.invoke(context, term, lifted308.instance);
      if(term == null)
        break Fail1704;
      if(true)
        return term;
    }
    return null;
  }
}