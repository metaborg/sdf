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

@SuppressWarnings("all") public class bigfold_$Is$Imported_1_0 extends Strategy 
{ 
  public static bigfold_$Is$Imported_1_0 instance = new bigfold_$Is$Imported_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_33020)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_IsImported_1_0");
    Fail2035:
    { 
      IStrategoTerm r_33020 = null;
      IStrategoTerm v_33020 = null;
      IStrategoTerm x_33020 = null;
      r_33020 = term;
      x_33020 = term;
      Success731:
      { 
        Fail2036:
        { 
          IStrategoTerm z_33020 = null;
          z_33020 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, z_33020, trans.const275, r_33020);
          if(term == null)
            break Fail2036;
          if(true)
            break Success731;
        }
        term = trans.constNil4;
      }
      v_33020 = term;
      term = x_33020;
      term = termFactory.makeTuple(v_33020, term);
      term = u_33020.invoke(context, term, lifted587.instance);
      if(term == null)
        break Fail2035;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}