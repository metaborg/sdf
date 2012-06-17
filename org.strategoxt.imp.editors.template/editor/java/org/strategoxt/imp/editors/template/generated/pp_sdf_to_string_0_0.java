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

@SuppressWarnings("all") public class pp_sdf_to_string_0_0 extends Strategy 
{ 
  public static pp_sdf_to_string_0_0 instance = new pp_sdf_to_string_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("pp_sdf_to_string_0_0");
    Fail1172:
    { 
      IStrategoTerm x_32782 = null;
      IStrategoTerm b_32783 = null;
      term = topdown_1_0.instance.invoke(context, term, lifted431.instance);
      if(term == null)
        break Fail1172;
      term = parenthesize_$Sdf2_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1172;
      term = sdf_ppfix_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1172;
      x_32782 = term;
      term = pp_table_sdf_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1172;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3);
      term = ast2box_0_1.instance.invoke(context, x_32782, term);
      if(term == null)
        break Fail1172;
      b_32783 = term;
      term = box2text_string_0_1.instance.invoke(context, b_32783, generated.const246);
      if(term == null)
        break Fail1172;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}