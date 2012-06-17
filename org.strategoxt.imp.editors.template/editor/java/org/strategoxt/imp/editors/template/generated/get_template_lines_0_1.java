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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm ref_x_32770)
  { 
    TermReference x_32770 = new TermReference(ref_x_32770);
    context.push("get_template_lines_0_1");
    Fail1059:
    { 
      IStrategoTerm y_32770 = null;
      IStrategoTerm z_32770 = null;
      z_32770 = term;
      y_32770 = generated.const217;
      term = z_32770;
      lifted360 lifted3600 = new lifted360();
      lifted3600.x_32770 = x_32770;
      term = dr_scope_1_1.instance.invoke(context, term, lifted3600, y_32770);
      if(term == null)
        break Fail1059;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}