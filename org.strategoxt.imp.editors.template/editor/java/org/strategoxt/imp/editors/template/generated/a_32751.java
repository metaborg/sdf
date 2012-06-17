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

@SuppressWarnings("all") final class a_32751 extends Strategy 
{ 
  TermReference s_32749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1792:
    { 
      IStrategoTerm f_32750 = null;
      IStrategoTerm h_32750 = null;
      IStrategoTerm i_32750 = null;
      y_32750 y_327500 = new y_32750();
      y_327500.s_32749 = s_32749;
      term = y_327500.invoke(context, term);
      if(term == null)
        break Fail1792;
      IStrategoTerm term314 = term;
      Success655:
      { 
        Fail1793:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1793;
          if(true)
            break Success655;
        }
        term = term314;
        IStrategoTerm term315 = term;
        Success656:
        { 
          Fail1794:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1794;
            if(true)
              break Success656;
          }
          term = term315;
          IStrategoTerm term316 = term;
          Success657:
          { 
            Fail1795:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1795;
              if(true)
                break Success657;
            }
            term = term316;
            IStrategoTerm term317 = term;
            Success658:
            { 
              Fail1796:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1796;
                if(true)
                  break Success658;
              }
              term = term317;
              IStrategoTerm b_32750 = null;
              IStrategoTerm c_32750 = null;
              IStrategoTerm e_32750 = null;
              b_32750 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1792;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1792;
              c_32750 = ((IStrategoList)term).tail();
              e_32750 = c_32750;
              term = report_failure_0_2.instance.invoke(context, e_32750, generated.const174, b_32750);
              if(term == null)
                break Fail1792;
            }
          }
        }
      }
      h_32750 = term;
      f_32750 = generated.const160;
      i_32750 = h_32750;
      term = string_replace_0_2.instance.invoke(context, i_32750, f_32750, generated.const175);
      if(term == null)
        break Fail1792;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const177, termFactory.makeListCons(term, (IStrategoList)generated.constCons73));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1792;
      term = termFactory.makeAppl(Main._consSVar_1, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3))});
      if(true)
        return term;
    }
    return null;
  }
}