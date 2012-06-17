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

@SuppressWarnings("all") public class template_to_sdf_0_0 extends Strategy 
{ 
  public static template_to_sdf_0_0 instance = new template_to_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("template_to_sdf_0_0");
    Fail909:
    { 
      IStrategoTerm term354 = term;
      Success320:
      { 
        Fail910:
        { 
          TermReference q_32756 = new TermReference();
          TermReference r_32756 = new TermReference();
          IStrategoTerm t_32756 = null;
          IStrategoTerm term355 = term;
          IStrategoConstructor cons18 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
          Success321:
          { 
            if(cons18 == Main._consSingleLineTemplate_1)
            { 
              Fail911:
              { 
                if(q_32756.value == null)
                  q_32756.value = term.getSubterm(0);
                else
                  if(q_32756.value != term.getSubterm(0) && !q_32756.value.match(term.getSubterm(0)))
                    break Fail911;
                if(true)
                  break Success321;
              }
              term = term355;
            }
            if(cons18 == Main._consTemplate_1)
            { 
              IStrategoTerm arg263 = term.getSubterm(0);
              if(arg263.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg263).isEmpty())
                break Fail910;
              IStrategoTerm arg264 = ((IStrategoList)arg263).head();
              if(arg264.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg264).getConstructor())
                break Fail910;
              IStrategoTerm arg265 = arg264.getSubterm(0);
              if(q_32756.value == null)
                q_32756.value = arg265;
              else
                if(q_32756.value != arg265 && !q_32756.value.match(arg265))
                  break Fail910;
              if(arg265.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg265).isEmpty())
                break Fail910;
              IStrategoTerm arg266 = ((IStrategoList)arg265).head();
              if(arg266.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg266).getConstructor())
                break Fail910;
              IStrategoTerm arg268 = ((IStrategoList)arg265).tail();
              if(arg268.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg268).isEmpty())
                break Fail910;
              IStrategoTerm arg269 = ((IStrategoList)arg268).head();
              if(arg269.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg269).getConstructor())
                break Fail910;
              IStrategoTerm arg273 = ((IStrategoList)arg268).tail();
              if(arg273.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg273).isEmpty())
                break Fail910;
              IStrategoTerm arg274 = ((IStrategoList)arg263).tail();
              if(arg274.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg274).isEmpty())
                break Fail910;
            }
            else
            { 
              break Fail910;
            }
          }
          t_32756 = term;
          lifted272 lifted2720 = new lifted272();
          lifted2720.q_32756 = q_32756;
          lifted2720.r_32756 = r_32756;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted2720);
          if(term == null)
            break Fail910;
          term = t_32756;
          if(r_32756.value == null)
            break Fail910;
          term = r_32756.value;
          if(true)
            break Success320;
        }
        term = term354;
        TermReference j_32756 = new TermReference();
        TermReference k_32756 = new TermReference();
        IStrategoTerm l_32756 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
          break Fail909;
        if(j_32756.value == null)
          j_32756.value = term.getSubterm(0);
        else
          if(j_32756.value != term.getSubterm(0) && !j_32756.value.match(term.getSubterm(0)))
            break Fail909;
        l_32756 = term;
        lifted277 lifted2770 = new lifted277();
        lifted2770.j_32756 = j_32756;
        lifted2770.k_32756 = k_32756;
        term = with_spxverify_1_0.instance.invoke(context, term, lifted2770);
        if(term == null)
          break Fail909;
        term = l_32756;
        if(k_32756.value == null)
          break Fail909;
        term = k_32756.value;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}