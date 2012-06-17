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

@SuppressWarnings("all") final class lifted314 extends Strategy 
{ 
  public static final lifted314 instance = new lifted314();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1690:
    { 
      IStrategoTerm i_32760 = null;
      IStrategoTerm k_32760 = null;
      k_32760 = term;
      term = collect_one_1_0.instance.invoke(context, term, is_string_0_0.instance);
      if(term == null)
        break Fail1690;
      i_32760 = term;
      term = k_32760;
      term = collect_one_1_0.instance.invoke(context, term, is_string_0_0.instance);
      if(term == null)
        break Fail1690;
      term = termFactory.makeTuple(i_32760, term);
      term = string_lt_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1690;
      if(true)
        return term;
    }
    return null;
  }
}