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
    Fail352:
    { 
      IStrategoTerm o_9744 = null;
      IStrategoTerm s_9744 = null;
      term = topdown_1_0.instance.invoke(context, term, lifted232.instance);
      if(term == null)
        break Fail352;
      term = parenthesize_$Sdf2_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail352;
      term = sdf_ppfix_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail352;
      o_9744 = term;
      term = pp_table_sdf_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail352;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0);
      term = ast2box_0_1.instance.invoke(context, o_9744, term);
      if(term == null)
        break Fail352;
      s_9744 = term;
      term = box2text_string_0_1.instance.invoke(context, s_9744, generated.const125);
      if(term == null)
        break Fail352;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}