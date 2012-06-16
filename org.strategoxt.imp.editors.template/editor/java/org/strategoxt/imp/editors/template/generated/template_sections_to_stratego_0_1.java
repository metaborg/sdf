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

@SuppressWarnings("all") public class template_sections_to_stratego_0_1 extends Strategy 
{ 
  public static template_sections_to_stratego_0_1 instance = new template_sections_to_stratego_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm ref_m_9705)
  { 
    TermReference m_9705 = new TermReference(ref_m_9705);
    context.push("template_sections_to_stratego_0_1");
    Fail13:
    { 
      lifted5 lifted510 = new lifted5();
      lifted510.m_9705 = m_9705;
      term = filter_1_0.instance.invoke(context, term, lifted510);
      if(term == null)
        break Fail13;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}