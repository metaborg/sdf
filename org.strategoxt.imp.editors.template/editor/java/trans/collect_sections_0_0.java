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

@SuppressWarnings("all") public class collect_sections_0_0 extends Strategy 
{ 
  public static collect_sections_0_0 instance = new collect_sections_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("collect_sections_0_0");
    Fail85:
    { 
      IStrategoTerm term45 = term;
      Success31:
      { 
        Fail86:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail86;
          if(true)
            break Success31;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term45);
        if(term == null)
          break Fail85;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}