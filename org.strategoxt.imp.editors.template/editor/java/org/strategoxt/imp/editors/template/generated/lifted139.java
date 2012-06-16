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

@SuppressWarnings("all") final class lifted139 extends Strategy 
{ 
  TermReference r_9725;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail855:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consText_1 != ((IStrategoAppl)term).getConstructor())
        break Fail855;
      if(r_9725.value == null)
        r_9725.value = term.getSubterm(0);
      else
        if(r_9725.value != term.getSubterm(0) && !r_9725.value.match(term.getSubterm(0)))
          break Fail855;
      if(true)
        return term;
    }
    return null;
  }
}