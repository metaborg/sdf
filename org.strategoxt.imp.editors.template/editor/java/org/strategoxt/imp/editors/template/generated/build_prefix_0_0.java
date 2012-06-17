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

@SuppressWarnings("all") public class build_prefix_0_0 extends Strategy 
{ 
  public static build_prefix_0_0 instance = new build_prefix_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("build_prefix_0_0");
    Fail968:
    { 
      IStrategoTerm v_32761 = null;
      IStrategoTerm x_32761 = null;
      IStrategoTerm y_32761 = null;
      IStrategoTerm z_32761 = null;
      IStrategoTerm b_32762 = null;
      IStrategoTerm c_32762 = null;
      term = map_1_0.instance.invoke(context, term, template_element_to_string_0_0.instance);
      if(term == null)
        break Fail968;
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail968;
      x_32761 = term;
      v_32761 = generated.const201;
      y_32761 = x_32761;
      term = string_replace_0_2.instance.invoke(context, y_32761, v_32761, generated.const202);
      if(term == null)
        break Fail968;
      b_32762 = term;
      z_32761 = generated.const203;
      c_32762 = b_32762;
      term = string_replace_0_2.instance.invoke(context, c_32762, z_32761, generated.const202);
      if(term == null)
        break Fail968;
      term = string_as_chars_1_0.instance.invoke(context, term, lifted331.instance);
      if(term == null)
        break Fail968;
      term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{term});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}