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

@SuppressWarnings("all") public class expand_multi_line_template_production_0_0 extends Strategy 
{ 
  public static expand_multi_line_template_production_0_0 instance = new expand_multi_line_template_production_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("expand_multi_line_template_production_0_0");
    Fail1011:
    { 
      IStrategoTerm term447 = term;
      IStrategoConstructor cons27 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success395:
      { 
        if(cons27 == Main._consTemplateProduction_3)
        { 
          Fail1012:
          { 
            IStrategoTerm p_32766 = null;
            IStrategoTerm q_32766 = null;
            IStrategoTerm r_32766 = null;
            p_32766 = term.getSubterm(0);
            IStrategoTerm arg401 = term.getSubterm(1);
            if(arg401.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg401).getConstructor())
              break Fail1012;
            q_32766 = arg401.getSubterm(0);
            r_32766 = term.getSubterm(2);
            term = termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{p_32766, termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{q_32766}), (IStrategoList)generated.constNil3)}), r_32766});
            term = memo_1_0.instance.invoke(context, term, expand_template_production_0_0.instance);
            if(term == null)
              break Fail1012;
            if(true)
              break Success395;
          }
          term = term447;
        }
        if(cons27 == Main._consTemplateProduction_3)
        { 
          IStrategoTerm arg403 = term.getSubterm(1);
          if(arg403.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg403).getConstructor())
            break Fail1011;
          term = memo_1_0.instance.invoke(context, term, expand_template_production_0_0.instance);
          if(term == null)
            break Fail1011;
        }
        else
        { 
          break Fail1011;
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