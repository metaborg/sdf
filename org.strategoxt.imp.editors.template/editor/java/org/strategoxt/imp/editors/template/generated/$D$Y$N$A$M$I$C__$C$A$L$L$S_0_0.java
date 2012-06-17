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
    Fail1379:
    { 
      IStrategoTerm term643 = term;
      Success527:
      { 
        Fail1380:
        { 
          IStrategoTerm h_32796 = null;
          h_32796 = term;
          term = undefine_$Expanded_0_1.instance.invoke(context, h_32796, generated.const121);
          if(term == null)
            break Fail1380;
          if(true)
            break Success527;
        }
        term = term643;
        IStrategoTerm term644 = term;
        Success528:
        { 
          Fail1381:
          { 
            IStrategoTerm f_32796 = null;
            f_32796 = term;
            term = undefine_$Template$Lang$Cached$Option_0_1.instance.invoke(context, f_32796, generated.const121);
            if(term == null)
              break Fail1381;
            if(true)
              break Success528;
          }
          term = term644;
          IStrategoTerm d_32796 = null;
          d_32796 = term;
          term = undefine_$Descriptor$P$P$Table_0_1.instance.invoke(context, d_32796, generated.const121);
          if(term == null)
            break Fail1379;
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