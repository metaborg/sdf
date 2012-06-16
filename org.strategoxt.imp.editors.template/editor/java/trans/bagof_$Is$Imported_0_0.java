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

@SuppressWarnings("all") public class bagof_$Is$Imported_0_0 extends Strategy 
{ 
  public static bagof_$Is$Imported_0_0 instance = new bagof_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_IsImported_0_0");
    Fail200:
    { 
      TermReference r_10736 = new TermReference();
      TermReference s_10736 = new TermReference();
      if(s_10736.value == null)
        s_10736.value = term;
      else
        if(s_10736.value != term && !s_10736.value.match(term))
          break Fail200;
      if(r_10736.value == null)
        r_10736.value = term;
      else
        if(r_10736.value != term && !r_10736.value.match(term))
          break Fail200;
      Success66:
      { 
        Fail201:
        { 
          IStrategoTerm w_10736 = null;
          w_10736 = term;
          term = dr_lookup_rule_0_2.instance.invoke(context, w_10736, trans.const5, s_10736.value);
          if(term == null)
            break Fail201;
          if(true)
            break Success66;
        }
        term = trans.constNil0;
      }
      lifted65 lifted650 = new lifted65();
      lifted650.r_10736 = r_10736;
      lifted650.s_10736 = s_10736;
      term = filter_1_0.instance.invoke(context, term, lifted650);
      if(term == null)
        break Fail200;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}