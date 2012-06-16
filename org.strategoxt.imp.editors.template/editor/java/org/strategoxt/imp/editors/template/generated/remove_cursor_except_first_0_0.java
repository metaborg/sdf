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

@SuppressWarnings("all") public class remove_cursor_except_first_0_0 extends Strategy 
{ 
  public static remove_cursor_except_first_0_0 instance = new remove_cursor_except_first_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("remove_cursor_except_first_0_0");
    Fail175:
    { 
      IStrategoTerm term179 = term;
      Success127:
      { 
        Fail176:
        { 
          IStrategoTerm f_9726 = null;
          IStrategoTerm g_9726 = null;
          IStrategoTerm h_9726 = null;
          IStrategoTerm i_9726 = null;
          IStrategoTerm j_9726 = null;
          IStrategoTerm k_9726 = null;
          IStrategoTerm l_9726 = null;
          IStrategoTerm m_9726 = null;
          IStrategoTerm n_9726 = null;
          IStrategoTerm o_9726 = null;
          IStrategoTerm p_9726 = null;
          IStrategoTerm q_9726 = null;
          IStrategoTerm r_9726 = null;
          IStrategoTerm s_9726 = null;
          IStrategoTerm t_9726 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail176;
          f_9726 = ((IStrategoList)term).head();
          g_9726 = ((IStrategoList)term).tail();
          IStrategoList annos5 = term.getAnnotations();
          j_9726 = annos5;
          term = f_9726;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail176;
          k_9726 = ((IStrategoList)term).head();
          l_9726 = ((IStrategoList)term).tail();
          IStrategoList annos6 = term.getAnnotations();
          o_9726 = annos6;
          m_9726 = k_9726;
          term = l_9726;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail176;
          p_9726 = ((IStrategoList)term).head();
          q_9726 = ((IStrategoList)term).tail();
          IStrategoList annos7 = term.getAnnotations();
          t_9726 = annos7;
          term = $Cursor_0_0.instance.invoke(context, p_9726);
          if(term == null)
            break Fail176;
          r_9726 = term;
          term = q_9726;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail176;
          s_9726 = term;
          IStrategoList list7;
          list7 = checkListTail(s_9726);
          if(list7 == null)
            break Fail176;
          term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(r_9726, list7), checkListAnnos(termFactory, t_9726));
          n_9726 = term;
          IStrategoList list8;
          list8 = checkListTail(n_9726);
          if(list8 == null)
            break Fail176;
          term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(m_9726, list8), checkListAnnos(termFactory, o_9726));
          h_9726 = term;
          term = remove_cursor_0_0.instance.invoke(context, g_9726);
          if(term == null)
            break Fail176;
          i_9726 = term;
          IStrategoList list9;
          list9 = checkListTail(i_9726);
          if(list9 == null)
            break Fail176;
          term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(h_9726, list9), checkListAnnos(termFactory, j_9726));
          if(true)
            break Success127;
        }
        term = term179;
        IStrategoTerm term180 = term;
        Success128:
        { 
          Fail177:
          { 
            IStrategoTerm u_9726 = null;
            IStrategoTerm v_9726 = null;
            IStrategoTerm w_9726 = null;
            IStrategoTerm x_9726 = null;
            IStrategoTerm y_9726 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail177;
            u_9726 = ((IStrategoList)term).head();
            v_9726 = ((IStrategoList)term).tail();
            IStrategoList annos8 = term.getAnnotations();
            y_9726 = annos8;
            w_9726 = u_9726;
            term = this.invoke(context, v_9726);
            if(term == null)
              break Fail177;
            x_9726 = term;
            IStrategoList list10;
            list10 = checkListTail(x_9726);
            if(list10 == null)
              break Fail177;
            term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(w_9726, list10), checkListAnnos(termFactory, y_9726));
            if(true)
              break Success128;
          }
          term = term180;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail175;
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