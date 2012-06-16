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

@SuppressWarnings("all") public class sdf_cons_1_0 extends Strategy 
{ 
  public static sdf_cons_1_0 instance = new sdf_cons_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_9757)
  { 
    context.push("sdf_cons_1_0");
    Fail552:
    { 
      lifted260 lifted2600 = new lifted260();
      lifted2600.n_9757 = n_9757;
      term = term_1_0.instance.invoke(context, term, lifted2600);
      if(term == null)
        break Fail552;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}