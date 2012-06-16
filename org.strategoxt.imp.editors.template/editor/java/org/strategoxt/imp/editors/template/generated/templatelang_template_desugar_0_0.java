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

@SuppressWarnings("all") public class templatelang_template_desugar_0_0 extends Strategy 
{ 
  public static templatelang_template_desugar_0_0 instance = new templatelang_template_desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_template_desugar_0_0");
    Fail265:
    { 
      IStrategoTerm term248 = term;
      Success194:
      { 
        Fail266:
        { 
          TermReference j_9736 = new TermReference();
          TermReference k_9736 = new TermReference();
          IStrategoTerm l_9736 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consSingleLineTemplate_1 != ((IStrategoAppl)term).getConstructor())
            break Fail266;
          if(j_9736.value == null)
            j_9736.value = term.getSubterm(0);
          else
            if(j_9736.value != term.getSubterm(0) && !j_9736.value.match(term.getSubterm(0)))
              break Fail266;
          l_9736 = term;
          lifted181 lifted1810 = new lifted181();
          lifted1810.j_9736 = j_9736;
          lifted1810.k_9736 = k_9736;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted1810);
          if(term == null)
            break Fail266;
          term = l_9736;
          if(k_9736.value == null)
            break Fail266;
          term = termFactory.makeAppl(Main._consSingleLineTemplate_1, new IStrategoTerm[]{k_9736.value});
          if(true)
            break Success194;
        }
        term = term248;
        IStrategoTerm term249 = term;
        Success195:
        { 
          Fail267:
          { 
            TermReference g_9736 = new TermReference();
            TermReference h_9736 = new TermReference();
            IStrategoTerm i_9736 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
              break Fail267;
            IStrategoTerm arg348 = term.getSubterm(0);
            if(arg348.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg348).isEmpty())
              break Fail267;
            IStrategoTerm arg349 = ((IStrategoList)arg348).head();
            if(arg349.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)arg349).getConstructor())
              break Fail267;
            if(g_9736.value == null)
              g_9736.value = arg349.getSubterm(0);
            else
              if(g_9736.value != arg349.getSubterm(0) && !g_9736.value.match(arg349.getSubterm(0)))
                break Fail267;
            IStrategoTerm arg350 = ((IStrategoList)arg348).tail();
            if(arg350.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg350).isEmpty())
              break Fail267;
            i_9736 = term;
            lifted182 lifted1820 = new lifted182();
            lifted1820.g_9736 = g_9736;
            lifted1820.h_9736 = h_9736;
            term = with_spxverify_1_0.instance.invoke(context, term, lifted1820);
            if(term == null)
              break Fail267;
            term = i_9736;
            if(h_9736.value == null)
              break Fail267;
            term = termFactory.makeAppl(Main._consSingleLineTemplate_1, new IStrategoTerm[]{h_9736.value});
            if(true)
              break Success195;
          }
          term = term249;
          TermReference d_9735 = new TermReference();
          TermReference e_9735 = new TermReference();
          TermReference f_9735 = new TermReference();
          IStrategoTerm z_9735 = null;
          IStrategoTerm a_9736 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consTemplate_1 != ((IStrategoAppl)term).getConstructor())
            break Fail265;
          if(e_9735.value == null)
            e_9735.value = term.getSubterm(0);
          else
            if(e_9735.value != term.getSubterm(0) && !e_9735.value.match(term.getSubterm(0)))
              break Fail265;
          z_9735 = term;
          IStrategoTerm term250 = term;
          Success196:
          { 
            Fail268:
            { 
              if(e_9735.value == null)
                break Fail268;
              term = e_9735.value;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail268;
              IStrategoTerm arg352 = ((IStrategoList)term).tail();
              if(arg352.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg352).isEmpty())
                break Fail268;
              { 
                if(true)
                  break Fail265;
                if(true)
                  break Success196;
              }
            }
            term = term250;
          }
          term = z_9735;
          a_9736 = z_9735;
          lifted183 lifted1830 = new lifted183();
          lifted1830.e_9735 = e_9735;
          lifted1830.d_9735 = d_9735;
          lifted1830.f_9735 = f_9735;
          term = with_spxverify_1_0.instance.invoke(context, term, lifted1830);
          if(term == null)
            break Fail265;
          term = a_9736;
          if(f_9735.value == null)
            break Fail265;
          term = termFactory.makeAppl(Main._consTemplate_1, new IStrategoTerm[]{f_9735.value});
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