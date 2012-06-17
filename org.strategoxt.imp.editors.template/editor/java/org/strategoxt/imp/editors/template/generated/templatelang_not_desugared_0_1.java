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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, IStrategoTerm o_32777)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_not_desugared_0_1");
    Fail1097:
    { 
      IStrategoTerm t_32777 = null;
      IStrategoTerm v_32777 = null;
      IStrategoTerm w_32777 = null;
      IStrategoTerm term532 = term;
      IStrategoConstructor cons35 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success457:
      { 
        if(cons35 == Main._consTemplateProduction_3)
        { 
          Fail1098:
          { 
            if(true)
              break Success457;
          }
          term = term532;
        }
        Success458:
        { 
          if(cons35 == Main._consTemplateProductionWithCons_3)
          { 
            Fail1099:
            { 
              if(true)
                break Success458;
            }
            term = term532;
          }
          Success459:
          { 
            if(cons35 == Main._consSdfProduction_3)
            { 
              Fail1100:
              { 
                if(true)
                  break Success459;
              }
              term = term532;
            }
            if(cons35 == Main._consSdfProductionWithCons_3)
            { }
            else
            { 
              break Fail1097;
            }
          }
        }
      }
      term = o_32777;
      IStrategoTerm term535 = term;
      Success460:
      { 
        Fail1101:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1101;
          if(true)
            break Success460;
        }
        term = term535;
        IStrategoTerm term536 = term;
        Success461:
        { 
          Fail1102:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1102;
            if(true)
              break Success461;
          }
          term = term536;
          IStrategoTerm term537 = term;
          Success462:
          { 
            Fail1103:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1103;
              if(true)
                break Success462;
            }
            term = term537;
            IStrategoTerm term538 = term;
            Success463:
            { 
              Fail1104:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1104;
                if(true)
                  break Success463;
              }
              term = term538;
              IStrategoTerm p_32777 = null;
              IStrategoTerm q_32777 = null;
              IStrategoTerm s_32777 = null;
              p_32777 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1097;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1097;
              q_32777 = ((IStrategoList)term).tail();
              s_32777 = q_32777;
              term = report_failure_0_2.instance.invoke(context, s_32777, generated.const230, p_32777);
              if(term == null)
                break Fail1097;
            }
          }
        }
      }
      v_32777 = term;
      t_32777 = generated.const160;
      w_32777 = v_32777;
      term = string_replace_0_2.instance.invoke(context, w_32777, t_32777, generated.const231);
      if(term == null)
        break Fail1097;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const233, termFactory.makeListCons(term, (IStrategoList)generated.constCons80));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1097;
      term = termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3));
      term = debug_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1097;
      if(true)
        break Fail1097;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}