package trans;

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
    Fail124:
    { 
      IStrategoTerm term60 = term;
      Success44:
      { 
        Fail125:
        { 
          IStrategoTerm r_10723 = null;
          r_10723 = term;
          term = undefine_$Declaration_0_1.instance.invoke(context, r_10723, trans.const38);
          if(term == null)
            break Fail125;
          if(true)
            break Success44;
        }
        term = term60;
        IStrategoTerm term61 = term;
        Success45:
        { 
          Fail126:
          { 
            IStrategoTerm p_10723 = null;
            p_10723 = term;
            term = undefine_$Current$File_0_1.instance.invoke(context, p_10723, trans.const38);
            if(term == null)
              break Fail126;
            if(true)
              break Success45;
          }
          term = term61;
          IStrategoTerm n_10723 = null;
          n_10723 = term;
          term = undefine_$Is$Imported_0_1.instance.invoke(context, n_10723, trans.const38);
          if(term == null)
            break Fail124;
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