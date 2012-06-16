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

@SuppressWarnings("all") public class fold_$Is$Imported_1_0 extends Strategy 
{ 
  public static fold_$Is$Imported_1_0 instance = new fold_$Is$Imported_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy q_10734)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_IsImported_1_0");
    Fail189:
    { 
      IStrategoTerm n_10734 = null;
      IStrategoTerm r_10734 = null;
      IStrategoTerm t_10734 = null;
      n_10734 = term;
      t_10734 = term;
      Success61:
      { 
        Fail190:
        { 
          IStrategoTerm v_10734 = null;
          v_10734 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, v_10734, trans.const5, n_10734);
          if(term == null)
            break Fail190;
          if(true)
            break Success61;
        }
        term = trans.constNil0;
      }
      r_10734 = term;
      term = t_10734;
      term = termFactory.makeTuple(r_10734, term);
      term = q_10734.invoke(context, term, lifted59.instance);
      if(term == null)
        break Fail189;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}