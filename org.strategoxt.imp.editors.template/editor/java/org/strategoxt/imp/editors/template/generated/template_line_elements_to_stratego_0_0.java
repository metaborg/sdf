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

@SuppressWarnings("all") public class template_line_elements_to_stratego_0_0 extends Strategy 
{ 
  public static template_line_elements_to_stratego_0_0 instance = new template_line_elements_to_stratego_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("template_line_elements_to_stratego_0_0");
    Fail62:
    { 
      term = map_1_0.instance.invoke(context, term, lifted35.instance);
      if(term == null)
        break Fail62;
      term = concatenate_consecutive_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail62;
      term = filter_1_0.instance.invoke(context, term, template_element_to_stratego_0_0.instance);
      if(term == null)
        break Fail62;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}