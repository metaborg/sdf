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

@SuppressWarnings("all") public class generate_sdf_0_0 extends Strategy 
{ 
  public static generate_sdf_0_0 instance = new generate_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("generate_sdf_0_0");
    Fail96:
    { 
      IStrategoTerm term51 = term;
      Success35:
      { 
        Fail97:
        { 
          term = collect_sections_1_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail97;
          if(true)
            break Success35;
        }
        term = collect_sections_2_0_0.instance.invoke(context, term51);
        if(term == null)
          break Fail96;
      }
      term = template_sections_to_sdf_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail96;
      term = list_to_conc_grammars_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail96;
      term = termFactory.makeAppl(Main._consmodule_3, new IStrategoTerm[]{trans.constunparameterized0, trans.constNil0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consexports_1, new IStrategoTerm[]{term}), (IStrategoList)trans.constNil0)});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}