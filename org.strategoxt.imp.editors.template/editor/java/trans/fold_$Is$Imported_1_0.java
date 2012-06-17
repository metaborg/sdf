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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy g_33021)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_IsImported_1_0");
    Fail2037:
    { 
      IStrategoTerm d_33021 = null;
      IStrategoTerm h_33021 = null;
      IStrategoTerm j_33021 = null;
      d_33021 = term;
      j_33021 = term;
      Success732:
      { 
        Fail2038:
        { 
          IStrategoTerm l_33021 = null;
          l_33021 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, l_33021, trans.const275, d_33021);
          if(term == null)
            break Fail2038;
          if(true)
            break Success732;
        }
        term = trans.constNil4;
      }
      h_33021 = term;
      term = j_33021;
      term = termFactory.makeTuple(h_33021, term);
      term = g_33021.invoke(context, term, lifted588.instance);
      if(term == null)
        break Fail2037;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}