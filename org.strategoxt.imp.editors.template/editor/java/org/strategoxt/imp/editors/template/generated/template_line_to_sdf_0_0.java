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

@SuppressWarnings("all") public class template_line_to_sdf_0_0 extends Strategy 
{ 
  public static template_line_to_sdf_0_0 instance = new template_line_to_sdf_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_line_to_sdf_0_0");
    Fail109:
    { 
      IStrategoTerm h_9720 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail109;
      h_9720 = term.getSubterm(0);
      term = h_9720;
      IStrategoTerm term115 = term;
      Success79:
      { 
        Fail110:
        { 
          IStrategoTerm b_9720 = null;
          b_9720 = term;
          IStrategoTerm term116 = term;
          Success80:
          { 
            Fail111:
            { 
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail111;
              IStrategoTerm arg173 = ((IStrategoList)term).head();
              if(arg173.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg173).getConstructor())
                break Fail111;
              IStrategoTerm arg175 = ((IStrategoList)term).tail();
              if(arg175.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg175).isEmpty())
                break Fail111;
              IStrategoTerm arg176 = ((IStrategoList)arg175).head();
              if(arg176.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg176).getConstructor())
                break Fail111;
              IStrategoTerm arg180 = ((IStrategoList)arg175).tail();
              if(arg180.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg180).isEmpty())
                break Fail111;
              { 
                if(true)
                  break Fail110;
                if(true)
                  break Success80;
              }
            }
            term = term116;
          }
          term = b_9720;
          { 
            IStrategoTerm c_9720 = null;
            IStrategoTerm d_9720 = null;
            d_9720 = term;
            term = templatelang_get_option_0_0.instance.invoke(context, generated.constNewlines0);
            if(term == null)
              break Fail109;
            c_9720 = term;
            term = d_9720;
            IStrategoTerm term117 = term;
            Success81:
            { 
              Fail112:
              { 
                IStrategoTerm e_9720 = null;
                e_9720 = term;
                term = c_9720;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)term).getConstructor())
                  break Fail112;
                term = e_9720;
                if(true)
                  break Success81;
              }
              term = term117;
              IStrategoTerm term118 = term;
              Success82:
              { 
                Fail113:
                { 
                  IStrategoTerm f_9720 = null;
                  f_9720 = term;
                  term = c_9720;
                  if(term.getTermType() != IStrategoTerm.APPL || Main._consLeading_0 != ((IStrategoAppl)term).getConstructor())
                    break Fail113;
                  term = f_9720;
                  { 
                    IStrategoTerm i_9720 = null;
                    IStrategoTerm j_9720 = null;
                    j_9720 = term;
                    i_9720 = term;
                    term = j_9720;
                    IStrategoList list4;
                    list4 = checkListTail(i_9720);
                    if(list4 == null)
                      break Fail109;
                    term = (IStrategoTerm)termFactory.makeListCons(generated.constString0, list4);
                    if(true)
                      break Success82;
                  }
                }
                term = term118;
                IStrategoTerm g_9720 = null;
                g_9720 = term;
                term = c_9720;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consTrailing_0 != ((IStrategoAppl)term).getConstructor())
                  break Fail109;
                term = termFactory.makeTuple(g_9720, generated.constCons61);
                term = make$Conc_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail109;
              }
            }
            if(true)
              break Success79;
          }
        }
        term = term115;
      }
      term = filter_1_0.instance.invoke(context, term, template_element_to_sdf_0_0.instance);
      if(term == null)
        break Fail109;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}