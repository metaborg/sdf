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

@SuppressWarnings("all") final class lifted42 extends Strategy 
{ 
  TermReference k_9711;

  TermReference l_9711;

  TermReference m_9711;

  TermReference n_9711;

  TermReference o_9711;

  TermReference p_9711;

  TermReference q_9711;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail962:
    { 
      IStrategoTerm term67 = term;
      Success392:
      { 
        Fail963:
        { 
          IStrategoTerm j_9712 = null;
          j_9712 = term;
          r_9712 r_97120 = new r_9712();
          r_97120.k_9711 = k_9711;
          term = r_97120.invoke(context, term);
          if(term == null)
            break Fail963;
          if(m_9711.value == null)
            m_9711.value = term;
          else
            if(m_9711.value != term && !m_9711.value.match(term))
              break Fail963;
          term = j_9712;
          { 
            IStrategoTerm k_9712 = null;
            IStrategoTerm l_9712 = null;
            l_9712 = term;
            if(m_9711.value == null)
              break Fail962;
            term = explode_string_0_0.instance.invoke(context, m_9711.value);
            if(term == null)
              break Fail962;
            term = occurrences_1_0.instance.invoke(context, term, lifted46.instance);
            if(term == null)
              break Fail962;
            term = dec_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail962;
            if(o_9711.value == null)
              o_9711.value = term;
            else
              if(o_9711.value != term && !o_9711.value.match(term))
                break Fail962;
            k_9712 = term;
            term = l_9712;
            IStrategoTerm term68 = term;
            Success393:
            { 
              Fail964:
              { 
                IStrategoTerm m_9712 = null;
                m_9712 = term;
                term = k_9712;
                if(term.getTermType() != IStrategoTerm.INT || -1 != ((IStrategoInt)term).intValue())
                  break Fail964;
                term = m_9712;
                { 
                  IStrategoTerm f_9713 = null;
                  IStrategoTerm h_9713 = null;
                  IStrategoTerm g_9713 = null;
                  IStrategoTerm i_9713 = null;
                  if(m_9711.value == null)
                    break Fail962;
                  term = templatelang_escape_0_0.instance.invoke(context, m_9711.value);
                  if(term == null)
                    break Fail962;
                  term = double_quote_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail962;
                  if(n_9711.value == null)
                    n_9711.value = term;
                  else
                    if(n_9711.value != term && !n_9711.value.match(term))
                      break Fail962;
                  h_9713 = term;
                  s_9712 s_97120 = new s_9712();
                  s_97120.k_9711 = k_9711;
                  term = s_97120.invoke(context, term);
                  if(term == null)
                    break Fail962;
                  f_9713 = term;
                  term = h_9713;
                  i_9713 = h_9713;
                  t_9712 t_97120 = new t_9712();
                  t_97120.l_9711 = l_9711;
                  term = t_97120.invoke(context, term);
                  if(term == null)
                    break Fail962;
                  g_9713 = term;
                  term = i_9713;
                  if(n_9711.value == null)
                    break Fail962;
                  term = termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{f_9713, (IStrategoTerm)termFactory.makeListCons(g_9713, (IStrategoList)generated.constNil0), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{n_9711.value})}), (IStrategoList)generated.constNil0)});
                  if(q_9711.value == null)
                    q_9711.value = term;
                  else
                    if(q_9711.value != term && !q_9711.value.match(term))
                      break Fail962;
                  if(true)
                    break Success393;
                }
              }
              term = term68;
              IStrategoTerm term69 = term;
              Success394:
              { 
                Fail965:
                { 
                  IStrategoTerm n_9712 = null;
                  n_9712 = term;
                  term = k_9712;
                  if(term.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)term).intValue())
                    break Fail965;
                  term = n_9712;
                  { 
                    t_9712 t_97121 = new t_9712();
                    t_97121.l_9711 = l_9711;
                    term = t_97121.invoke(context, term);
                    if(term == null)
                      break Fail962;
                    term = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar11, (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0)});
                    if(q_9711.value == null)
                      q_9711.value = term;
                    else
                      if(q_9711.value != term && !q_9711.value.match(term))
                        break Fail962;
                    if(true)
                      break Success394;
                  }
                }
                term = term69;
                IStrategoTerm l_9713 = null;
                IStrategoTerm m_9713 = null;
                if(o_9711.value == null)
                  break Fail962;
                term = int_to_string_0_0.instance.invoke(context, o_9711.value);
                if(term == null)
                  break Fail962;
                term = double_quote_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail962;
                if(p_9711.value == null)
                  p_9711.value = term;
                else
                  if(p_9711.value != term && !p_9711.value.match(term))
                    break Fail962;
                m_9713 = term;
                t_9712 t_97122 = new t_9712();
                t_97122.l_9711 = l_9711;
                term = t_97122.invoke(context, term);
                if(term == null)
                  break Fail962;
                l_9713 = term;
                term = m_9713;
                if(p_9711.value == null)
                  break Fail962;
                term = termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{generated.constSVar11, (IStrategoTerm)termFactory.makeListCons(l_9713, (IStrategoList)generated.constNil0), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{p_9711.value})}), (IStrategoList)generated.constNil0)});
                if(q_9711.value == null)
                  q_9711.value = term;
                else
                  if(q_9711.value != term && !q_9711.value.match(term))
                    break Fail962;
              }
            }
            if(true)
              break Success392;
          }
        }
        term = term67;
        IStrategoTerm n_9713 = null;
        IStrategoTerm p_9713 = null;
        p_9713 = term;
        s_9712 s_97121 = new s_9712();
        s_97121.k_9711 = k_9711;
        term = s_97121.invoke(context, term);
        if(term == null)
          break Fail962;
        n_9713 = term;
        term = p_9713;
        t_9712 t_97123 = new t_9712();
        t_97123.l_9711 = l_9711;
        term = t_97123.invoke(context, term);
        if(term == null)
          break Fail962;
        term = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{n_9713, (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0)});
        if(q_9711.value == null)
          q_9711.value = term;
        else
          if(q_9711.value != term && !q_9711.value.match(term))
            break Fail962;
      }
      if(true)
        return term;
    }
    return null;
  }
}