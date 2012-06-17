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
    Fail882:
    { 
      IStrategoTerm term307 = term;
      Success302:
      { 
        Fail883:
        { 
          IStrategoTerm h_32752 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)term).getConstructor())
            break Fail883;
          h_32752 = term.getSubterm(0);
          IStrategoTerm term308 = term;
          Success303:
          { 
            Fail884:
            { 
              term = h_32752;
              if(term.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)term).stringValue()))
                break Fail884;
              { 
                if(true)
                  break Fail883;
                if(true)
                  break Success303;
              }
            }
            term = term308;
          }
          term = templatelang_escape_0_0.instance.invoke(context, h_32752);
          if(term == null)
            break Fail883;
          term = double_quote_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail883;
          term = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const131, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil3)});
          if(true)
            break Success302;
        }
        term = term307;
        IStrategoTerm term309 = term;
        Success304:
        { 
          Fail885:
          { 
            IStrategoTerm e_32752 = null;
            TermReference f_32752 = new TermReference();
            IStrategoTerm g_32752 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
              break Fail885;
            IStrategoTerm arg197 = term.getSubterm(1);
            if(arg197.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg197).getConstructor())
              break Fail885;
            IStrategoTerm arg198 = term.getSubterm(2);
            if(arg198.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)arg198).getConstructor())
              break Fail885;
            IStrategoList annos19 = term.getAnnotations();
            if(annos19.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos19).isEmpty())
              break Fail885;
            e_32752 = ((IStrategoList)annos19).head();
            IStrategoTerm arg200 = ((IStrategoList)annos19).tail();
            if(arg200.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg200).isEmpty())
              break Fail885;
            g_32752 = term;
            lifted237 lifted2370 = new lifted237();
            lifted2370.f_32752 = f_32752;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted2370, lifted238.instance);
            if(term == null)
              break Fail885;
            term = g_32752;
            if(f_32752.value == null)
              break Fail885;
            term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{f_32752.value, termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{e_32752})});
            if(true)
              break Success304;
          }
          term = term309;
          IStrategoTerm term310 = term;
          Success305:
          { 
            Fail886:
            { 
              IStrategoTerm a_32752 = null;
              TermReference b_32752 = new TermReference();
              IStrategoTerm c_32752 = null;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
                break Fail886;
              IStrategoTerm arg202 = term.getSubterm(1);
              if(arg202.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg202).getConstructor())
                break Fail886;
              IStrategoTerm arg203 = term.getSubterm(2);
              if(arg203.getTermType() != IStrategoTerm.APPL || Main._consOption_0 != ((IStrategoAppl)arg203).getConstructor())
                break Fail886;
              IStrategoList annos20 = term.getAnnotations();
              if(annos20.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos20).isEmpty())
                break Fail886;
              a_32752 = ((IStrategoList)annos20).head();
              IStrategoTerm arg205 = ((IStrategoList)annos20).tail();
              if(arg205.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg205).isEmpty())
                break Fail886;
              c_32752 = term;
              lifted239 lifted2390 = new lifted239();
              lifted2390.b_32752 = b_32752;
              term = with_spxverify_2_0.instance.invoke(context, term, lifted2390, lifted240.instance);
              if(term == null)
                break Fail886;
              term = c_32752;
              if(b_32752.value == null)
                break Fail886;
              term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar10, (IStrategoTerm)termFactory.makeListCons(b_32752.value, (IStrategoList)generated.constNil3)}), termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{a_32752})});
              if(true)
                break Success305;
            }
            term = term310;
            IStrategoTerm r_32749 = null;
            TermReference s_32749 = new TermReference();
            TermReference t_32749 = new TermReference();
            TermReference u_32749 = new TermReference();
            TermReference v_32749 = new TermReference();
            TermReference w_32749 = new TermReference();
            TermReference x_32749 = new TermReference();
            TermReference y_32749 = new TermReference();
            IStrategoTerm c_32751 = null;
            IStrategoTerm d_32751 = null;
            if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
              break Fail882;
            IStrategoTerm arg207 = term.getSubterm(1);
            if(arg207.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg207).getConstructor())
              break Fail882;
            if(t_32749.value == null)
              t_32749.value = arg207.getSubterm(0);
            else
              if(t_32749.value != arg207.getSubterm(0) && !t_32749.value.match(arg207.getSubterm(0)))
                break Fail882;
            c_32751 = term.getSubterm(2);
            if(s_32749.value == null)
              s_32749.value = term.getSubterm(3);
            else
              if(s_32749.value != term.getSubterm(3) && !s_32749.value.match(term.getSubterm(3)))
                break Fail882;
            IStrategoList annos21 = term.getAnnotations();
            if(annos21.getTermType() != IStrategoTerm.LIST || ((IStrategoList)annos21).isEmpty())
              break Fail882;
            r_32749 = ((IStrategoList)annos21).head();
            IStrategoTerm arg208 = ((IStrategoList)annos21).tail();
            if(arg208.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg208).isEmpty())
              break Fail882;
            term = c_32751;
            IStrategoTerm term311 = term;
            Success306:
            { 
              Fail887:
              { 
                term = $Star_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail887;
                if(true)
                  break Success306;
              }
              term = $Plus_0_0.instance.invoke(context, term311);
              if(term == null)
                break Fail882;
            }
            d_32751 = term;
            lifted241 lifted2410 = new lifted241();
            lifted2410.s_32749 = s_32749;
            lifted2410.t_32749 = t_32749;
            lifted2410.u_32749 = u_32749;
            lifted2410.v_32749 = v_32749;
            lifted2410.w_32749 = w_32749;
            lifted2410.x_32749 = x_32749;
            lifted2410.y_32749 = y_32749;
            term = with_spxverify_2_0.instance.invoke(context, term, lifted2410, lifted246.instance);
            if(term == null)
              break Fail882;
            term = d_32751;
            if(y_32749.value == null)
              break Fail882;
            term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{y_32749.value, termFactory.makeAppl(Main._consVar_1, new IStrategoTerm[]{r_32749})});
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