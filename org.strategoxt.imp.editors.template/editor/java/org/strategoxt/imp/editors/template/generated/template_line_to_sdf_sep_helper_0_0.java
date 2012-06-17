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

@SuppressWarnings("all") public class template_line_to_sdf_sep_helper_0_0 extends Strategy 
{ 
  public static template_line_to_sdf_sep_helper_0_0 instance = new template_line_to_sdf_sep_helper_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("template_line_to_sdf_sep_helper_0_0");
    Fail924:
    { 
      IStrategoTerm term368 = term;
      Success332:
      { 
        Fail925:
        { 
          IStrategoTerm y_32757 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail925;
          IStrategoTerm arg310 = ((IStrategoList)term).head();
          if(arg310.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg310).getConstructor())
            break Fail925;
          IStrategoTerm arg312 = ((IStrategoList)term).tail();
          if(arg312.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg312).isEmpty())
            break Fail925;
          IStrategoTerm arg313 = ((IStrategoList)arg312).head();
          if(arg313.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg313).getConstructor())
            break Fail925;
          y_32757 = arg313.getSubterm(3);
          IStrategoTerm arg316 = ((IStrategoList)arg312).tail();
          if(arg316.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg316).isEmpty())
            break Fail925;
          term = SRTS_one.instance.invoke(context, y_32757, lifted286.instance);
          if(term == null)
            break Fail925;
          { 
            if(true)
              break Fail924;
            if(true)
              break Success332;
          }
        }
        term = term368;
      }
      term = filter_1_0.instance.invoke(context, term, lifted289.instance);
      if(term == null)
        break Fail924;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}