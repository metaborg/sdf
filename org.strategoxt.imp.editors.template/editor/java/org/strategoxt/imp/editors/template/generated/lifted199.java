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

@SuppressWarnings("all") final class lifted199 extends Strategy 
{ 
  TermReference s_32743;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1839:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consText_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1839;
      if(s_32743.value == null)
        s_32743.value = term.getSubterm(0);
      else
        if(s_32743.value != term.getSubterm(0) && !s_32743.value.match(term.getSubterm(0)))
          break Fail1839;
      if(true)
        return term;
    }
    return null;
  }
}