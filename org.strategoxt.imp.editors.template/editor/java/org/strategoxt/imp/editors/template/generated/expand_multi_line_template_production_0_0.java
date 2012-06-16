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
    Fail191:
    { 
      IStrategoTerm term191 = term;
      IStrategoConstructor cons15 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success139:
      { 
        if(cons15 == Main._consTemplateProduction_3)
        { 
          Fail192:
          { 
            IStrategoTerm g_9728 = null;
            IStrategoTerm h_9728 = null;
            IStrategoTerm i_9728 = null;
            g_9728 = term.getSubterm(0);
            IStrategoTerm arg248 = term.getSubterm(1);
            if(arg248.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)arg248).getConstructor())
              break Fail192;
            h_9728 = arg248.getSubterm(0);
            i_9728 = term.getSubterm(2);
            term = termFactory.makeAppl(Main._consTemplateProduction_3, new IStrategoTerm[]{g_9728, termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consLine_1, new IStrategoTerm[]{h_9728}), (IStrategoList)generated.constNil0)}), i_9728});
            term = memo_1_0.instance.invoke(context, term, expand_template_production_0_0.instance);
            if(term == null)
              break Fail192;
            if(true)
              break Success139;
          }
          term = term191;
        }
        if(cons15 == Main._consTemplateProduction_3)
        { 
          IStrategoTerm arg250 = term.getSubterm(1);
          if(arg250.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)arg250).getConstructor())
            break Fail191;
          term = memo_1_0.instance.invoke(context, term, expand_template_production_0_0.instance);
          if(term == null)
            break Fail191;
        }
        else
        { 
          break Fail191;
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