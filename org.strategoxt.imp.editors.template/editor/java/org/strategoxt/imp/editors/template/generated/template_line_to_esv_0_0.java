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

@SuppressWarnings("all") public class template_line_to_esv_0_0 extends Strategy 
{ 
  public static template_line_to_esv_0_0 instance = new template_line_to_esv_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_line_to_esv_0_0");
    Fail151:
    { 
      IStrategoTerm term157 = term;
      IStrategoConstructor cons11 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success106:
      { 
        if(cons11 == Main._consLine_1)
        { 
          Fail152:
          { 
            IStrategoTerm z_9723 = null;
            IStrategoTerm a_9724 = null;
            IStrategoTerm b_9724 = null;
            IStrategoTerm arg213 = term.getSubterm(0);
            if(arg213.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg213).isEmpty())
              break Fail152;
            IStrategoTerm arg214 = ((IStrategoList)arg213).head();
            if(arg214.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg214).getConstructor())
              break Fail152;
            z_9723 = arg214.getSubterm(0);
            IStrategoTerm arg215 = ((IStrategoList)arg213).tail();
            if(arg215.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg215).isEmpty())
              break Fail152;
            IStrategoTerm arg216 = ((IStrategoList)arg215).head();
            if(arg216.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg216).getConstructor())
              break Fail152;
            b_9724 = arg216.getSubterm(2);
            a_9724 = arg216.getSubterm(3);
            IStrategoTerm arg218 = ((IStrategoList)arg215).tail();
            if(arg218.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg218).isEmpty())
              break Fail152;
            term = b_9724;
            IStrategoTerm term158 = term;
            Success107:
            { 
              Fail153:
              { 
                term = $Option_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail153;
                if(true)
                  break Success107;
              }
              term = $Star_0_0.instance.invoke(context, term158);
              if(term == null)
                break Fail152;
            }
            term = a_9724;
            IStrategoTerm term159 = term;
            Success108:
            { 
              Fail154:
              { 
                term = SRTS_one.instance.invoke(context, term, lifted135.instance);
                if(term == null)
                  break Fail154;
                { 
                  if(true)
                    break Fail152;
                  if(true)
                    break Success108;
                }
              }
              term = term159;
            }
            term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{z_9723}), (IStrategoList)generated.constCons65);
            term = spaces_to_tabs_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail152;
            if(true)
              break Success106;
          }
          term = term157;
        }
        if(cons11 == Main._consLine_1)
        { 
          IStrategoTerm x_9723 = null;
          x_9723 = term.getSubterm(0);
          term = filter_1_0.instance.invoke(context, x_9723, template_element_to_esv_0_0.instance);
          if(term == null)
            break Fail151;
          IStrategoTerm term160 = term;
          Success109:
          { 
            Fail155:
            { 
              if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                break Fail155;
              { 
                if(true)
                  break Fail151;
                if(true)
                  break Success109;
              }
            }
            term = term160;
          }
          term = spaces_to_tabs_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail151;
        }
        else
        { 
          break Fail151;
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