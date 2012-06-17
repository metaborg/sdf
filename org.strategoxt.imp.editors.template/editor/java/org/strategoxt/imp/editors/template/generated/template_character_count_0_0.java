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

@SuppressWarnings("all") public class template_character_count_0_0 extends Strategy 
{ 
  public static template_character_count_0_0 instance = new template_character_count_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("template_character_count_0_0");
    Fail1065:
    { 
      IStrategoTerm term491 = term;
      IStrategoConstructor cons29 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success437:
      { 
        if(cons29 == Main._consString_1)
        { 
          Fail1066:
          { 
            IStrategoTerm r_32771 = null;
            r_32771 = term.getSubterm(0);
            term = string_length_0_0.instance.invoke(context, r_32771);
            if(term == null)
              break Fail1066;
            if(true)
              break Success437;
          }
          term = term491;
        }
        Success438:
        { 
          if(cons29 == Main._consLayout_1)
          { 
            Fail1067:
            { 
              IStrategoTerm s_32771 = null;
              s_32771 = term.getSubterm(0);
              term = string_length_0_0.instance.invoke(context, s_32771);
              if(term == null)
                break Fail1067;
              if(true)
                break Success438;
            }
            term = term491;
          }
          Success439:
          { 
            if(cons29 == Main._consText_1)
            { 
              Fail1068:
              { 
                IStrategoTerm t_32771 = null;
                t_32771 = term.getSubterm(0);
                term = string_length_0_0.instance.invoke(context, t_32771);
                if(term == null)
                  break Fail1068;
                if(true)
                  break Success439;
              }
              term = term491;
            }
            Success440:
            { 
              if(cons29 == Main._consPlaceholder_4)
              { 
                Fail1069:
                { 
                  IStrategoTerm q_32771 = null;
                  IStrategoTerm u_32771 = null;
                  IStrategoTerm arg486 = term.getSubterm(1);
                  if(arg486.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg486).getConstructor())
                    break Fail1069;
                  q_32771 = arg486.getSubterm(0);
                  u_32771 = term.getSubterm(3);
                  term = u_32771;
                  IStrategoTerm term495 = term;
                  Success441:
                  { 
                    Fail1070:
                    { 
                      term = SRTS_one.instance.invoke(context, term, lifted368.instance);
                      if(term == null)
                        break Fail1070;
                      { 
                        if(true)
                          break Fail1069;
                        if(true)
                          break Success441;
                      }
                    }
                    term = term495;
                  }
                  term = string_length_0_0.instance.invoke(context, q_32771);
                  if(term == null)
                    break Fail1069;
                  if(true)
                    break Success440;
                }
                term = term491;
              }
              term = crush_3_0.instance.invoke(context, term, lifted369.instance, addi_0_0.instance, template_character_count_0_0.instance);
              if(term == null)
                break Fail1065;
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