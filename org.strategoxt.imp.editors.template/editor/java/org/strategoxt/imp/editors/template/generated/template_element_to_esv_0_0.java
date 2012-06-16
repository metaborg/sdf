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

@SuppressWarnings("all") public class template_element_to_esv_0_0 extends Strategy 
{ 
  public static template_element_to_esv_0_0 instance = new template_element_to_esv_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_element_to_esv_0_0");
    Fail157:
    { 
      IStrategoTerm term161 = term;
      Success110:
      { 
        Fail158:
        { 
          IStrategoTerm p_9725 = null;
          IStrategoTerm q_9725 = null;
          TermReference r_9725 = new TermReference();
          IStrategoTerm a_9726 = null;
          IStrategoTerm w_9725 = null;
          IStrategoTerm y_9725 = null;
          IStrategoTerm z_9725 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
            break Fail158;
          IStrategoTerm arg220 = term.getSubterm(1);
          if(arg220.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg220).getConstructor())
            break Fail158;
          p_9725 = arg220.getSubterm(0);
          q_9725 = term.getSubterm(3);
          a_9726 = term;
          term = q_9725;
          lifted139 lifted1390 = new lifted139();
          lifted1390.r_9725 = r_9725;
          term = SRTS_one.instance.invoke(context, term, lifted1390);
          if(term == null)
            break Fail158;
          term = a_9726;
          if(r_9725.value == null)
            break Fail158;
          term = r_9725.value;
          IStrategoTerm term162 = term;
          Success111:
          { 
            Fail159:
            { 
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail159;
              if(true)
                break Success111;
            }
            term = term162;
            IStrategoTerm term163 = term;
            Success112:
            { 
              Fail160:
              { 
                term = is_string_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail160;
                if(true)
                  break Success112;
              }
              term = term163;
              IStrategoTerm term164 = term;
              Success113:
              { 
                Fail161:
                { 
                  term = int_to_string_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail161;
                  if(true)
                    break Success113;
                }
                term = term164;
                IStrategoTerm term165 = term;
                Success114:
                { 
                  Fail162:
                  { 
                    term = real_to_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail162;
                    if(true)
                      break Success114;
                  }
                  term = term165;
                  IStrategoTerm s_9725 = null;
                  IStrategoTerm t_9725 = null;
                  IStrategoTerm v_9725 = null;
                  s_9725 = term;
                  term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                  if(term == null)
                    break Fail158;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail158;
                  t_9725 = ((IStrategoList)term).tail();
                  v_9725 = t_9725;
                  term = report_failure_0_2.instance.invoke(context, v_9725, generated.const86, s_9725);
                  if(term == null)
                    break Fail158;
                }
              }
            }
          }
          y_9725 = term;
          w_9725 = generated.const39;
          z_9725 = y_9725;
          term = string_replace_0_2.instance.invoke(context, z_9725, w_9725, generated.const87);
          if(term == null)
            break Fail158;
          term = (IStrategoTerm)termFactory.makeListCons(generated.const89, termFactory.makeListCons(term, (IStrategoList)generated.constCons66));
          term = concat_strings_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail158;
          term = termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0)), p_9725});
          if(true)
            break Success110;
        }
        term = term161;
        IStrategoTerm term166 = term;
        IStrategoConstructor cons12 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
        Success115:
        { 
          if(cons12 == Main._consPlaceholder_4)
          { 
            Fail163:
            { 
              IStrategoTerm v_9724 = null;
              IStrategoTerm w_9724 = null;
              IStrategoTerm x_9724 = null;
              IStrategoTerm y_9724 = null;
              IStrategoTerm h_9725 = null;
              IStrategoTerm d_9725 = null;
              IStrategoTerm f_9725 = null;
              IStrategoTerm g_9725 = null;
              x_9724 = term;
              IStrategoTerm arg223 = term.getSubterm(1);
              if(arg223.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg223).getConstructor())
                break Fail163;
              w_9724 = arg223.getSubterm(0);
              h_9725 = term.getSubterm(2);
              v_9724 = term.getSubterm(3);
              term = h_9725;
              IStrategoTerm term167 = term;
              Success116:
              { 
                Fail164:
                { 
                  term = $None_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail164;
                  if(true)
                    break Success116;
                }
                term = $Plus_0_0.instance.invoke(context, term167);
                if(term == null)
                  break Fail163;
              }
              term = v_9724;
              IStrategoTerm term168 = term;
              Success117:
              { 
                Fail165:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted140.instance);
                  if(term == null)
                    break Fail165;
                  { 
                    if(true)
                      break Fail163;
                    if(true)
                      break Success117;
                  }
                }
                term = term168;
              }
              term = (IStrategoTerm)termFactory.makeListCons(x_9724, (IStrategoList)generated.constNil0);
              Success118:
              { 
                Fail166:
                { 
                  term = expand_template_element_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail166;
                  term = map_1_0.instance.invoke(context, term, template_element_to_string_0_0.instance);
                  if(term == null)
                    break Fail166;
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail166;
                  if(true)
                    break Success118;
                }
                term = w_9724;
              }
              y_9724 = term;
              term = y_9724;
              IStrategoTerm term171 = term;
              Success119:
              { 
                Fail167:
                { 
                  term = concat_strings_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail167;
                  if(true)
                    break Success119;
                }
                term = term171;
                IStrategoTerm term172 = term;
                Success120:
                { 
                  Fail168:
                  { 
                    term = is_string_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail168;
                    if(true)
                      break Success120;
                  }
                  term = term172;
                  IStrategoTerm term173 = term;
                  Success121:
                  { 
                    Fail169:
                    { 
                      term = int_to_string_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail169;
                      if(true)
                        break Success121;
                    }
                    term = term173;
                    IStrategoTerm term174 = term;
                    Success122:
                    { 
                      Fail170:
                      { 
                        term = real_to_string_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail170;
                        if(true)
                          break Success122;
                      }
                      term = term174;
                      IStrategoTerm z_9724 = null;
                      IStrategoTerm a_9725 = null;
                      IStrategoTerm c_9725 = null;
                      z_9724 = term;
                      term = context.invokePrimitive("SSL_stacktrace_get_all_frame_names", term, NO_STRATEGIES, NO_TERMS);
                      if(term == null)
                        break Fail163;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail163;
                      a_9725 = ((IStrategoList)term).tail();
                      c_9725 = a_9725;
                      term = report_failure_0_2.instance.invoke(context, c_9725, generated.const86, z_9724);
                      if(term == null)
                        break Fail163;
                    }
                  }
                }
              }
              f_9725 = term;
              d_9725 = generated.const39;
              g_9725 = f_9725;
              term = string_replace_0_2.instance.invoke(context, g_9725, d_9725, generated.const87);
              if(term == null)
                break Fail163;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const89, termFactory.makeListCons(term, (IStrategoList)generated.constCons66));
              term = concat_strings_0_0.instance.invoke(context, term);
              if(term == null)
                break Fail163;
              term = termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{termFactory.annotateTerm(term, checkListAnnos(termFactory, generated.constNil0)), w_9724});
              if(true)
                break Success115;
            }
            term = term166;
          }
          Success123:
          { 
            if(cons12 == Main._consPlaceholder_4)
            { 
              Fail171:
              { 
                IStrategoTerm q_9724 = null;
                IStrategoTerm r_9724 = null;
                IStrategoTerm s_9724 = null;
                IStrategoTerm arg226 = term.getSubterm(1);
                if(arg226.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg226).getConstructor())
                  break Fail171;
                q_9724 = arg226.getSubterm(0);
                s_9724 = term.getSubterm(2);
                r_9724 = term.getSubterm(3);
                term = s_9724;
                IStrategoTerm term176 = term;
                Success124:
                { 
                  Fail172:
                  { 
                    term = $Option_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail172;
                    if(true)
                      break Success124;
                  }
                  term = $Star_0_0.instance.invoke(context, term176);
                  if(term == null)
                    break Fail171;
                }
                term = r_9724;
                IStrategoTerm term177 = term;
                Success125:
                { 
                  Fail173:
                  { 
                    term = SRTS_one.instance.invoke(context, term, lifted142.instance);
                    if(term == null)
                      break Fail173;
                    { 
                      if(true)
                        break Fail171;
                      if(true)
                        break Success125;
                    }
                  }
                  term = term177;
                }
                term = termFactory.makeAppl(Main._consPlaceholderWithSort_2, new IStrategoTerm[]{generated.const90, q_9724});
                if(true)
                  break Success123;
              }
              term = term166;
            }
            Success126:
            { 
              if(cons12 == Main._consLayout_1)
              { 
                Fail174:
                { 
                  IStrategoTerm o_9724 = null;
                  o_9724 = term.getSubterm(0);
                  term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{o_9724});
                  if(true)
                    break Success126;
                }
                term = term166;
              }
              if(cons12 == Main._consString_1)
              { }
              else
              { 
                break Fail157;
              }
            }
          }
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