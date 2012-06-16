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

@SuppressWarnings("all") final class lifted120 extends Strategy 
{ 
  public static final lifted120 instance = new lifted120();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail869:
    { 
      term = templatelang_escape_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail869;
      term = double_quote_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail869;
      term = termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{term});
      if(true)
        return term;
    }
    return null;
  }
}