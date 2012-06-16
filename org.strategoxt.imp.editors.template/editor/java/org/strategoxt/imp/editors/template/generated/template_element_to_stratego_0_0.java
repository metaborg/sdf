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

@SuppressWarnings("all") public class template_element_to_stratego_0_0 extends Strategy 
{ 
  public static template_element_to_stratego_0_0 instance = new template_element_to_stratego_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_element_to_stratego_0_0");
    Fail63:
    { 
      IStrategoTerm term52 = term;
      Success47:
      { 
        Fail64:
        { 
          IStrategoTerm z_9713 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)term).getConstructor())
            break Fail64;
          z_9713 = term.getSubterm(0);
          IStrategoTerm term53 = term;
          Success48:
          { 
            Fail65:
            { 
              term = z_9713;
              if(term.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)term).stringValue()))
                break Fail65;
              { 
                if(true)
                  break Fail64;
                if(true)
                  break Success48;
              }
            }
            term = term53;
          }
          term = templatelang_escape_0_0.instance.invoke(context, z_9713);
          if(term == null)
            break Fail64;
          term = double_quote_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail64;
          term = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const10, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil0)});
          if(true)
            break Success47;
        }
        term = term52;
        IStrategoTerm term54 = term;
        Success49:
        { 
          Fail66:
          { 
            IStrategoTerm w_9713 = null;
            TermReference x_9713 = new TermReference();
            IStrategoTerm y_9713 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
              break Fail66;
            IStrategoTerm arg49 = term.getSubterm(1);
            if(arg49.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg49).getConstructor())
              break Fail66;
            IStrategoTerm arg50 = term.getSubterm(2);
            if(arg50.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg50).getConstructor())
              break Fail66;
            IStrategoList annos1 = term.getAnnotations();
            if(annos1.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos1).isEmpty())
              break Fail66;
            w_9713 = ((IStrategoList)annos1).head();
            IStrategoTerm arg52 = ((IStrategoList)annos1).tail();
            if(arg52.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg52).isEmpty())
              break Fail66;
            y_9713 = term;
            lifted38 lifted380 = new lifted38();
            lifted380.x_9713 = x_9713;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted380, lifted39.instance);
            if(term == null)
              break Fail66;
            term = y_9713;
            if(x_9713.value == null)
              break Fail66;
            term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{x_9713.value, termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{w_9713})});
            if(true)
              break Success49;
          }
          term = term54;
          IStrategoTerm term55 = term;
          Success50:
          { 
            Fail67:
            { 
              IStrategoTerm s_9713 = null;
              TermReference t_9713 = new TermReference();
              IStrategoTerm u_9713 = null;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                break Fail67;
              IStrategoTerm arg54 = term.getSubterm(1);
              if(arg54.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg54).getConstructor())
                break Fail67;
              IStrategoTerm arg55 = term.getSubterm(2);
              if(arg55.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg55).getConstructor())
                break Fail67;
              IStrategoList annos2 = term.getAnnotations();
              if(annos2.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos2).isEmpty())
                break Fail67;
              s_9713 = ((IStrategoList)annos2).head();
              IStrategoTerm arg57 = ((IStrategoList)annos2).tail();
              if(arg57.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg57).isEmpty())
                break Fail67;
              u_9713 = term;
              lifted40 lifted400 = new lifted40();
              lifted400.t_9713 = t_9713;
              term = with_spxverify_2_0.instance.invoke(context, term, lifted400, lifted41.instance);
              if(term == null)
                break Fail67;
              term = u_9713;
              if(t_9713.value == null)
                break Fail67;
              term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar10, (IStrategoTerm)termFactory.makeListCons(t_9713.value, (IStrategoList)generated.constNil0)}), termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{s_9713})});
              if(true)
                break Success50;
            }
            term = term55;
            IStrategoTerm j_9711 = null;
            TermReference k_9711 = new TermReference();
            TermReference l_9711 = new TermReference();
            TermReference m_9711 = new TermReference();
            TermReference n_9711 = new TermReference();
            TermReference o_9711 = new TermReference();
            TermReference p_9711 = new TermReference();
            TermReference q_9711 = new TermReference();
            IStrategoTerm u_9712 = null;
            IStrategoTerm v_9712 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
              break Fail63;
            IStrategoTerm arg59 = term.getSubterm(1);
            if(arg59.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg59).getConstructor())
              break Fail63;
            if(l_9711.value == null)
              l_9711.value = arg59.getSubterm(0);
            else
              if(l_9711.value != arg59.getSubterm(0) && !l_9711.value.match(arg59.getSubterm(0)))
                break Fail63;
            u_9712 = term.getSubterm(2);
            if(k_9711.value == null)
              k_9711.value = term.getSubterm(3);
            else
              if(k_9711.value != term.getSubterm(3) && !k_9711.value.match(term.getSubterm(3)))
                break Fail63;
            IStrategoList annos3 = term.getAnnotations();
            if(annos3.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos3).isEmpty())
              break Fail63;
            j_9711 = ((IStrategoList)annos3).head();
            IStrategoTerm arg60 = ((IStrategoList)annos3).tail();
            if(arg60.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg60).isEmpty())
              break Fail63;
            term = u_9712;
            IStrategoTerm term56 = term;
            Success51:
            { 
              Fail68:
              { 
                term = $Star_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail68;
                if(true)
                  break Success51;
              }
              term = $Plus_0_0.instance.invoke(context, term56);
              if(term == null)
                break Fail63;
            }
            v_9712 = term;
            lifted42 lifted420 = new lifted42();
            lifted420.k_9711 = k_9711;
            lifted420.l_9711 = l_9711;
            lifted420.m_9711 = m_9711;
            lifted420.n_9711 = n_9711;
            lifted420.o_9711 = o_9711;
            lifted420.p_9711 = p_9711;
            lifted420.q_9711 = q_9711;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted420, lifted47.instance);
            if(term == null)
              break Fail63;
            term = v_9712;
            if(q_9711.value == null)
              break Fail63;
            term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{q_9711.value, termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{j_9711})});
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