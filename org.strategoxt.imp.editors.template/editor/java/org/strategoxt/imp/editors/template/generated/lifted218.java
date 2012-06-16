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

@SuppressWarnings("all") final class lifted218 extends Strategy 
{ 
  TermReference z_9740;

  TermReference a_9741;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail771:
    { 
      if(z_9740.value == null || a_9741.value == null)
        break Fail771;
      term = termFactory.makeTuple(z_9740.value, generated.constTemplateOption0, a_9741.value);
      term = index_symbol_definition_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail771;
      if(true)
        return term;
    }
    return null;
  }
}