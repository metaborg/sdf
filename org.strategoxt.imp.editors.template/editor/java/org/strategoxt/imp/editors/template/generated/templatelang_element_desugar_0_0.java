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

@SuppressWarnings("all") public class templatelang_element_desugar_0_0 extends Strategy 
{ 
  public static templatelang_element_desugar_0_0 instance = new templatelang_element_desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_element_desugar_0_0");
    Fail1090:
    { 
      IStrategoTerm term511 = term;
      IStrategoConstructor cons33 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success453:
      { 
        if(cons33 == Main._consNoOptions_0)
        { 
          Fail1091:
          { 
            term = generated.constNil3;
            if(true)
              break Success453;
          }
          term = term511;
        }
        Success454:
        { 
          if(cons33 == Main._consOptions_1)
          { 
            Fail1092:
            { 
              IStrategoTerm f_32777 = null;
              f_32777 = term.getSubterm(0);
              term = alltd_1_0.instance.invoke(context, f_32777, lifted400.instance);
              if(term == null)
                break Fail1092;
              if(true)
                break Success454;
            }
            term = term511;
          }
          IStrategoTerm term513 = term;
          Success455:
          { 
            Fail1093:
            { 
              TermReference c_32775 = new TermReference();
              TermReference d_32775 = new TermReference();
              IStrategoTerm e_32776 = null;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consEscape_1 != ((IStrategoAppl)term).getConstructor())
                break Fail1093;
              if(c_32775.value == null)
                c_32775.value = term.getSubterm(0);
              else
                if(c_32775.value != term.getSubterm(0) && !c_32775.value.match(term.getSubterm(0)))
                  break Fail1093;
              e_32776 = term;
              lifted402 lifted4020 = new lifted402();
              lifted4020.c_32775 = c_32775;
              lifted4020.d_32775 = d_32775;
              term = with_spxverify_1_0.instance.invoke(context, term, lifted4020);
              if(term == null)
                break Fail1093;
              term = e_32776;
              if(d_32775.value == null)
                break Fail1093;
              term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{d_32775.value});
              if(true)
                break Success455;
            }
            term = term513;
            TermReference v_32774 = new TermReference();
            TermReference w_32774 = new TermReference();
            IStrategoTerm x_32774 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)term).getConstructor())
              break Fail1090;
            if(v_32774.value == null)
              v_32774.value = term.getSubterm(0);
            else
              if(v_32774.value != term.getSubterm(0) && !v_32774.value.match(term.getSubterm(0)))
                break Fail1090;
            x_32774 = term;
            lifted406 lifted4060 = new lifted406();
            lifted4060.v_32774 = v_32774;
            lifted4060.w_32774 = w_32774;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted4060);
            if(term == null)
              break Fail1090;
            term = x_32774;
            if(w_32774.value == null)
              break Fail1090;
            term = termFactory.makeAppl(Main._consLayout_1, new IStrategoTerm[]{w_32774.value});
          }
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