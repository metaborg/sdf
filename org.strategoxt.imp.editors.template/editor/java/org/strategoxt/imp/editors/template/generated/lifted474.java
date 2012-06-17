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

@SuppressWarnings("all") final class lifted474 extends Strategy 
{ 
  public static final lifted474 instance = new lifted474();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1513:
    { 
      if(term.getTermType() != IStrategoTerm.STRING || !"deprecated".equals(((IStrategoString)term).stringValue()))
        break Fail1513;
      if(true)
        return term;
    }
    return null;
  }
}