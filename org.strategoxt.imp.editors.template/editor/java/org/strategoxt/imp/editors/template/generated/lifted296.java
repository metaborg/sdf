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

@SuppressWarnings("all") final class lifted296 extends Strategy 
{ 
  public static final lifted296 instance = new lifted296();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail676:
    { 
      if(term.getTermType() != IStrategoTerm.STRING || !"avoid".equals(((IStrategoString)term).stringValue()))
        break Fail676;
      if(true)
        return term;
    }
    return null;
  }
}