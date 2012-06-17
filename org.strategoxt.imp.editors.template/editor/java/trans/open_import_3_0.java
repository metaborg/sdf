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

@SuppressWarnings("all") public class open_import_3_0 extends Strategy 
{ 
  public static open_import_3_0 instance = new open_import_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_32993, Strategy o_32993, Strategy p_32993)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("open_import_3_0");
    Fail1853:
    { 
      IStrategoTerm c_32993 = null;
      IStrategoTerm d_32993 = null;
      TermReference e_32993 = new TermReference();
      TermReference f_32993 = new TermReference();
      c_32993 = term;
      IStrategoTerm term666 = term;
      Success666:
      { 
        Fail1854:
        { 
          IStrategoTerm g_32993 = null;
          g_32993 = term;
          IStrategoTerm term667 = term;
          Success667:
          { 
            Fail1855:
            { 
              term = c_32993;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consCOMPLETION_1 != ((IStrategoAppl)term).getConstructor())
                break Fail1855;
              { 
                if(true)
                  break Fail1854;
                if(true)
                  break Success667;
              }
            }
            term = term667;
          }
          term = g_32993;
          { 
            term = n_32993.invoke(context, c_32993);
            if(term == null)
              break Fail1853;
            if(e_32993.value == null)
              e_32993.value = term;
            else
              if(e_32993.value != term && !e_32993.value.match(term))
                break Fail1853;
            if(e_32993.value == null)
              break Fail1853;
            term = import_cache_path_0_0.instance.invoke(context, e_32993.value);
            if(term == null)
              break Fail1853;
            d_32993 = term;
            IStrategoTerm term668 = term;
            Success668:
            { 
              Fail1856:
              { 
                IStrategoTerm h_32993 = null;
                h_32993 = term;
                IStrategoTerm term669 = term;
                Success669:
                { 
                  Fail1857:
                  { 
                    if(e_32993.value == null)
                      break Fail1857;
                    term = $Is$Imported_0_0.instance.invoke(context, e_32993.value);
                    if(term == null)
                      break Fail1857;
                    { 
                      if(true)
                        break Fail1856;
                      if(true)
                        break Success669;
                    }
                  }
                  term = term669;
                }
                term = h_32993;
                { 
                  IStrategoTerm i_32993 = null;
                  IStrategoTerm r_32993 = null;
                  IStrategoTerm t_32993 = null;
                  IStrategoTerm u_32993 = null;
                  IStrategoTerm v_32993 = null;
                  IStrategoTerm w_32993 = null;
                  i_32993 = term;
                  t_32993 = term;
                  r_32993 = trans.const275;
                  term = t_32993;
                  u_32993 = t_32993;
                  if(e_32993.value == null)
                    break Fail1853;
                  term = termFactory.makeTuple(trans.const276, e_32993.value);
                  term = dr_set_rule_0_3.instance.invoke(context, u_32993, r_32993, e_32993.value, term);
                  if(term == null)
                    break Fail1853;
                  term = i_32993;
                  IStrategoTerm term670 = term;
                  Success670:
                  { 
                    Fail1858:
                    { 
                      if(e_32993.value == null)
                        break Fail1858;
                      term = termFactory.makeTuple(d_32993, e_32993.value);
                      term = is_newer_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail1858;
                      term = $Read$From$File_0_0.instance.invoke(context, d_32993);
                      if(term == null)
                        break Fail1858;
                      if(f_32993.value == null)
                        f_32993.value = term;
                      else
                        if(f_32993.value != term && !f_32993.value.match(term))
                          break Fail1858;
                      if(true)
                        break Success670;
                    }
                    term = term670;
                    if(e_32993.value == null)
                      break Fail1853;
                    term = o_32993.invoke(context, e_32993.value);
                    if(term == null)
                      break Fail1853;
                    if(f_32993.value == null)
                      f_32993.value = term;
                    else
                      if(f_32993.value != term && !f_32993.value.match(term))
                        break Fail1853;
                    IStrategoTerm term671 = term;
                    Success671:
                    { 
                      Fail1859:
                      { 
                        IStrategoTerm j_32993 = null;
                        j_32993 = term;
                        if(e_32993.value == null)
                          break Fail1859;
                        term = file_exists_0_0.instance.invoke(context, e_32993.value);
                        if(term == null)
                          break Fail1859;
                        term = j_32993;
                        { 
                          if(f_32993.value == null)
                            break Fail1853;
                          term = termFactory.makeTuple(d_32993, f_32993.value);
                          term = $Write$To$Binary$File_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail1853;
                          if(true)
                            break Success671;
                        }
                      }
                      term = term671;
                    }
                  }
                  w_32993 = term;
                  v_32993 = trans.const273;
                  term = w_32993;
                  lifted535 lifted5350 = new lifted535();
                  lifted5350.p_32993 = p_32993;
                  lifted5350.e_32993 = e_32993;
                  lifted5350.f_32993 = f_32993;
                  term = dr_scope_1_1.instance.invoke(context, term, lifted5350, v_32993);
                  if(term == null)
                    break Fail1853;
                  if(true)
                    break Success668;
                }
              }
              term = term668;
            }
            if(true)
              break Success666;
          }
        }
        term = term666;
      }
      term = c_32993;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}