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

@SuppressWarnings("all") public class pp_descriptor_to_string_0_0 extends Strategy 
{ 
  public static pp_descriptor_to_string_0_0 instance = new pp_descriptor_to_string_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("pp_descriptor_to_string_0_0");
    Fail353:
    { 
      IStrategoTerm u_9744 = null;
      term = descriptor_to_abox_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail353;
      u_9744 = term;
      term = box2text_string_0_1.instance.invoke(context, u_9744, generated.const125);
      if(term == null)
        break Fail353;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}