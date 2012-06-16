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

@SuppressWarnings("all") final class lifted0 extends Strategy 
{ 
  TermReference k_9705;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1019:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consText_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1019;
      if(k_9705.value == null)
        k_9705.value = term.getSubterm(0);
      else
        if(k_9705.value != term.getSubterm(0) && !k_9705.value.match(term.getSubterm(0)))
          break Fail1019;
      if(true)
        return term;
    }
    return null;
  }
}