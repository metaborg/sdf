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
    Fail928:
    { 
      IStrategoTerm p_32758 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consLine_1 != ((IStrategoAppl)term).getConstructor())
        break Fail928;
      p_32758 = term.getSubterm(0);
      term = p_32758;
      IStrategoTerm term370 = term;
      Success334:
      { 
        Fail929:
        { 
          IStrategoTerm j_32758 = null;
          j_32758 = term;
          IStrategoTerm term371 = term;
          Success335:
          { 
            Fail930:
            { 
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail930;
              IStrategoTerm arg321 = ((IStrategoList)term).head();
              if(arg321.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg321).getConstructor())
                break Fail930;
              IStrategoTerm arg323 = ((IStrategoList)term).tail();
              if(arg323.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg323).isEmpty())
                break Fail930;
              IStrategoTerm arg324 = ((IStrategoList)arg323).head();
              if(arg324.getTermType() != IStrategoTerm.APPL || Main._consPlaceholder_4 != ((IStrategoAppl)arg324).getConstructor())
                break Fail930;
              IStrategoTerm arg328 = ((IStrategoList)arg323).tail();
              if(arg328.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg328).isEmpty())
                break Fail930;
              { 
                if(true)
                  break Fail929;
                if(true)
                  break Success335;
              }
            }
            term = term371;
          }
          term = j_32758;
          { 
            IStrategoTerm k_32758 = null;
            IStrategoTerm l_32758 = null;
            l_32758 = term;
            term = templatelang_get_option_0_0.instance.invoke(context, generated.constNewlines0);
            if(term == null)
              break Fail928;
            k_32758 = term;
            term = l_32758;
            IStrategoTerm term372 = term;
            Success336:
            { 
              Fail931:
              { 
                IStrategoTerm m_32758 = null;
                m_32758 = term;
                term = k_32758;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consNone_0 != ((IStrategoAppl)term).getConstructor())
                  break Fail931;
                term = m_32758;
                if(true)
                  break Success336;
              }
              term = term372;
              IStrategoTerm term373 = term;
              Success337:
              { 
                Fail932:
                { 
                  IStrategoTerm n_32758 = null;
                  n_32758 = term;
                  term = k_32758;
                  if(term.getTermType() != IStrategoTerm.APPL || Main._consLeading_0 != ((IStrategoAppl)term).getConstructor())
                    break Fail932;
                  term = n_32758;
                  { 
                    IStrategoTerm q_32758 = null;
                    IStrategoTerm r_32758 = null;
                    r_32758 = term;
                    q_32758 = term;
                    term = r_32758;
                    IStrategoList list7;
                    list7 = checkListTail(q_32758);
                    if(list7 == null)
                      break Fail928;
                    term = (IStrategoTerm)termFactory.makeListCons(generated.constString0, list7);
                    if(true)
                      break Success337;
                  }
                }
                term = term373;
                IStrategoTerm o_32758 = null;
                o_32758 = term;
                term = k_32758;
                if(term.getTermType() != IStrategoTerm.APPL || Main._consTrailing_0 != ((IStrategoAppl)term).getConstructor())
                  break Fail928;
                term = termFactory.makeTuple(o_32758, generated.constCons74);
                term = make$Conc_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail928;
              }
            }
            if(true)
              break Success334;
          }
        }
        term = term370;
      }
      term = filter_1_0.instance.invoke(context, term, template_element_to_sdf_0_0.instance);
      if(term == null)
        break Fail928;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}