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
    Fail1932:
    { 
      IStrategoTerm term715 = term;
      Success699:
      { 
        Fail1933:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1933;
          if(true)
            break Success699;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term715);
        if(term == null)
          break Fail1932;
      }
      term = template_sections_to_esv_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1932;
      term = termFactory.makeAppl(Main._consModule_3, new IStrategoTerm[]{trans.const296, trans.constNoImports0, term});
      term = topdown_1_0.instance.invoke(context, term, lifted561.instance);
      if(term == null)
        break Fail1932;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}