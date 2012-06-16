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

@SuppressWarnings("all") public class get_template_lines_0_1 extends Strategy 
{ 
  public static get_template_lines_0_1 instance = new get_template_lines_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm ref_o_9732)
  { 
    TermReference o_9732 = new TermReference(ref_o_9732);
    context.push("get_template_lines_0_1");
    Fail239:
    { 
      IStrategoTerm p_9732 = null;
      IStrategoTerm q_9732 = null;
      q_9732 = term;
      p_9732 = generated.const96;
      term = q_9732;
      lifted161 lifted1611 = new lifted161();
      lifted1611.o_9732 = o_9732;
      term = dr_scope_1_1.instance.invoke(context, term, lifted1611, p_9732);
      if(term == null)
        break Fail239;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}