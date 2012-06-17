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
    Fail995:
    { 
      IStrategoTerm term435 = term;
      Success383:
      { 
        Fail996:
        { 
          IStrategoTerm o_32764 = null;
          IStrategoTerm p_32764 = null;
          IStrategoTerm q_32764 = null;
          IStrategoTerm r_32764 = null;
          IStrategoTerm s_32764 = null;
          IStrategoTerm t_32764 = null;
          IStrategoTerm u_32764 = null;
          IStrategoTerm v_32764 = null;
          IStrategoTerm w_32764 = null;
          IStrategoTerm x_32764 = null;
          IStrategoTerm y_32764 = null;
          IStrategoTerm z_32764 = null;
          IStrategoTerm a_32765 = null;
          IStrategoTerm b_32765 = null;
          IStrategoTerm c_32765 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail996;
          o_32764 = ((IStrategoList)term).head();
          p_32764 = ((IStrategoList)term).tail();
          IStrategoList annos23 = term.getAnnotations();
          s_32764 = annos23;
          term = o_32764;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail996;
          t_32764 = ((IStrategoList)term).head();
          u_32764 = ((IStrategoList)term).tail();
          IStrategoList annos24 = term.getAnnotations();
          x_32764 = annos24;
          v_32764 = t_32764;
          term = u_32764;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail996;
          y_32764 = ((IStrategoList)term).head();
          z_32764 = ((IStrategoList)term).tail();
          IStrategoList annos25 = term.getAnnotations();
          c_32765 = annos25;
          term = $Cursor_0_0.instance.invoke(context, y_32764);
          if(term == null)
            break Fail996;
          a_32765 = term;
          term = z_32764;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail996;
          b_32765 = term;
          IStrategoList list10;
          list10 = checkListTail(b_32765);
          if(list10 == null)
            break Fail996;
          term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(a_32765, list10), checkListAnnos(termFactory, c_32765));
          w_32764 = term;
          IStrategoList list11;
          list11 = checkListTail(w_32764);
          if(list11 == null)
            break Fail996;
          term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(v_32764, list11), checkListAnnos(termFactory, x_32764));
          q_32764 = term;
          term = remove_cursor_0_0.instance.invoke(context, p_32764);
          if(term == null)
            break Fail996;
          r_32764 = term;
          IStrategoList list12;
          list12 = checkListTail(r_32764);
          if(list12 == null)
            break Fail996;
          term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(q_32764, list12), checkListAnnos(termFactory, s_32764));
          if(true)
            break Success383;
        }
        term = term435;
        IStrategoTerm term436 = term;
        Success384:
        { 
          Fail997:
          { 
            IStrategoTerm d_32765 = null;
            IStrategoTerm e_32765 = null;
            IStrategoTerm f_32765 = null;
            IStrategoTerm g_32765 = null;
            IStrategoTerm h_32765 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail997;
            d_32765 = ((IStrategoList)term).head();
            e_32765 = ((IStrategoList)term).tail();
            IStrategoList annos26 = term.getAnnotations();
            h_32765 = annos26;
            f_32765 = d_32765;
            term = this.invoke(context, e_32765);
            if(term == null)
              break Fail997;
            g_32765 = term;
            IStrategoList list13;
            list13 = checkListTail(g_32765);
            if(list13 == null)
              break Fail997;
            term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(f_32765, list13), checkListAnnos(termFactory, h_32765));
            if(true)
              break Success384;
          }
          term = term436;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail995;
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