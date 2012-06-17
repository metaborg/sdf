package org.strategoxt.imp.editors.template.generated;

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

@SuppressWarnings("all") public class template_section_to_esv_0_0 extends Strategy 
{ 
  public static template_section_to_esv_0_0 instance = new template_section_to_esv_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_section_to_esv_0_0");
    Fail958:
    { 
      IStrategoTerm term405 = term;
      IStrategoConstructor cons22 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success354:
      { 
        if(cons22 == Main._consTemplateSection_1)
        { 
          Fail959:
          { 
            IStrategoTerm v_32760 = null;
            v_32760 = term.getSubterm(0);
            term = filter_1_0.instance.invoke(context, v_32760, template_to_completion_template_0_0.instance);
            if(term == null)
              break Fail959;
            term = termFactory.makeAppl(Main._consCompletions_2, new IStrategoTerm[]{generated.const121, term});
            if(true)
              break Success354;
          }
          term = term405;
        }
        if(cons22 == Main._consSDFSection_1)
        { 
          IStrategoTerm s_32760 = null;
          IStrategoTerm arg349 = term.getSubterm(0);
          if(arg349.getTermType() != IStrategoTerm.APPL || Main._conscontext_free_syntax_1 != ((IStrategoAppl)arg349).getConstructor())
            break Fail958;
          s_32760 = arg349.getSubterm(0);
          term = filter_1_0.instance.invoke(context, s_32760, lifted322.instance);
          if(term == null)
            break Fail958;
          term = termFactory.makeAppl(Main._consCompletions_2, new IStrategoTerm[]{generated.const121, term});
        }
        else
        { 
          break Fail958;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}