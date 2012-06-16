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

@SuppressWarnings("all") public class string_to_sdf_0_0 extends Strategy 
{ 
  public static string_to_sdf_0_0 instance = new string_to_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("string_to_sdf_0_0");
    Fail136:
    { 
      TermReference d_9722 = new TermReference();
      IStrategoTerm e_9722 = null;
      e_9722 = term;
      term = templatelang_get_option_0_0.instance.invoke(context, generated.constTokenize0);
      if(term == null)
        break Fail136;
      if(d_9722.value == null)
        d_9722.value = term;
      else
        if(d_9722.value != term && !d_9722.value.match(term))
          break Fail136;
      term = e_9722;
      lifted118 lifted1180 = new lifted118();
      lifted1180.d_9722 = d_9722;
      term = string_edge_tokenize_1_0.instance.invoke(context, term, lifted1180);
      if(term == null)
        break Fail136;
      term = map_1_0.instance.invoke(context, term, lifted120.instance);
      if(term == null)
        break Fail136;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}