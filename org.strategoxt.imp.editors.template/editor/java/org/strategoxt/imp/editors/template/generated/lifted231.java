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

@SuppressWarnings("all") final class lifted231 extends Strategy 
{ 
  TermReference a_32749;

  TermReference b_32749;

  TermReference c_32749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1813:
    { 
      if(b_32749.value == null)
        break Fail1813;
      term = termFactory.makeTuple(generated.const170, b_32749.value);
      term = addi_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1813;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3);
      term = implode_string_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1813;
      if(a_32749.value == null)
        a_32749.value = term;
      else
        if(a_32749.value != term && !a_32749.value.match(term))
          break Fail1813;
      if(b_32749.value == null)
        break Fail1813;
      term = inc_0_0.instance.invoke(context, b_32749.value);
      if(term == null)
        break Fail1813;
      if(c_32749.value == null)
        c_32749.value = term;
      else
        if(c_32749.value != term && !c_32749.value.match(term))
          break Fail1813;
      if(true)
        return term;
    }
    return null;
  }
}