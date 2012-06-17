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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_32995, Strategy b_32995, Strategy c_32995, Strategy d_32995)
  { 
    context.push("open_wildcard_import_4_0");
    Fail1860:
    { 
      IStrategoTerm d_32994 = null;
      TermReference e_32994 = new TermReference();
      TermReference f_32994 = new TermReference();
      d_32994 = term;
      IStrategoTerm term672 = term;
      Success672:
      { 
        Fail1861:
        { 
          IStrategoTerm g_32994 = null;
          g_32994 = term;
          IStrategoTerm term673 = term;
          Success673:
          { 
            Fail1862:
            { 
              term = d_32994;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consCOMPLETION_1 != ((IStrategoAppl)term).getConstructor())
                break Fail1862;
              { 
                if(true)
                  break Fail1861;
                if(true)
                  break Success673;
              }
            }
            term = term673;
          }
          term = g_32994;
          { 
            term = a_32995.invoke(context, d_32994);
            if(term == null)
              break Fail1860;
            if(e_32994.value == null)
              e_32994.value = term;
            else
              if(e_32994.value != term && !e_32994.value.match(term))
                break Fail1860;
            term = readdir_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1860;
            lifted536 lifted5360 = new lifted536();
            lifted5360.d_32995 = d_32995;
            lifted5360.b_32995 = b_32995;
            lifted5360.c_32995 = c_32995;
            lifted5360.e_32994 = e_32994;
            lifted5360.f_32994 = f_32994;
            term = list_loop_1_0.instance.invoke(context, term, lifted5360);
            if(term == null)
              break Fail1860;
            IStrategoTerm term684 = term;
            Success674:
            { 
              Fail1863:
              { 
                if(f_32994.value == null)
                  break Fail1863;
                term = f_32994.value;
                { 
                  if(true)
                    break Fail1860;
                  if(true)
                    break Success674;
                }
              }
              term = term684;
            }
            if(true)
              break Success672;
          }
        }
        term = term672;
      }
      term = d_32994;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}