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

@SuppressWarnings("all") public class template_element_to_sdf_sep_0_0 extends Strategy 
{ 
  public static template_element_to_sdf_sep_0_0 instance = new template_element_to_sdf_sep_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_element_to_sdf_sep_0_0");
    Fail926:
    { 
      IStrategoTerm term369 = term;
      IStrategoConstructor cons19 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success333:
      { 
        if(cons19 == Main._consPlaceholder_4)
        { 
          Fail927:
          { 
            IStrategoTerm e_32758 = null;
            IStrategoTerm f_32758 = null;
            IStrategoTerm arg317 = term.getSubterm(1);
            if(arg317.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg317).getConstructor())
              break Fail927;
            e_32758 = arg317.getSubterm(0);
            IStrategoTerm arg318 = term.getSubterm(2);
            if(arg318.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg318).getConstructor())
              break Fail927;
            f_32758 = term.getSubterm(3);
            term = SRTS_one.instance.invoke(context, f_32758, lifted290.instance);
            if(term == null)
              break Fail927;
            term = termFactory.makeAppl(Main._consiter_star_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{e_32758}), generated.constlit0});
            if(true)
              break Success333;
          }
          term = term369;
        }
        if(cons19 == Main._consPlaceholder_4)
        { 
          IStrategoTerm a_32758 = null;
          IStrategoTerm b_32758 = null;
          IStrategoTerm arg319 = term.getSubterm(1);
          if(arg319.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg319).getConstructor())
            break Fail926;
          a_32758 = arg319.getSubterm(0);
          IStrategoTerm arg320 = term.getSubterm(2);
          if(arg320.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg320).getConstructor())
            break Fail926;
          b_32758 = term.getSubterm(3);
          term = SRTS_one.instance.invoke(context, b_32758, lifted293.instance);
          if(term == null)
            break Fail926;
          term = termFactory.makeAppl(Main._consiter_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{a_32758}), generated.constlit0});
        }
        else
        { 
          break Fail926;
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