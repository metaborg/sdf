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
    Fail956:
    { 
      TermReference m_32760 = new TermReference();
      IStrategoTerm n_32760 = null;
      n_32760 = term;
      term = templatelang_get_option_0_0.instance.invoke(context, generated.constTokenize0);
      if(term == null)
        break Fail956;
      if(m_32760.value == null)
        m_32760.value = term;
      else
        if(m_32760.value != term && !m_32760.value.match(term))
          break Fail956;
      term = n_32760;
      lifted317 lifted3170 = new lifted317();
      lifted3170.m_32760 = m_32760;
      term = string_edge_tokenize_1_0.instance.invoke(context, term, lifted3170);
      if(term == null)
        break Fail956;
      term = map_1_0.instance.invoke(context, term, lifted319.instance);
      if(term == null)
        break Fail956;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}