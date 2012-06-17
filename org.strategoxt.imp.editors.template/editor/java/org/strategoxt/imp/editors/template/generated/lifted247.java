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

@SuppressWarnings("all") final class lifted247 extends Strategy 
{ 
  TermReference k_32752;

  TermReference l_32752;

  TermReference m_32752;

  TermReference n_32752;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1770:
    { 
      IStrategoTerm u_32752 = null;
      IStrategoTerm w_32752 = null;
      IStrategoTerm x_32752 = null;
      IStrategoTerm c_32753 = null;
      IStrategoTerm e_32753 = null;
      IStrategoTerm f_32753 = null;
      Success639:
      { 
        Fail1771:
        { 
          if(k_32752.value == null)
            break Fail1771;
          term = SRTS_one.instance.invoke(context, k_32752.value, lifted248.instance);
          if(term == null)
            break Fail1771;
          { 
            term = generated.const147;
            if(true)
              break Success639;
          }
        }
        term = generated.const154;
      }
      IStrategoTerm term326 = term;
      Success640:
      { 
        Fail1772:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1772;
          if(true)
            break Success640;
        }
        term = term326;
        IStrategoTerm term327 = term;
        Success641:
        { 
          Fail1773:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1773;
            if(true)
              break Success641;
          }
          term = term327;
          IStrategoTerm term328 = term;
          Success642:
          { 
            Fail1774:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1774;
              if(true)
                break Success642;
            }
            term = term328;
            IStrategoTerm term329 = term;
            Success643:
            { 
              Fail1775:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1775;
                if(true)
                  break Success643;
              }
              term = term329;
              IStrategoTerm q_32752 = null;
              IStrategoTerm r_32752 = null;
              IStrategoTerm t_32752 = null;
              q_32752 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1770;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1770;
              r_32752 = ((IStrategoList)term).tail();
              t_32752 = r_32752;
              term = report_failure_0_2.instance.invoke(context, t_32752, generated.const180, q_32752);
              if(term == null)
                break Fail1770;
            }
          }
        }
      }
      w_32752 = term;
      u_32752 = generated.const160;
      x_32752 = w_32752;
      term = string_replace_0_2.instance.invoke(context, x_32752, u_32752, generated.const181);
      if(term == null)
        break Fail1770;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const182, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1770;
      term = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3))});
      if(l_32752.value == null)
        l_32752.value = term;
      else
        if(l_32752.value != term && !l_32752.value.match(term))
          break Fail1770;
      if(m_32752.value == null)
        break Fail1770;
      term = m_32752.value;
      IStrategoTerm term330 = term;
      Success644:
      { 
        Fail1776:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1776;
          if(true)
            break Success644;
        }
        term = term330;
        IStrategoTerm term331 = term;
        Success645:
        { 
          Fail1777:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1777;
            if(true)
              break Success645;
          }
          term = term331;
          IStrategoTerm term332 = term;
          Success646:
          { 
            Fail1778:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1778;
              if(true)
                break Success646;
            }
            term = term332;
            IStrategoTerm term333 = term;
            Success647:
            { 
              Fail1779:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1779;
                if(true)
                  break Success647;
              }
              term = term333;
              IStrategoTerm y_32752 = null;
              IStrategoTerm z_32752 = null;
              IStrategoTerm b_32753 = null;
              y_32752 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1770;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1770;
              z_32752 = ((IStrategoList)term).tail();
              b_32753 = z_32752;
              term = report_failure_0_2.instance.invoke(context, b_32753, generated.const180, y_32752);
              if(term == null)
                break Fail1770;
            }
          }
        }
      }
      e_32753 = term;
      c_32753 = generated.const160;
      f_32753 = e_32753;
      term = string_replace_0_2.instance.invoke(context, f_32753, c_32753, generated.const161);
      if(term == null)
        break Fail1770;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1770;
      term = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3))})});
      if(n_32752.value == null)
        n_32752.value = term;
      else
        if(n_32752.value != term && !n_32752.value.match(term))
          break Fail1770;
      if(true)
        return term;
    }
    return null;
  }
}