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

@SuppressWarnings("all") final class b_32751 extends Strategy 
{ 
  TermReference t_32749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1787:
    { 
      IStrategoTerm n_32750 = null;
      IStrategoTerm p_32750 = null;
      IStrategoTerm q_32750 = null;
      if(t_32749.value == null)
        break Fail1787;
      term = t_32749.value;
      IStrategoTerm term318 = term;
      Success651:
      { 
        Fail1788:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1788;
          if(true)
            break Success651;
        }
        term = term318;
        IStrategoTerm term319 = term;
        Success652:
        { 
          Fail1789:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1789;
            if(true)
              break Success652;
          }
          term = term319;
          IStrategoTerm term320 = term;
          Success653:
          { 
            Fail1790:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1790;
              if(true)
                break Success653;
            }
            term = term320;
            IStrategoTerm term321 = term;
            Success654:
            { 
              Fail1791:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1791;
                if(true)
                  break Success654;
              }
              term = term321;
              IStrategoTerm j_32750 = null;
              IStrategoTerm k_32750 = null;
              IStrategoTerm m_32750 = null;
              j_32750 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1787;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1787;
              k_32750 = ((IStrategoList)term).tail();
              m_32750 = k_32750;
              term = report_failure_0_2.instance.invoke(context, m_32750, generated.const178, j_32750);
              if(term == null)
                break Fail1787;
            }
          }
        }
      }
      p_32750 = term;
      n_32750 = generated.const160;
      q_32750 = p_32750;
      term = string_replace_0_2.instance.invoke(context, q_32750, n_32750, generated.const161);
      if(term == null)
        break Fail1787;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const162, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1787;
      term = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3))})});
      if(true)
        return term;
    }
    return null;
  }
}