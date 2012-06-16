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

@SuppressWarnings("all") public class chain_$Is$Imported_0_0 extends Strategy 
{ 
  public static chain_$Is$Imported_0_0 instance = new chain_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("chain_IsImported_0_0");
    Fail193:
    { 
      IStrategoTerm k_10735 = null;
      IStrategoTerm n_10735 = null;
      IStrategoTerm p_10735 = null;
      k_10735 = term;
      p_10735 = term;
      Success63:
      { 
        Fail194:
        { 
          IStrategoTerm r_10735 = null;
          r_10735 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, r_10735, trans.const5, k_10735);
          if(term == null)
            break Fail194;
          if(true)
            break Success63;
        }
        term = trans.constNil0;
      }
      n_10735 = term;
      term = p_10735;
      term = termFactory.makeTuple(n_10735, term);
      term = foldl_1_0.instance.invoke(context, term, lifted61.instance);
      if(term == null)
        break Fail193;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}