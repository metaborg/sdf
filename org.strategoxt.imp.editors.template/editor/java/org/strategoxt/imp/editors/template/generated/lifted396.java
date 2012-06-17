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

@SuppressWarnings("all") final class lifted396 extends Strategy 
{ 
  TermReference e_32985;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1633:
    { 
      lifted397 lifted3970 = new lifted397();
      lifted3970.e_32985 = e_32985;
      term = string_as_chars_1_0.instance.invoke(context, term, lifted3970);
      if(term == null)
        break Fail1633;
      if(true)
        return term;
    }
    return null;
  }
}