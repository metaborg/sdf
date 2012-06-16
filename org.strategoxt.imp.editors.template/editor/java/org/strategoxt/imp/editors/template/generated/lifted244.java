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

@SuppressWarnings("all") final class lifted244 extends Strategy 
{ 
  Strategy w_9748;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail720:
    { 
      IStrategoTerm q_9748 = null;
      IStrategoTerm s_9748 = null;
      IStrategoTerm t_9748 = null;
      term = w_9748.invoke(context, term);
      if(term == null)
        break Fail720;
      IStrategoTerm term369 = term;
      Success297:
      { 
        Fail721:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail721;
          if(true)
            break Success297;
        }
        term = term369;
        IStrategoTerm term370 = term;
        Success298:
        { 
          Fail722:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail722;
            if(true)
              break Success298;
          }
          term = term370;
          IStrategoTerm term371 = term;
          Success299:
          { 
            Fail723:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail723;
              if(true)
                break Success299;
            }
            term = term371;
            IStrategoTerm term372 = term;
            Success300:
            { 
              Fail724:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail724;
                if(true)
                  break Success300;
              }
              term = term372;
              IStrategoTerm m_9748 = null;
              IStrategoTerm n_9748 = null;
              IStrategoTerm p_9748 = null;
              m_9748 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail720;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail720;
              n_9748 = ((IStrategoList)term).tail();
              p_9748 = n_9748;
              term = report_failure_0_2.instance.invoke(context, p_9748, generated.const139, m_9748);
              if(term == null)
                break Fail720;
            }
          }
        }
      }
      s_9748 = term;
      q_9748 = generated.const39;
      t_9748 = s_9748;
      term = string_replace_0_2.instance.invoke(context, t_9748, q_9748, generated.const140);
      if(term == null)
        break Fail720;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const141, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail720;
      term = termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0));
      if(true)
        return term;
    }
    return null;
  }
}