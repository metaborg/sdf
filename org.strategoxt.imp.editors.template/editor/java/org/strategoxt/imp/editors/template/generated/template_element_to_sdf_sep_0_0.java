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
    Fail107:
    { 
      IStrategoTerm term114 = term;
      IStrategoConstructor cons7 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success78:
      { 
        if(cons7 == Main._consPlaceholder_4)
        { 
          Fail108:
          { 
            IStrategoTerm w_9719 = null;
            IStrategoTerm x_9719 = null;
            IStrategoTerm arg169 = term.getSubterm(1);
            if(arg169.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg169).getConstructor())
              break Fail108;
            w_9719 = arg169.getSubterm(0);
            IStrategoTerm arg170 = term.getSubterm(2);
            if(arg170.getTermType() != IStrategoTerm.APPL || Main._consStar_0 != ((IStrategoAppl)arg170).getConstructor())
              break Fail108;
            x_9719 = term.getSubterm(3);
            term = SRTS_one.instance.invoke(context, x_9719, lifted91.instance);
            if(term == null)
              break Fail108;
            term = termFactory.makeAppl(Main._consiter_star_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{w_9719}), generated.constlit0});
            if(true)
              break Success78;
          }
          term = term114;
        }
        if(cons7 == Main._consPlaceholder_4)
        { 
          IStrategoTerm s_9719 = null;
          IStrategoTerm t_9719 = null;
          IStrategoTerm arg171 = term.getSubterm(1);
          if(arg171.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg171).getConstructor())
            break Fail107;
          s_9719 = arg171.getSubterm(0);
          IStrategoTerm arg172 = term.getSubterm(2);
          if(arg172.getTermType() != IStrategoTerm.APPL || Main._consPlus_0 != ((IStrategoAppl)arg172).getConstructor())
            break Fail107;
          t_9719 = term.getSubterm(3);
          term = SRTS_one.instance.invoke(context, t_9719, lifted94.instance);
          if(term == null)
            break Fail107;
          term = termFactory.makeAppl(Main._consiter_sep_2, new IStrategoTerm[]{termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{s_9719}), generated.constlit0});
        }
        else
        { 
          break Fail107;
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