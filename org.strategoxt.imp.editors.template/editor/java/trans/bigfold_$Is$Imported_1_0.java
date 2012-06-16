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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy e_10734)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_IsImported_1_0");
    Fail187:
    { 
      IStrategoTerm b_10734 = null;
      IStrategoTerm f_10734 = null;
      IStrategoTerm h_10734 = null;
      b_10734 = term;
      h_10734 = term;
      Success60:
      { 
        Fail188:
        { 
          IStrategoTerm j_10734 = null;
          j_10734 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, j_10734, trans.const5, b_10734);
          if(term == null)
            break Fail188;
          if(true)
            break Success60;
        }
        term = trans.constNil0;
      }
      f_10734 = term;
      term = h_10734;
      term = termFactory.makeTuple(f_10734, term);
      term = e_10734.invoke(context, term, lifted58.instance);
      if(term == null)
        break Fail187;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}