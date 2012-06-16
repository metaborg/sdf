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
    Fail90:
    { 
      IStrategoTerm term99 = term;
      Success65:
      { 
        Fail91:
        { 
          TermReference i_9718 = new TermReference();
          TermReference j_9718 = new TermReference();
          IStrategoTerm l_9718 = null;
          IStrategoTerm term100 = term;
          IStrategoConstructor cons6 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
          Success66:
          { 
            if(cons6 == Main._consSingleLineTemplate_1)
            { 
              Fail92:
              { 
                if(i_9718.value == null)
                  i_9718.value = term.getSubterm(0);
                else
                  if(i_9718.value != term.getSubterm(0) && !i_9718.value.match(term.getSubterm(0)))
                    break Fail92;
                if(true)
                  break Success66;
              }
              term = term100;
            }
            if(cons6 == Main._consTemplate_1)
            { 
              IStrategoTerm arg115 = term.getSubterm(0);
              if(arg115.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg115).isEmpty())
                break Fail91;
              IStrategoTerm arg116 = ((IStrategoList)arg115).head();
              if(arg116.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg116).getConstructor())
                break Fail91;
              IStrategoTerm arg117 = arg116.getSubterm(0);
              if(i_9718.value == null)
                i_9718.value = arg117;
              else
                if(i_9718.value != arg117 && !i_9718.value.match(arg117))
                  break Fail91;
              if(arg117.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg117).isEmpty())
                break Fail91;
              IStrategoTerm arg118 = ((IStrategoList)arg117).head();
              if(arg118.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg118).getConstructor())
                break Fail91;
              IStrategoTerm arg120 = ((IStrategoList)arg117).tail();
              if(arg120.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg120).isEmpty())
                break Fail91;
              IStrategoTerm arg121 = ((IStrategoList)arg120).head();
              if(arg121.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg121).getConstructor())
                break Fail91;
              IStrategoTerm arg125 = ((IStrategoList)arg120).tail();
              if(arg125.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg125).isEmpty())
                break Fail91;
              IStrategoTerm arg126 = ((IStrategoList)arg115).tail();
              if(arg126.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg126).isEmpty())
                break Fail91;
            }
            else
            { 
              break Fail91;
            }
          }
          l_9718 = term;
          lifted73 lifted730 = new lifted73();
          lifted730.i_9718 = i_9718;
          lifted730.j_9718 = j_9718;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted730);
          if(term == null)
            break Fail91;
          term = l_9718;
          if(j_9718.value == null)
            break Fail91;
          term = j_9718.value;
          if(true)
            break Success65;
        }
        term = term99;
        TermReference b_9718 = new TermReference();
        TermReference c_9718 = new TermReference();
        IStrategoTerm d_9718 = null;
        if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
          break Fail90;
        if(b_9718.value == null)
          b_9718.value = term.getSubterm(0);
        else
          if(b_9718.value != term.getSubterm(0) && !b_9718.value.match(term.getSubterm(0)))
            break Fail90;
        d_9718 = term;
        lifted78 lifted780 = new lifted78();
        lifted780.b_9718 = b_9718;
        lifted780.c_9718 = c_9718;
        term = with_spxverify_1_0.instance.invoke(context, term, lifted780);
        if(term == null)
          break Fail90;
        term = d_9718;
        if(c_9718.value == null)
          break Fail90;
        term = c_9718.value;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}