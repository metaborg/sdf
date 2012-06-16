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
    Fail245:
    { 
      IStrategoTerm term235 = term;
      IStrategoConstructor cons17 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success181:
      { 
        if(cons17 == Main._consString_1)
        { 
          Fail246:
          { 
            IStrategoTerm i_9733 = null;
            i_9733 = term.getSubterm(0);
            term = string_length_0_0.instance.invoke(context, i_9733);
            if(term == null)
              break Fail246;
            if(true)
              break Success181;
          }
          term = term235;
        }
        Success182:
        { 
          if(cons17 == Main._consLayout_1)
          { 
            Fail247:
            { 
              IStrategoTerm j_9733 = null;
              j_9733 = term.getSubterm(0);
              term = string_length_0_0.instance.invoke(context, j_9733);
              if(term == null)
                break Fail247;
              if(true)
                break Success182;
            }
            term = term235;
          }
          Success183:
          { 
            if(cons17 == Main._consText_1)
            { 
              Fail248:
              { 
                IStrategoTerm k_9733 = null;
                k_9733 = term.getSubterm(0);
                term = string_length_0_0.instance.invoke(context, k_9733);
                if(term == null)
                  break Fail248;
                if(true)
                  break Success183;
              }
              term = term235;
            }
            Success184:
            { 
              if(cons17 == Main._consPlaceholder_4)
              { 
                Fail249:
                { 
                  IStrategoTerm h_9733 = null;
                  IStrategoTerm l_9733 = null;
                  IStrategoTerm arg333 = term.getSubterm(1);
                  if(arg333.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg333).getConstructor())
                    break Fail249;
                  h_9733 = arg333.getSubterm(0);
                  l_9733 = term.getSubterm(3);
                  term = l_9733;
                  IStrategoTerm term239 = term;
                  Success185:
                  { 
                    Fail250:
                    { 
                      term = SRTS_one.instance.invoke(context, term, lifted169.instance);
                      if(term == null)
                        break Fail250;
                      { 
                        if(true)
                          break Fail249;
                        if(true)
                          break Success185;
                      }
                    }
                    term = term239;
                  }
                  term = string_length_0_0.instance.invoke(context, h_9733);
                  if(term == null)
                    break Fail249;
                  if(true)
                    break Success184;
                }
                term = term235;
              }
              term = crush_3_0.instance.invoke(context, term, lifted170.instance, addi_0_0.instance, template_character_count_0_0.instance);
              if(term == null)
                break Fail245;
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