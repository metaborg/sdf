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

@SuppressWarnings("all") public class bigchain_$Is$Imported_0_0 extends Strategy 
{ 
  public static bigchain_$Is$Imported_0_0 instance = new bigchain_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_IsImported_0_0");
    Fail2039:
    { 
      IStrategoTerm p_33021 = null;
      IStrategoTerm s_33021 = null;
      IStrategoTerm u_33021 = null;
      p_33021 = term;
      u_33021 = term;
      Success733:
      { 
        Fail2040:
        { 
          IStrategoTerm w_33021 = null;
          w_33021 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, w_33021, trans.const275, p_33021);
          if(term == null)
            break Fail2040;
          if(true)
            break Success733;
        }
        term = trans.constNil4;
      }
      s_33021 = term;
      term = u_33021;
      term = termFactory.makeTuple(s_33021, term);
      term = foldl_1_0.instance.invoke(context, term, lifted589.instance);
      if(term == null)
        break Fail2039;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}