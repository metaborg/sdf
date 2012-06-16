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

@SuppressWarnings("all") final class s_9712 extends Strategy 
{ 
  TermReference k_9711;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail972:
    { 
      IStrategoTerm x_9711 = null;
      IStrategoTerm z_9711 = null;
      IStrategoTerm a_9712 = null;
      q_9712 q_97120 = new q_9712();
      q_97120.k_9711 = k_9711;
      term = q_97120.invoke(context, term);
      if(term == null)
        break Fail972;
      IStrategoTerm term59 = term;
      Success399:
      { 
        Fail973:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail973;
          if(true)
            break Success399;
        }
        term = term59;
        IStrategoTerm term60 = term;
        Success400:
        { 
          Fail974:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail974;
            if(true)
              break Success400;
          }
          term = term60;
          IStrategoTerm term61 = term;
          Success401:
          { 
            Fail975:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail975;
              if(true)
                break Success401;
            }
            term = term61;
            IStrategoTerm term62 = term;
            Success402:
            { 
              Fail976:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail976;
                if(true)
                  break Success402;
              }
              term = term62;
              IStrategoTerm t_9711 = null;
              IStrategoTerm u_9711 = null;
              IStrategoTerm w_9711 = null;
              t_9711 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail972;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail972;
              u_9711 = ((IStrategoList)term).tail();
              w_9711 = u_9711;
              term = report_failure_0_2.instance.invoke(context, w_9711, generated.const53, t_9711);
              if(term == null)
                break Fail972;
            }
          }
        }
      }
      z_9711 = term;
      x_9711 = generated.const39;
      a_9712 = z_9711;
      term = string_replace_0_2.instance.invoke(context, a_9712, x_9711, generated.const54);
      if(term == null)
        break Fail972;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const56, termFactory.makeListCons(term, (IStrategoList)generated.constCons60));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail972;
      term = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0))});
      if(true)
        return term;
    }
    return null;
  }
}