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

@SuppressWarnings("all") public class sort_to_contentcomplete_0_0 extends Strategy 
{ 
  public static sort_to_contentcomplete_0_0 instance = new sort_to_contentcomplete_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("sort_to_contentcomplete_0_0");
    Fail130:
    { 
      IStrategoTerm k_9721 = null;
      IStrategoTerm q_9721 = null;
      IStrategoTerm s_9721 = null;
      IStrategoTerm t_9721 = null;
      k_9721 = term;
      term = k_9721;
      IStrategoTerm term145 = term;
      Success94:
      { 
        Fail131:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail131;
          if(true)
            break Success94;
        }
        term = term145;
        IStrategoTerm term146 = term;
        Success95:
        { 
          Fail132:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail132;
            if(true)
              break Success95;
          }
          term = term146;
          IStrategoTerm term147 = term;
          Success96:
          { 
            Fail133:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail133;
              if(true)
                break Success96;
            }
            term = term147;
            IStrategoTerm term148 = term;
            Success97:
            { 
              Fail134:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail134;
                if(true)
                  break Success97;
              }
              term = term148;
              IStrategoTerm m_9721 = null;
              IStrategoTerm n_9721 = null;
              IStrategoTerm p_9721 = null;
              m_9721 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail130;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail130;
              n_9721 = ((IStrategoList)term).tail();
              p_9721 = n_9721;
              term = report_failure_0_2.instance.invoke(context, p_9721, generated.const74, m_9721);
              if(term == null)
                break Fail130;
            }
          }
        }
      }
      s_9721 = term;
      q_9721 = generated.const39;
      t_9721 = s_9721;
      term = string_replace_0_2.instance.invoke(context, t_9721, q_9721, generated.const40);
      if(term == null)
        break Fail130;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const76, termFactory.makeListCons(term, (IStrategoList)generated.constCons62));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail130;
      term = termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0));
      term = termFactory.makeAppl(Main._consprod_3, new IStrategoTerm[]{generated.constCons63, termFactory.makeAppl(Main._conssort_1, new IStrategoTerm[]{k_9721}), termFactory.makeAppl(Main._consattrs_1, new IStrategoTerm[]{(IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consterm_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consdefault_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consappl_2, new IStrategoTerm[]{generated.constunquoted0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consfun_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil0)})})}), (IStrategoList)generated.constNil0)})});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}