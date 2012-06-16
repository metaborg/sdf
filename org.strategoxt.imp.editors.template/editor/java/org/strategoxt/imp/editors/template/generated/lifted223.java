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

@SuppressWarnings("all") final class lifted223 extends Strategy 
{ 
  TermReference c_9741;

  TermReference d_9741;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail764:
    { 
      if(c_9741.value == null)
        break Fail764;
      term = explode_string_0_0.instance.invoke(context, c_9741.value);
      if(term == null)
        break Fail764;
      term = un_double_quote_chars_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail764;
      if(d_9741.value == null)
        d_9741.value = term;
      else
        if(d_9741.value != term && !d_9741.value.match(term))
          break Fail764;
      if(d_9741.value == null)
        break Fail764;
      term = termFactory.makeTuple(generated.constTokenize0, d_9741.value);
      term = templatelang_index_option_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail764;
      if(true)
        return term;
    }
    return null;
  }
}