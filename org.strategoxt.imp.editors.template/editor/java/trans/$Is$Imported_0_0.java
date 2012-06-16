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

@SuppressWarnings("all") public class $Is$Imported_0_0 extends Strategy 
{ 
  public static $Is$Imported_0_0 instance = new $Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("IsImported_0_0");
    Fail202:
    { 
      TermReference x_10736 = new TermReference();
      TermReference y_10736 = new TermReference();
      IStrategoTerm c_10737 = null;
      if(y_10736.value == null)
        y_10736.value = term;
      else
        if(y_10736.value != term && !y_10736.value.match(term))
          break Fail202;
      if(x_10736.value == null)
        x_10736.value = term;
      else
        if(x_10736.value != term && !x_10736.value.match(term))
          break Fail202;
      c_10737 = term;
      term = dr_lookup_rule_0_2.instance.invoke(context, c_10737, trans.const5, y_10736.value);
      if(term == null)
        break Fail202;
      lifted66 lifted660 = new lifted66();
      lifted660.x_10736 = x_10736;
      lifted660.y_10736 = y_10736;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted660);
      if(term == null)
        break Fail202;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}