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

@SuppressWarnings("all") public class template_element_to_string_0_0 extends Strategy 
{ 
  public static template_element_to_string_0_0 instance = new template_element_to_string_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("template_element_to_string_0_0");
    Fail0:
    { 
      IStrategoTerm term0 = term;
      Success0:
      { 
        Fail1:
        { 
          IStrategoTerm j_9705 = null;
          TermReference k_9705 = new TermReference();
          IStrategoTerm l_9705 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
            break Fail1;
          j_9705 = term.getSubterm(3);
          l_9705 = term;
          term = j_9705;
          lifted0 lifted00 = new lifted0();
          lifted00.k_9705 = k_9705;
          term = SRTS_one.instance.invoke(context, term, lifted00);
          if(term == null)
            break Fail1;
          term = l_9705;
          if(k_9705.value == null)
            break Fail1;
          term = k_9705.value;
          if(true)
            break Success0;
        }
        term = term0;
        IStrategoTerm term1 = term;
        IStrategoConstructor cons0 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
        Success1:
        { 
          if(cons0 == Main._consPlaceholder_4)
          { 
            Fail2:
            { 
              IStrategoTerm f_9705 = null;
              IStrategoTerm g_9705 = null;
              IStrategoTerm h_9705 = null;
              IStrategoTerm arg4 = term.getSubterm(1);
              if(arg4.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg4).getConstructor())
                break Fail2;
              f_9705 = arg4.getSubterm(0);
              h_9705 = term.getSubterm(2);
              g_9705 = term.getSubterm(3);
              term = h_9705;
              IStrategoTerm term2 = term;
              Success2:
              { 
                Fail3:
                { 
                  term = $None_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail3;
                  if(true)
                    break Success2;
                }
                term = $Plus_0_0.instance.invoke(context, term2);
                if(term == null)
                  break Fail2;
              }
              term = g_9705;
              IStrategoTerm term3 = term;
              Success3:
              { 
                Fail4:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted1.instance);
                  if(term == null)
                    break Fail4;
                  { 
                    if(true)
                      break Fail2;
                    if(true)
                      break Success3;
                  }
                }
                term = term3;
              }
              term = f_9705;
              if(true)
                break Success1;
            }
            term = term1;
          }
          Success4:
          { 
            if(cons0 == Main._consPlaceholder_4)
            { 
              Fail5:
              { 
                IStrategoTerm c_9705 = null;
                IStrategoTerm d_9705 = null;
                d_9705 = term.getSubterm(2);
                c_9705 = term.getSubterm(3);
                term = d_9705;
                IStrategoTerm term6 = term;
                Success5:
                { 
                  Fail6:
                  { 
                    term = $Option_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail6;
                    if(true)
                      break Success5;
                  }
                  term = $Star_0_0.instance.invoke(context, term6);
                  if(term == null)
                    break Fail5;
                }
                term = c_9705;
                IStrategoTerm term7 = term;
                Success6:
                { 
                  Fail7:
                  { 
                    term = SRTS_one.instance.invoke(context, term, lifted2.instance);
                    if(term == null)
                      break Fail7;
                    { 
                      if(true)
                        break Fail5;
                      if(true)
                        break Success6;
                    }
                  }
                  term = term7;
                }
                term = generated.const0;
                if(true)
                  break Success4;
              }
              term = term1;
            }
            Success7:
            { 
              if(cons0 == Main._consPlaceholder_4)
              { 
                Fail8:
                { 
                  IStrategoTerm a_9705 = null;
                  a_9705 = term.getSubterm(3);
                  term = SRTS_one.instance.invoke(context, a_9705, lifted3.instance);
                  if(term == null)
                    break Fail8;
                  term = generated.const0;
                  if(true)
                    break Success7;
                }
                term = term1;
              }
              Success8:
              { 
                if(cons0 == Main._consPlaceholder_1)
                { 
                  Fail9:
                  { 
                    IStrategoTerm z_9704 = null;
                    z_9704 = term.getSubterm(0);
                    term = z_9704;
                    if(true)
                      break Success8;
                  }
                  term = term1;
                }
                Success9:
                { 
                  if(cons0 == Main._consPlaceholderWithSort_2)
                  { 
                    Fail10:
                    { 
                      IStrategoTerm y_9704 = null;
                      y_9704 = term.getSubterm(0);
                      term = string_as_chars_1_0.instance.invoke(context, y_9704, lifted4.instance);
                      if(term == null)
                        break Fail10;
                      if(true)
                        break Success9;
                    }
                    term = term1;
                  }
                  Success10:
                  { 
                    if(cons0 == Main._consLayout_1)
                    { 
                      Fail11:
                      { 
                        IStrategoTerm x_9704 = null;
                        x_9704 = term.getSubterm(0);
                        term = x_9704;
                        if(true)
                          break Success10;
                      }
                      term = term1;
                    }
                    Success11:
                    { 
                      if(cons0 == Main._consString_1)
                      { 
                        Fail12:
                        { 
                          IStrategoTerm w_9704 = null;
                          w_9704 = term.getSubterm(0);
                          term = w_9704;
                          if(true)
                            break Success11;
                        }
                        term = term1;
                      }
                      if(cons0 == Main._consCursor_0)
                      { 
                        term = generated.const0;
                      }
                      else
                      { 
                        break Fail0;
                      }
                    }
                  }
                }
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