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

@SuppressWarnings("all") public class $D$Y$N$A$M$I$C__$C$A$L$L$S_0_0 extends Strategy 
{ 
  public static $D$Y$N$A$M$I$C__$C$A$L$L$S_0_0 instance = new $D$Y$N$A$M$I$C__$C$A$L$L$S_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("DYNAMIC__CALLS_0_0");
    Fail559:
    { 
      IStrategoTerm term387 = term;
      Success271:
      { 
        Fail560:
        { 
          IStrategoTerm y_9757 = null;
          y_9757 = term;
          term = undefine_$Expanded_0_1.instance.invoke(context, y_9757, generated.const0);
          if(term == null)
            break Fail560;
          if(true)
            break Success271;
        }
        term = term387;
        IStrategoTerm term388 = term;
        Success272:
        { 
          Fail561:
          { 
            IStrategoTerm w_9757 = null;
            w_9757 = term;
            term = undefine_$Template$Lang$Cached$Option_0_1.instance.invoke(context, w_9757, generated.const0);
            if(term == null)
              break Fail561;
            if(true)
              break Success272;
          }
          term = term388;
          IStrategoTerm u_9757 = null;
          u_9757 = term;
          term = undefine_$Descriptor$P$P$Table_0_1.instance.invoke(context, u_9757, generated.const0);
          if(term == null)
            break Fail559;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}