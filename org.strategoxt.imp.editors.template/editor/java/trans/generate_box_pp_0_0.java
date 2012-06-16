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

@SuppressWarnings("all") public class generate_box_pp_0_0 extends Strategy 
{ 
  public static generate_box_pp_0_0 instance = new generate_box_pp_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_box_pp_0_0");
    Fail101:
    { 
      IStrategoTerm i_10720 = null;
      IStrategoTerm term53 = term;
      Success37:
      { 
        Fail102:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail102;
          if(true)
            break Success37;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term53);
        if(term == null)
          break Fail101;
      }
      i_10720 = term;
      term = template_sections_to_stratego_0_1.instance.invoke(context, i_10720, trans.const27);
      if(term == null)
        break Fail101;
      term = termFactory.makeAppl(Main._consSpecification_1, new IStrategoTerm[]{term});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}