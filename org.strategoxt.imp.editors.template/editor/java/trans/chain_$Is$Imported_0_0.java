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
    Fail2041:
    { 
      IStrategoTerm a_33022 = null;
      IStrategoTerm d_33022 = null;
      IStrategoTerm f_33022 = null;
      a_33022 = term;
      f_33022 = term;
      Success734:
      { 
        Fail2042:
        { 
          IStrategoTerm h_33022 = null;
          h_33022 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, h_33022, trans.const275, a_33022);
          if(term == null)
            break Fail2042;
          if(true)
            break Success734;
        }
        term = trans.constNil4;
      }
      d_33022 = term;
      term = f_33022;
      term = termFactory.makeTuple(d_33022, term);
      term = foldl_1_0.instance.invoke(context, term, lifted590.instance);
      if(term == null)
        break Fail2041;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}