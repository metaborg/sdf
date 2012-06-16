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

@SuppressWarnings("all") final class t_9712 extends Strategy 
{ 
  TermReference l_9711;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail967:
    { 
      IStrategoTerm f_9712 = null;
      IStrategoTerm h_9712 = null;
      IStrategoTerm i_9712 = null;
      if(l_9711.value == null)
        break Fail967;
      term = l_9711.value;
      IStrategoTerm term63 = term;
      Success395:
      { 
        Fail968:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail968;
          if(true)
            break Success395;
        }
        term = term63;
        IStrategoTerm term64 = term;
        Success396:
        { 
          Fail969:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail969;
            if(true)
              break Success396;
          }
          term = term64;
          IStrategoTerm term65 = term;
          Success397:
          { 
            Fail970:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail970;
              if(true)
                break Success397;
            }
            term = term65;
            IStrategoTerm term66 = term;
            Success398:
            { 
              Fail971:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail971;
                if(true)
                  break Success398;
              }
              term = term66;
              IStrategoTerm b_9712 = null;
              IStrategoTerm c_9712 = null;
              IStrategoTerm e_9712 = null;
              b_9712 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail967;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail967;
              c_9712 = ((IStrategoList)term).tail();
              e_9712 = c_9712;
              term = report_failure_0_2.instance.invoke(context, e_9712, generated.const57, b_9712);
              if(term == null)
                break Fail967;
            }
          }
        }
      }
      h_9712 = term;
      f_9712 = generated.const39;
      i_9712 = h_9712;
      term = string_replace_0_2.instance.invoke(context, i_9712, f_9712, generated.const40);
      if(term == null)
        break Fail967;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const41, termFactory.makeListCons(term, (IStrategoList)generated.constNil0));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail967;
      term = termFactory.makeAppl(Main._consCallNoArgs_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0))})});
      if(true)
        return term;
    }
    return null;
  }
}