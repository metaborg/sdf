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
    Fail819:
    { 
      IStrategoTerm term255 = term;
      Success255:
      { 
        Fail820:
        { 
          IStrategoTerm r_32743 = null;
          TermReference s_32743 = new TermReference();
          IStrategoTerm t_32743 = null;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)term).getConstructor())
            break Fail820;
          r_32743 = term.getSubterm(3);
          t_32743 = term;
          term = r_32743;
          lifted199 lifted1990 = new lifted199();
          lifted1990.s_32743 = s_32743;
          term = SRTS_one.instance.invoke(context, term, lifted1990);
          if(term == null)
            break Fail820;
          term = t_32743;
          if(s_32743.value == null)
            break Fail820;
          term = s_32743.value;
          if(true)
            break Success255;
        }
        term = term255;
        IStrategoTerm term256 = term;
        IStrategoConstructor cons12 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
        Success256:
        { 
          if(cons12 == Main._consPlaceholder_4)
          { 
            Fail821:
            { 
              IStrategoTerm n_32743 = null;
              IStrategoTerm o_32743 = null;
              IStrategoTerm p_32743 = null;
              IStrategoTerm arg152 = term.getSubterm(1);
              if(arg152.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg152).getConstructor())
                break Fail821;
              n_32743 = arg152.getSubterm(0);
              p_32743 = term.getSubterm(2);
              o_32743 = term.getSubterm(3);
              term = p_32743;
              IStrategoTerm term257 = term;
              Success257:
              { 
                Fail822:
                { 
                  term = $None_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail822;
                  if(true)
                    break Success257;
                }
                term = $Plus_0_0.instance.invoke(context, term257);
                if(term == null)
                  break Fail821;
              }
              term = o_32743;
              IStrategoTerm term258 = term;
              Success258:
              { 
                Fail823:
                { 
                  term = SRTS_one.instance.invoke(context, term, lifted200.instance);
                  if(term == null)
                    break Fail823;
                  { 
                    if(true)
                      break Fail821;
                    if(true)
                      break Success258;
                  }
                }
                term = term258;
              }
              term = n_32743;
              if(true)
                break Success256;
            }
            term = term256;
          }
          Success259:
          { 
            if(cons12 == Main._consPlaceholder_4)
            { 
              Fail824:
              { 
                IStrategoTerm k_32743 = null;
                IStrategoTerm l_32743 = null;
                l_32743 = term.getSubterm(2);
                k_32743 = term.getSubterm(3);
                term = l_32743;
                IStrategoTerm term261 = term;
                Success260:
                { 
                  Fail825:
                  { 
                    term = $Option_0_0.instance.invoke(context, term);
                    if(term == null)
                      break Fail825;
                    if(true)
                      break Success260;
                  }
                  term = $Star_0_0.instance.invoke(context, term261);
                  if(term == null)
                    break Fail824;
                }
                term = k_32743;
                IStrategoTerm term262 = term;
                Success261:
                { 
                  Fail826:
                  { 
                    term = SRTS_one.instance.invoke(context, term, lifted201.instance);
                    if(term == null)
                      break Fail826;
                    { 
                      if(true)
                        break Fail824;
                      if(true)
                        break Success261;
                    }
                  }
                  term = term262;
                }
                term = generated.const121;
                if(true)
                  break Success259;
              }
              term = term256;
            }
            Success262:
            { 
              if(cons12 == Main._consPlaceholder_4)
              { 
                Fail827:
                { 
                  IStrategoTerm i_32743 = null;
                  i_32743 = term.getSubterm(3);
                  term = SRTS_one.instance.invoke(context, i_32743, lifted202.instance);
                  if(term == null)
                    break Fail827;
                  term = generated.const121;
                  if(true)
                    break Success262;
                }
                term = term256;
              }
              Success263:
              { 
                if(cons12 == Main._consPlaceholder_1)
                { 
                  Fail828:
                  { 
                    IStrategoTerm h_32743 = null;
                    h_32743 = term.getSubterm(0);
                    term = h_32743;
                    if(true)
                      break Success263;
                  }
                  term = term256;
                }
                Success264:
                { 
                  if(cons12 == Main._consPlaceholderWithSort_2)
                  { 
                    Fail829:
                    { 
                      IStrategoTerm g_32743 = null;
                      g_32743 = term.getSubterm(0);
                      term = string_as_chars_1_0.instance.invoke(context, g_32743, lifted203.instance);
                      if(term == null)
                        break Fail829;
                      if(true)
                        break Success264;
                    }
                    term = term256;
                  }
                  Success265:
                  { 
                    if(cons12 == Main._consLayout_1)
                    { 
                      Fail830:
                      { 
                        IStrategoTerm f_32743 = null;
                        f_32743 = term.getSubterm(0);
                        term = f_32743;
                        if(true)
                          break Success265;
                      }
                      term = term256;
                    }
                    Success266:
                    { 
                      if(cons12 == Main._consString_1)
                      { 
                        Fail831:
                        { 
                          IStrategoTerm e_32743 = null;
                          e_32743 = term.getSubterm(0);
                          term = e_32743;
                          if(true)
                            break Success266;
                        }
                        term = term256;
                      }
                      if(cons12 == Main._consCursor_0)
                      { 
                        term = generated.const121;
                      }
                      else
                      { 
                        break Fail819;
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