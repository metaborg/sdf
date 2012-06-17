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

@SuppressWarnings("all") final class lifted338 extends Strategy 
{ 
  TermReference a_32764;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1675:
    { 
      if(term.getTermType() != IStrategoTerm.APPL || Main._consText_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1675;
      if(a_32764.value == null)
        a_32764.value = term.getSubterm(0);
      else
        if(a_32764.value != term.getSubterm(0) && !a_32764.value.match(term.getSubterm(0)))
          break Fail1675;
      if(true)
        return term;
    }
    return null;
  }
}