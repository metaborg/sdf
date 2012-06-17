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

@SuppressWarnings("all") final class n_32785 extends Strategy 
{ 
  public static final n_32785 instance = new n_32785();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1546:
    { 
      IStrategoTerm term622 = term;
      Success557:
      { 
        Fail1547:
        { 
          IStrategoTerm o_32785 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1547;
          IStrategoTerm arg713 = ((IStrategoList)term).head();
          if(arg713.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg713).getConstructor())
            break Fail1547;
          IStrategoTerm arg714 = arg713.getSubterm(0);
          if(arg714.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)arg714).stringValue()))
            break Fail1547;
          o_32785 = ((IStrategoList)term).tail();
          term = this.invoke(context, o_32785);
          if(term == null)
            break Fail1547;
          if(true)
            break Success557;
        }
        term = term622;
        IStrategoTerm term623 = term;
        Success558:
        { 
          Fail1548:
          { 
            IStrategoTerm f_32785 = null;
            IStrategoTerm g_32785 = null;
            IStrategoTerm h_32785 = null;
            IStrategoTerm p_32785 = null;
            IStrategoTerm q_32785 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1548;
            IStrategoTerm arg715 = ((IStrategoList)term).head();
            if(arg715.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg715).getConstructor())
              break Fail1548;
            f_32785 = arg715.getSubterm(0);
            IStrategoTerm arg716 = ((IStrategoList)term).tail();
            if(arg716.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg716).isEmpty())
              break Fail1548;
            IStrategoTerm arg717 = ((IStrategoList)arg716).head();
            if(arg717.getTermType() != IStrategoTerm.APPL || Main._consString_1 != ((IStrategoAppl)arg717).getConstructor())
              break Fail1548;
            g_32785 = arg717.getSubterm(0);
            h_32785 = ((IStrategoList)arg716).tail();
            q_32785 = term;
            term = termFactory.makeTuple(f_32785, g_32785);
            term = conc_strings_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1548;
            p_32785 = term;
            term = q_32785;
            IStrategoList list46;
            list46 = checkListTail(h_32785);
            if(list46 == null)
              break Fail1548;
            term = (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{p_32785}), list46);
            term = this.invoke(context, term);
            if(term == null)
              break Fail1548;
            if(true)
              break Success558;
          }
          term = term623;
          IStrategoTerm term624 = term;
          Success559:
          { 
            Fail1549:
            { 
              IStrategoTerm i_32785 = null;
              IStrategoTerm j_32785 = null;
              IStrategoTerm k_32785 = null;
              IStrategoTerm l_32785 = null;
              IStrategoTerm m_32785 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1549;
              i_32785 = ((IStrategoList)term).head();
              j_32785 = ((IStrategoList)term).tail();
              IStrategoList annos32 = term.getAnnotations();
              m_32785 = annos32;
              k_32785 = i_32785;
              term = this.invoke(context, j_32785);
              if(term == null)
                break Fail1549;
              l_32785 = term;
              IStrategoList list47;
              list47 = checkListTail(l_32785);
              if(list47 == null)
                break Fail1549;
              term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(k_32785, list47), checkListAnnos(termFactory, m_32785));
              if(true)
                break Success559;
            }
            term = term624;
            if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
              break Fail1546;
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}