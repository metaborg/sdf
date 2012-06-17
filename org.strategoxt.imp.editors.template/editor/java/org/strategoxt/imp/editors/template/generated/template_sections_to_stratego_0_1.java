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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm ref_u_32743)
  { 
    TermReference u_32743 = new TermReference(ref_u_32743);
    context.push("template_sections_to_stratego_0_1");
    Fail832:
    { 
      lifted204 lifted2040 = new lifted204();
      lifted2040.u_32743 = u_32743;
      term = filter_1_0.instance.invoke(context, term, lifted2040);
      if(term == null)
        break Fail832;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}