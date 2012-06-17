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
    Fail1947:
    { 
      IStrategoTerm y_33006 = null;
      IStrategoTerm term724 = term;
      Success708:
      { 
        Fail1948:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1948;
          if(true)
            break Success708;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term724);
        if(term == null)
          break Fail1947;
      }
      y_33006 = term;
      term = template_sections_to_stratego_0_1.instance.invoke(context, y_33006, trans.const296);
      if(term == null)
        break Fail1947;
      term = termFactory.makeAppl(Main._consSpecification_1, new IStrategoTerm[]{term});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}