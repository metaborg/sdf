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
    Fail105:
    { 
      IStrategoTerm term113 = term;
      Success77:
      { 
        Fail106:
        { 
          IStrategoTerm q_9719 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail106;
          IStrategoTerm arg162 = ((IStrategoList)term).head();
          if(arg162.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg162).getConstructor())
            break Fail106;
          IStrategoTerm arg164 = ((IStrategoList)term).tail();
          if(arg164.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg164).isEmpty())
            break Fail106;
          IStrategoTerm arg165 = ((IStrategoList)arg164).head();
          if(arg165.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg165).getConstructor())
            break Fail106;
          q_9719 = arg165.getSubterm(3);
          IStrategoTerm arg168 = ((IStrategoList)arg164).tail();
          if(arg168.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg168).isEmpty())
            break Fail106;
          term = SRTS_one.instance.invoke(context, q_9719, lifted87.instance);
          if(term == null)
            break Fail106;
          { 
            if(true)
              break Fail105;
            if(true)
              break Success77;
          }
        }
        term = term113;
      }
      term = filter_1_0.instance.invoke(context, term, lifted90.instance);
      if(term == null)
        break Fail105;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}