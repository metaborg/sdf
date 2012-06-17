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

@SuppressWarnings("all") final class lifted244 extends Strategy 
{ 
  public static final lifted244 instance = new lifted244();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1798:
    { 
      IStrategoTerm e_32751 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consSeparator_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1798;
      e_32751 = term.getSubterm(0);
      term = e_32751;
      if(true)
        return term;
    }
    return null;
  }
}