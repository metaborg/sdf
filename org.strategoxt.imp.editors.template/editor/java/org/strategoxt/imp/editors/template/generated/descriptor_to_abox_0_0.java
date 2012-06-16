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

@SuppressWarnings("all") public class descriptor_to_abox_0_0 extends Strategy 
{ 
  public static descriptor_to_abox_0_0 instance = new descriptor_to_abox_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("descriptor_to_abox_0_0");
    Fail354:
    { 
      IStrategoTerm w_9744 = null;
      term = topdown_1_0.instance.invoke(context, term, lifted235.instance);
      if(term == null)
        break Fail354;
      w_9744 = term;
      term = descriptor_pp_table_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail354;
      term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0);
      term = ast2box_0_1.instance.invoke(context, w_9744, term);
      if(term == null)
        break Fail354;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}