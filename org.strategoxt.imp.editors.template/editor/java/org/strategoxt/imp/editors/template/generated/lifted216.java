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

@SuppressWarnings("all") final class lifted216 extends Strategy 
{ 
  TermReference r_9740;

  TermReference s_9740;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail773:
    { 
      if(r_9740.value == null)
        break Fail773;
      term = termFactory.makeTuple(r_9740.value, generated.constTemplateOption0);
      term = resolve_symbol_definition_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail773;
      if(s_9740.value == null)
        s_9740.value = term;
      else
        if(s_9740.value != term && !s_9740.value.match(term))
          break Fail773;
      if(true)
        return term;
    }
    return null;
  }
}