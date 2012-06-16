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

@SuppressWarnings("all") public class generate_esv_0_0 extends Strategy 
{ 
  public static generate_esv_0_0 instance = new generate_esv_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_esv_0_0");
    Fail91:
    { 
      IStrategoTerm term49 = term;
      Success33:
      { 
        Fail92:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail92;
          if(true)
            break Success33;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term49);
        if(term == null)
          break Fail91;
      }
      term = template_sections_to_esv_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail91;
      term = termFactory.makeAppl(Main._consModule_3, new IStrategoTerm[]{trans.const27, trans.constNoImports0, term});
      term = topdown_1_0.instance.invoke(context, term, lifted31.instance);
      if(term == null)
        break Fail91;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}