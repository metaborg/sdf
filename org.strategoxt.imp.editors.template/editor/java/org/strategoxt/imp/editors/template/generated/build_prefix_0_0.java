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
    Fail148:
    { 
      IStrategoTerm m_9723 = null;
      IStrategoTerm o_9723 = null;
      IStrategoTerm p_9723 = null;
      IStrategoTerm q_9723 = null;
      IStrategoTerm s_9723 = null;
      IStrategoTerm t_9723 = null;
      term = map_1_0.instance.invoke(context, term, template_element_to_string_0_0.instance);
      if(term == null)
        break Fail148;
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail148;
      o_9723 = term;
      m_9723 = generated.const80;
      p_9723 = o_9723;
      term = string_replace_0_2.instance.invoke(context, p_9723, m_9723, generated.const81);
      if(term == null)
        break Fail148;
      s_9723 = term;
      q_9723 = generated.const82;
      t_9723 = s_9723;
      term = string_replace_0_2.instance.invoke(context, t_9723, q_9723, generated.const81);
      if(term == null)
        break Fail148;
      term = string_as_chars_1_0.instance.invoke(context, term, lifted132.instance);
      if(term == null)
        break Fail148;
      term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{term});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}