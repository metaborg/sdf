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

@SuppressWarnings("all") public class string_edge_tokenize_1_0 extends Strategy 
{ 
  public static string_edge_tokenize_1_0 instance = new string_edge_tokenize_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy p_9741)
  { 
    context.push("string_edge_tokenize_1_0");
    Fail300:
    { 
      term = explode_string_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail300;
      term = edge_tokenize_1_0.instance.invoke(context, term, p_9741);
      if(term == null)
        break Fail300;
      term = map_1_0.instance.invoke(context, term, implode_string_0_0.instance);
      if(term == null)
        break Fail300;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}