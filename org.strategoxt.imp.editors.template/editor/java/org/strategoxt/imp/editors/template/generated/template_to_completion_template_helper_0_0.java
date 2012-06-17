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

@SuppressWarnings("all") public class template_to_completion_template_helper_0_0 extends Strategy 
{ 
  public static template_to_completion_template_helper_0_0 instance = new template_to_completion_template_helper_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("template_to_completion_template_helper_0_0");
    Fail967:
    { 
      term = flatten_list_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail967;
      term = concatenate_consecutive_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail967;
      term = map_1_0.instance.invoke(context, term, lifted327.instance);
      if(term == null)
        break Fail967;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}