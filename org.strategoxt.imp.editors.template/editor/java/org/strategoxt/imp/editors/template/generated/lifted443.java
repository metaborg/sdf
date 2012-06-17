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

@SuppressWarnings("all") final class lifted443 extends Strategy 
{ 
  Strategy f_32787;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1540:
    { 
      IStrategoTerm z_32786 = null;
      IStrategoTerm b_32787 = null;
      IStrategoTerm c_32787 = null;
      term = f_32787.invoke(context, term);
      if(term == null)
        break Fail1540;
      IStrategoTerm term625 = term;
      Success553:
      { 
        Fail1541:
        { 
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1541;
          if(true)
            break Success553;
        }
        term = term625;
        IStrategoTerm term626 = term;
        Success554:
        { 
          Fail1542:
          { 
            term = is_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1542;
            if(true)
              break Success554;
          }
          term = term626;
          IStrategoTerm term627 = term;
          Success555:
          { 
            Fail1543:
            { 
              term = int_to_string_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail1543;
              if(true)
                break Success555;
            }
            term = term627;
            IStrategoTerm term628 = term;
            Success556:
            { 
              Fail1544:
              { 
                term = real_to_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1544;
                if(true)
                  break Success556;
              }
              term = term628;
              IStrategoTerm v_32786 = null;
              IStrategoTerm w_32786 = null;
              IStrategoTerm y_32786 = null;
              v_32786 = term;
              term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
              if(term == null)
                break Fail1540;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1540;
              w_32786 = ((IStrategoList)term).tail();
              y_32786 = w_32786;
              term = report_failure_0_2.instance.invoke(context, y_32786, generated.const260, v_32786);
              if(term == null)
                break Fail1540;
            }
          }
        }
      }
      b_32787 = term;
      z_32786 = generated.const160;
      c_32787 = b_32787;
      term = string_replace_0_2.instance.invoke(context, c_32787, z_32786, generated.const261);
      if(term == null)
        break Fail1540;
      term = (IStrategoTerm)termFactory.makeListCons(generated.const262, termFactory.makeListCons(term, (IStrategoList)generated.constNil3));
      term = concat_strings_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1540;
      term = termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil3));
      if(true)
        return term;
    }
    return null;
  }
}