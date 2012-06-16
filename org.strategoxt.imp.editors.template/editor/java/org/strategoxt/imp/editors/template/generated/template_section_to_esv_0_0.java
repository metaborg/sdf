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
    Fail138:
    { 
      IStrategoTerm term149 = term;
      IStrategoConstructor cons10 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success98:
      { 
        if(cons10 == Main._consTemplateSection_1)
        { 
          Fail139:
          { 
            IStrategoTerm m_9722 = null;
            m_9722 = term.getSubterm(0);
            term = filter_1_0.instance.invoke(context, m_9722, template_to_completion_template_0_0.instance);
            if(term == null)
              break Fail139;
            term = termFactory.makeAppl(Main._consCompletions_2, new IStrategoTerm[]{generated.const0, term});
            if(true)
              break Success98;
          }
          term = term149;
        }
        if(cons10 == Main._consSDFSection_1)
        { 
          IStrategoTerm j_9722 = null;
          IStrategoTerm arg196 = term.getSubterm(0);
          if(arg196.getTermType() != IStrategoTerm.APPL || Main._conscontext_free_syntax_1 != ((IStrategoAppl)arg196).getConstructor())
            break Fail138;
          j_9722 = arg196.getSubterm(0);
          term = filter_1_0.instance.invoke(context, j_9722, lifted123.instance);
          if(term == null)
            break Fail138;
          term = termFactory.makeAppl(Main._consCompletions_2, new IStrategoTerm[]{generated.const0, term});
        }
        else
        { 
          break Fail138;
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