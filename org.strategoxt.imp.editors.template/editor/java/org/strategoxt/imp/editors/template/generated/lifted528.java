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

@SuppressWarnings("all") final class lifted528 extends Strategy 
{ 
  TermReference a_32808;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1460:
    { 
      term = aux_$Descriptor$P$P$Table_0_1.instance.invoke(context, term, a_32808.value);
      if(term == null)
        break Fail1460;
      if(true)
        return term;
    }
    return null;
  }
}