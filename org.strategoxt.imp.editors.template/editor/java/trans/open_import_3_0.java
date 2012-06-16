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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_10708, Strategy b_10708, Strategy c_10708)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("open_import_3_0");
    Fail12:
    { 
      IStrategoTerm p_10707 = null;
      IStrategoTerm q_10707 = null;
      TermReference r_10707 = new TermReference();
      TermReference s_10707 = new TermReference();
      p_10707 = term;
      IStrategoTerm term0 = term;
      Success0:
      { 
        Fail13:
        { 
          IStrategoTerm t_10707 = null;
          t_10707 = term;
          IStrategoTerm term1 = term;
          Success1:
          { 
            Fail14:
            { 
              term = p_10707;
              if(term.getTermType() != IStrategoTerm.APPL || Main._consCOMPLETION_1 != ((IStrategoAppl)term).getConstructor())
                break Fail14;
              { 
                if(true)
                  break Fail13;
                if(true)
                  break Success1;
              }
            }
            term = term1;
          }
          term = t_10707;
          { 
            term = a_10708.invoke(context, p_10707);
            if(term == null)
              break Fail12;
            if(r_10707.value == null)
              r_10707.value = term;
            else
              if(r_10707.value != term && !r_10707.value.match(term))
                break Fail12;
            if(r_10707.value == null)
              break Fail12;
            term = import_cache_path_0_0.instance.invoke(context, r_10707.value);
            if(term == null)
              break Fail12;
            q_10707 = term;
            IStrategoTerm term2 = term;
            Success2:
            { 
              Fail15:
              { 
                IStrategoTerm u_10707 = null;
                u_10707 = term;
                IStrategoTerm term3 = term;
                Success3:
                { 
                  Fail16:
                  { 
                    if(r_10707.value == null)
                      break Fail16;
                    term = $Is$Imported_0_0.instance.invoke(context, r_10707.value);
                    if(term == null)
                      break Fail16;
                    { 
                      if(true)
                        break Fail15;
                      if(true)
                        break Success3;
                    }
                  }
                  term = term3;
                }
                term = u_10707;
                { 
                  IStrategoTerm v_10707 = null;
                  IStrategoTerm e_10708 = null;
                  IStrategoTerm g_10708 = null;
                  IStrategoTerm h_10708 = null;
                  IStrategoTerm i_10708 = null;
                  IStrategoTerm j_10708 = null;
                  v_10707 = term;
                  g_10708 = term;
                  e_10708 = trans.const5;
                  term = g_10708;
                  h_10708 = g_10708;
                  if(r_10707.value == null)
                    break Fail12;
                  term = termFactory.makeTuple(trans.const6, r_10707.value);
                  term = dr_set_rule_0_3.instance.invoke(context, h_10708, e_10708, r_10707.value, term);
                  if(term == null)
                    break Fail12;
                  term = v_10707;
                  IStrategoTerm term4 = term;
                  Success4:
                  { 
                    Fail17:
                    { 
                      if(r_10707.value == null)
                        break Fail17;
                      term = termFactory.makeTuple(q_10707, r_10707.value);
                      term = is_newer_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail17;
                      term = $Read$From$File_0_0.instance.invoke(context, q_10707);
                      if(term == null)
                        break Fail17;
                      if(s_10707.value == null)
                        s_10707.value = term;
                      else
                        if(s_10707.value != term && !s_10707.value.match(term))
                          break Fail17;
                      if(true)
                        break Success4;
                    }
                    term = term4;
                    if(r_10707.value == null)
                      break Fail12;
                    term = b_10708.invoke(context, r_10707.value);
                    if(term == null)
                      break Fail12;
                    if(s_10707.value == null)
                      s_10707.value = term;
                    else
                      if(s_10707.value != term && !s_10707.value.match(term))
                        break Fail12;
                    IStrategoTerm term5 = term;
                    Success5:
                    { 
                      Fail18:
                      { 
                        IStrategoTerm w_10707 = null;
                        w_10707 = term;
                        if(r_10707.value == null)
                          break Fail18;
                        term = file_exists_0_0.instance.invoke(context, r_10707.value);
                        if(term == null)
                          break Fail18;
                        term = w_10707;
                        { 
                          if(s_10707.value == null)
                            break Fail12;
                          term = termFactory.makeTuple(q_10707, s_10707.value);
                          term = $Write$To$Binary$File_0_0.instance.invoke(context, term);
                          if(term == null)
                            break Fail12;
                          if(true)
                            break Success5;
                        }
                      }
                      term = term5;
                    }
                  }
                  j_10708 = term;
                  i_10708 = trans.const3;
                  term = j_10708;
                  lifted5 lifted510 = new lifted5();
                  lifted510.c_10708 = c_10708;
                  lifted510.r_10707 = r_10707;
                  lifted510.s_10707 = s_10707;
                  term = dr_scope_1_1.instance.invoke(context, term, lifted510, i_10708);
                  if(term == null)
                    break Fail12;
                  if(true)
                    break Success2;
                }
              }
              term = term2;
            }
            if(true)
              break Success0;
          }
        }
        term = term0;
      }
      term = p_10707;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}