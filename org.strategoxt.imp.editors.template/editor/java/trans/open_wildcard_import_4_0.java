package trans;

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

@SuppressWarnings("all") public class open_wildcard_import_4_0 extends Strategy 
{ 
  public static open_wildcard_import_4_0 instance = new open_wildcard_import_4_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_10709, Strategy o_10709, Strategy p_10709, Strategy q_10709)
  { 
    context.push("open_wildcard_import_4_0");
    Fail19:
    { 
      IStrategoTerm q_10708 = null;
      TermReference r_10708 = new TermReference();
      TermReference s_10708 = new TermReference();
      q_10708 = term;
      IStrategoTerm term6 = term;
      Success6:
      { 
        Fail20:
        { 
          IStrategoTerm t_10708 = null;
          t_10708 = term;
          IStrategoTerm term7 = term;
          Success7:
          { 
            Fail21:
            { 
              term = q_10708;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consCOMPLETION_1 != ((IStrategoAppl)term).getConstructor())
                break Fail21;
              { 
                if(true)
                  break Fail20;
                if(true)
                  break Success7;
              }
            }
            term = term7;
          }
          term = t_10708;
          { 
            term = n_10709.invoke(context, q_10708);
            if(term == null)
              break Fail19;
            if(r_10708.value == null)
              r_10708.value = term;
            else
              if(r_10708.value != term && !r_10708.value.match(term))
                break Fail19;
            term = readdir_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail19;
            lifted6 lifted67 = new lifted6();
            lifted67.q_10709 = q_10709;
            lifted67.o_10709 = o_10709;
            lifted67.p_10709 = p_10709;
            lifted67.r_10708 = r_10708;
            lifted67.s_10708 = s_10708;
            term = list_loop_1_0.instance.invoke(context, term, lifted67);
            if(term == null)
              break Fail19;
            IStrategoTerm term18 = term;
            Success8:
            { 
              Fail22:
              { 
                if(s_10708.value == null)
                  break Fail22;
                term = s_10708.value;
                { 
                  if(true)
                    break Fail19;
                  if(true)
                    break Success8;
                }
              }
              term = term18;
            }
            if(true)
              break Success6;
          }
        }
        term = term6;
      }
      term = q_10708;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}