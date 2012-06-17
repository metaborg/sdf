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
    Fail1972:
    { 
      IStrategoTerm term731 = term;
      Success715:
      { 
        Fail1973:
        { 
          IStrategoTerm h_33010 = null;
          h_33010 = term;
          term = undefine_$Declaration_0_1.instance.invoke(context, h_33010, trans.const310);
          if(term == null)
            break Fail1973;
          if(true)
            break Success715;
        }
        term = term731;
        IStrategoTerm term732 = term;
        Success716:
        { 
          Fail1974:
          { 
            IStrategoTerm f_33010 = null;
            f_33010 = term;
            term = undefine_$Current$File_0_1.instance.invoke(context, f_33010, trans.const310);
            if(term == null)
              break Fail1974;
            if(true)
              break Success716;
          }
          term = term732;
          IStrategoTerm d_33010 = null;
          d_33010 = term;
          term = undefine_$Is$Imported_0_1.instance.invoke(context, d_33010, trans.const310);
          if(term == null)
            break Fail1972;
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