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

@SuppressWarnings("all") final class lifted415 extends Strategy 
{ 
  TermReference a_32779;

  TermReference b_32779;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1593:
    { 
      if(a_32779.value == null)
        break Fail1593;
      term = termFactory.makeTuple(a_32779.value, generated.constTemplateOption0);
      term = resolve_symbol_definition_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1593;
      if(b_32779.value == null)
        b_32779.value = term;
      else
        if(b_32779.value != term && !b_32779.value.match(term))
          break Fail1593;
      if(true)
        return term;
    }
    return null;
  }
}