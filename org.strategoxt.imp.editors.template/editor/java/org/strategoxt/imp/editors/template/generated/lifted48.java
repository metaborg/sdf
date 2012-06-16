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

@SuppressWarnings("all") final class lifted48 extends Strategy 
{ 
  TermReference c_9714;

  TermReference d_9714;

  TermReference e_9714;

  TermReference f_9714;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail950:
    { 
      IStrategoTerm m_9714 = null;
      IStrategoTerm o_9714 = null;
      IStrategoTerm p_9714 = null;
      IStrategoTerm u_9714 = null;
      IStrategoTerm w_9714 = null;
      IStrategoTerm x_9714 = null;
      Success383:
      { 
        Fail951:
        { 
          if(c_9714.value == null)
            break Fail951;
          term = SRTS_one.instance.invoke(context, c_9714.value, lifted49.instance);
          if(term == null)
            break Fail951;
          { 
            term = generated.const26;
            if(true)
              break Success383;
          }
        }
        term = generated.const33;
      }
      IStrategoTerm term71 = term;
      Success384:
      { 
        Fail952:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail952;
          if(true)
            break Success384;
        }
        term = term71;
        IStrategoTerm term72 = term;
        Success385:
        { 
          Fail953:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail953;
            if(true)
              break Success385;
          }
          term = term72;
          IStrategoTerm term73 = term;
          Success386:
          { 
            Fail954:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail954;
              if(true)
                break Success386;
            }
            term = term73;
            IStrategoTerm term74 = term;
            Success387:
            { 
              Fail955:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail955;
                if(true)
                  break Success387;
              }
              term = term74;
              IStrategoTerm i_9714 = null;
              IStrategoTerm j_9714 = null;
              IStrategoTerm l_9714 = null;
              i_9714 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail950;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail950;
              j_9714 = ((IStrategoList)term).tail();
              l_9714 = j_9714;
              term = report_failure_0_2.instance.invoke(context, l_9714, generated.const59, i_9714);
              if(term == null)
                break Fail950;
            }
          }
        }
      }
      o_9714 = term;
      m_9714 = generated.const39;
      p_9714 = o_9714;
      term = string_replace_0_2.instance.invoke(context, p_9714, m_9714, generated.const60);
      if(term == null)
        break Fail950;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const61, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail950;
      term = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0))});
      if(d_9714.value == null)
        d_9714.value = term;
      else
        if(d_9714.value != term && !d_9714.value.match(term))
          break Fail950;
      if(e_9714.value == null)
        break Fail950;
      term = e_9714.value;
      IStrategoTerm term75 = term;
      Success388:
      { 
        Fail956:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail956;
          if(true)
            break Success388;
        }
        term = term75;
        IStrategoTerm term76 = term;
        Success389:
        { 
          Fail957:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail957;
            if(true)
              break Success389;
          }
          term = term76;
          IStrategoTerm term77 = term;
          Success390:
          { 
            Fail958:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail958;
              if(true)
                break Success390;
            }
            term = term77;
            IStrategoTerm term78 = term;
            Success391:
            { 
              Fail959:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail959;
                if(true)
                  break Success391;
              }
              term = term78;
              IStrategoTerm q_9714 = null;
              IStrategoTerm r_9714 = null;
              IStrategoTerm t_9714 = null;
              q_9714 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail950;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail950;
              r_9714 = ((IStrategoList)term).tail();
              t_9714 = r_9714;
              term = report_failure_0_2.instance.invoke(context, t_9714, generated.const59, q_9714);
              if(term == null)
                break Fail950;
            }
          }
        }
      }
      w_9714 = term;
      u_9714 = generated.const39;
      x_9714 = w_9714;
      term = string_replace_0_2.instance.invoke(context, x_9714, u_9714, generated.const40);
      if(term == null)
        break Fail950;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail950;
      term = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0))})});
      if(f_9714.value == null)
        f_9714.value = term;
      else
        if(f_9714.value != term && !f_9714.value.match(term))
          break Fail950;
      if(true)
        return term;
    }
    return null;
  }
}