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

@SuppressWarnings("all") public class pp_fix_string_quotes_0_0 extends Strategy 
{ 
  public static pp_fix_string_quotes_0_0 instance = new pp_fix_string_quotes_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("pp_fix_string_quotes_0_0");
    Fail357:
    { 
      IStrategoTerm term361 = term;
      IStrategoConstructor cons36 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success255:
      { 
        if(cons36 == Main._consString_1)
        { 
          Fail358:
          { 
            IStrategoTerm a_9746 = null;
            IStrategoTerm b_9746 = null;
            IStrategoTerm e_9746 = null;
            IStrategoTerm h_9746 = null;
            a_9746 = term.getSubterm(0);
            e_9746 = term;
            term = a_9746;
            IStrategoTerm term362 = term;
            Success256:
            { 
              Fail359:
              { 
                IStrategoTerm g_9746 = null;
                g_9746 = term;
                term = string_starts_with_0_1.instance.invoke(context, g_9746, generated.const75);
                if(term == null)
                  break Fail359;
                { 
                  if(true)
                    break Fail358;
                  if(true)
                    break Success256;
                }
              }
              term = term362;
            }
            term = e_9746;
            h_9746 = e_9746;
            IStrategoTerm term363 = term;
            Success257:
            { 
              Fail360:
              { 
                term = termFactory.makeTuple(generated.const75, a_9746, generated.const75);
                term = conc_strings_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail360;
                b_9746 = term;
                if(true)
                  break Success257;
              }
              term = term363;
              IStrategoTerm c_9746 = null;
              IStrategoTerm d_9746 = null;
              IStrategoTerm j_9746 = null;
              c_9746 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail358;
              d_9746 = term;
              j_9746 = c_9746;
              term = report_with_failure_0_2.instance.invoke(context, j_9746, generated.const128, d_9746);
              if(term == null)
                break Fail358;
            }
            term = h_9746;
            if(b_9746 == null)
              break Fail358;
            term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{b_9746});
            if(true)
              break Success255;
          }
          term = term361;
        }
        if(cons36 == Main._consPlaceholder_1)
        { 
          IStrategoTerm o_9745 = null;
          IStrategoTerm p_9745 = null;
          IStrategoTerm s_9745 = null;
          IStrategoTerm v_9745 = null;
          o_9745 = term.getSubterm(0);
          s_9745 = term;
          term = o_9745;
          IStrategoTerm term364 = term;
          Success258:
          { 
            Fail361:
            { 
              IStrategoTerm u_9745 = null;
              u_9745 = term;
              term = string_starts_with_0_1.instance.invoke(context, u_9745, generated.const89);
              if(term == null)
                break Fail361;
              { 
                if(true)
                  break Fail357;
                if(true)
                  break Success258;
              }
            }
            term = term364;
          }
          term = s_9745;
          v_9745 = s_9745;
          IStrategoTerm term365 = term;
          Success259:
          { 
            Fail362:
            { 
              term = termFactory.makeTuple(generated.const89, o_9745, generated.const129);
              term = conc_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail362;
              p_9745 = term;
              if(true)
                break Success259;
            }
            term = term365;
            IStrategoTerm q_9745 = null;
            IStrategoTerm r_9745 = null;
            IStrategoTerm x_9745 = null;
            q_9745 = term;
            term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
            if(term == null)
              break Fail357;
            r_9745 = term;
            x_9745 = q_9745;
            term = report_with_failure_0_2.instance.invoke(context, x_9745, generated.const128, r_9745);
            if(term == null)
              break Fail357;
          }
          term = v_9745;
          if(p_9745 == null)
            break Fail357;
          term = termFactory.makeAppl(Main._consPlaceholder_1, new IStrategoTerm[]{p_9745});
        }
        else
        { 
          break Fail357;
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