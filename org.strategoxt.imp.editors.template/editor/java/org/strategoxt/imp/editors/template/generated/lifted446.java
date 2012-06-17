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

@SuppressWarnings("all") final class lifted446 extends Strategy 
{ 
  TermReference e_32788;

  Strategy f_32788;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1537:
    { 
      term = contract_requires_1_1.instance.invoke(context, term, f_32788, e_32788.value);
      if(term == null)
        break Fail1537;
      if(true)
        return term;
    }
    return null;
  }
}