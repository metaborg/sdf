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

@SuppressWarnings("all") final class lifted250 extends Strategy 
{ 
  TermReference a_32754;

  TermReference b_32754;

  TermReference c_32754;

  TermReference d_32754;

  TermReference e_32754;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1767:
    { 
      if(a_32754.value == null)
        break Fail1767;
      term = filter_1_0.instance.invoke(context, a_32754.value, lifted251.instance);
      if(term == null)
        break Fail1767;
      if(c_32754.value == null)
        c_32754.value = term;
      else
        if(c_32754.value != term && !c_32754.value.match(term))
          break Fail1767;
      if(b_32754.value == null || (c_32754.value == null || d_32754.value == null))
        break Fail1767;
      term = termFactory.makeTuple(b_32754.value, c_32754.value, d_32754.value);
      term = templatelang_to_signature_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1767;
      if(e_32754.value == null)
        e_32754.value = term;
      else
        if(e_32754.value != term && !e_32754.value.match(term))
          break Fail1767;
      if(true)
        return term;
    }
    return null;
  }
}