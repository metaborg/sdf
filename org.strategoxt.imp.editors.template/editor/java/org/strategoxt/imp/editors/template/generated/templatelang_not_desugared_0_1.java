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

@SuppressWarnings("all") public class templatelang_not_desugared_0_1 extends Strategy 
{ 
  public static templatelang_not_desugared_0_1 instance = new templatelang_not_desugared_0_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm f_9739)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_not_desugared_0_1");
    Fail277:
    { 
      IStrategoTerm k_9739 = null;
      IStrategoTerm m_9739 = null;
      IStrategoTerm n_9739 = null;
      IStrategoTerm term276 = term;
      IStrategoConstructor cons23 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success201:
      { 
        if(cons23 == Main._consTemplateProduction_3)
        { 
          Fail278:
          { 
            if(true)
              break Success201;
          }
          term = term276;
        }
        Success202:
        { 
          if(cons23 == Main._consTemplateProductionWithCons_3)
          { 
            Fail279:
            { 
              if(true)
                break Success202;
            }
            term = term276;
          }
          Success203:
          { 
            if(cons23 == Main._consSdfProduction_3)
            { 
              Fail280:
              { 
                if(true)
                  break Success203;
              }
              term = term276;
            }
            if(cons23 == Main._consSdfProductionWithCons_3)
            { }
            else
            { 
              break Fail277;
            }
          }
        }
      }
      term = f_9739;
      IStrategoTerm term279 = term;
      Success204:
      { 
        Fail281:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail281;
          if(true)
            break Success204;
        }
        term = term279;
        IStrategoTerm term280 = term;
        Success205:
        { 
          Fail282:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail282;
            if(true)
              break Success205;
          }
          term = term280;
          IStrategoTerm term281 = term;
          Success206:
          { 
            Fail283:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail283;
              if(true)
                break Success206;
            }
            term = term281;
            IStrategoTerm term282 = term;
            Success207:
            { 
              Fail284:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail284;
                if(true)
                  break Success207;
              }
              term = term282;
              IStrategoTerm g_9739 = null;
              IStrategoTerm h_9739 = null;
              IStrategoTerm j_9739 = null;
              g_9739 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail277;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail277;
              h_9739 = ((IStrategoList)term).tail();
              j_9739 = h_9739;
              term = report_failure_0_2.instance.invoke(context, j_9739, generated.const109, g_9739);
              if(term == null)
                break Fail277;
            }
          }
        }
      }
      m_9739 = term;
      k_9739 = generated.const39;
      n_9739 = m_9739;
      term = string_replace_0_2.instance.invoke(context, n_9739, k_9739, generated.const110);
      if(term == null)
        break Fail277;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const112, termFactory.makeListCons(term, (IStrategoList)generated.constCons67));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail277;
      term = termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0));
      term = debug_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail277;
      if(true)
        break Fail277;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}