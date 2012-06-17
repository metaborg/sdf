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

@SuppressWarnings("all") final class d_32987 extends Strategy 
{ 
  public static final d_32987 instance = new d_32987();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1605:
    { 
      IStrategoTerm term514 = term;
      Success591:
      { 
        Fail1606:
        { 
          IStrategoTerm n_32985 = null;
          IStrategoTerm o_32985 = null;
          IStrategoTerm p_32985 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1606;
          IStrategoTerm arg524 = ((IStrategoList)term).head();
          if(arg524.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg524).intValue())
            break Fail1606;
          IStrategoTerm arg525 = ((IStrategoList)term).tail();
          if(arg525.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg525).isEmpty())
            break Fail1606;
          IStrategoTerm arg526 = ((IStrategoList)arg525).head();
          if(arg526.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)arg526).intValue())
            break Fail1606;
          n_32985 = ((IStrategoList)arg525).tail();
          p_32985 = term;
          term = this.invoke(context, n_32985);
          if(term == null)
            break Fail1606;
          o_32985 = term;
          term = p_32985;
          IStrategoList list29;
          list29 = checkListTail(o_32985);
          if(list29 == null)
            break Fail1606;
          term = (IStrategoTerm)termFactory.makeListCons(generated.const204, list29);
          if(true)
            break Success591;
        }
        term = term514;
        IStrategoTerm term515 = term;
        Success592:
        { 
          Fail1607:
          { 
            IStrategoTerm q_32985 = null;
            IStrategoTerm r_32985 = null;
            IStrategoTerm s_32985 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1607;
            IStrategoTerm arg527 = ((IStrategoList)term).head();
            if(arg527.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg527).intValue())
              break Fail1607;
            IStrategoTerm arg528 = ((IStrategoList)term).tail();
            if(arg528.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg528).isEmpty())
              break Fail1607;
            IStrategoTerm arg529 = ((IStrategoList)arg528).head();
            if(arg529.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg529).intValue())
              break Fail1607;
            q_32985 = ((IStrategoList)arg528).tail();
            s_32985 = term;
            term = this.invoke(context, q_32985);
            if(term == null)
              break Fail1607;
            r_32985 = term;
            term = s_32985;
            IStrategoList list30;
            list30 = checkListTail(r_32985);
            if(list30 == null)
              break Fail1607;
            term = (IStrategoTerm)termFactory.makeListCons(generated.const220, list30);
            if(true)
              break Success592;
          }
          term = term515;
          IStrategoTerm term516 = term;
          Success593:
          { 
            Fail1608:
            { 
              IStrategoTerm t_32985 = null;
              IStrategoTerm u_32985 = null;
              IStrategoTerm v_32985 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail1608;
              IStrategoTerm arg530 = ((IStrategoList)term).head();
              if(arg530.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg530).intValue())
                break Fail1608;
              IStrategoTerm arg531 = ((IStrategoList)term).tail();
              if(arg531.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg531).isEmpty())
                break Fail1608;
              IStrategoTerm arg532 = ((IStrategoList)arg531).head();
              if(arg532.getTermType() != IStrategoTerm.INT || 34 != ((IStrategoInt)arg532).intValue())
                break Fail1608;
              t_32985 = ((IStrategoList)arg531).tail();
              v_32985 = term;
              term = this.invoke(context, t_32985);
              if(term == null)
                break Fail1608;
              u_32985 = term;
              term = v_32985;
              IStrategoList list31;
              list31 = checkListTail(u_32985);
              if(list31 == null)
                break Fail1608;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const221, list31);
              if(true)
                break Success593;
            }
            term = term516;
            IStrategoTerm term517 = term;
            Success594:
            { 
              Fail1609:
              { 
                IStrategoTerm w_32985 = null;
                IStrategoTerm x_32985 = null;
                IStrategoTerm y_32985 = null;
                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                  break Fail1609;
                IStrategoTerm arg533 = ((IStrategoList)term).head();
                if(arg533.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg533).intValue())
                  break Fail1609;
                IStrategoTerm arg534 = ((IStrategoList)term).tail();
                if(arg534.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg534).isEmpty())
                  break Fail1609;
                IStrategoTerm arg535 = ((IStrategoList)arg534).head();
                if(arg535.getTermType() != IStrategoTerm.INT || 39 != ((IStrategoInt)arg535).intValue())
                  break Fail1609;
                w_32985 = ((IStrategoList)arg534).tail();
                y_32985 = term;
                term = this.invoke(context, w_32985);
                if(term == null)
                  break Fail1609;
                x_32985 = term;
                term = y_32985;
                IStrategoList list32;
                list32 = checkListTail(x_32985);
                if(list32 == null)
                  break Fail1609;
                term = (IStrategoTerm)termFactory.makeListCons(generated.const222, list32);
                if(true)
                  break Success594;
              }
              term = term517;
              IStrategoTerm term518 = term;
              Success595:
              { 
                Fail1610:
                { 
                  IStrategoTerm z_32985 = null;
                  IStrategoTerm a_32986 = null;
                  IStrategoTerm b_32986 = null;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1610;
                  IStrategoTerm arg536 = ((IStrategoList)term).head();
                  if(arg536.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg536).intValue())
                    break Fail1610;
                  IStrategoTerm arg537 = ((IStrategoList)term).tail();
                  if(arg537.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg537).isEmpty())
                    break Fail1610;
                  IStrategoTerm arg538 = ((IStrategoList)arg537).head();
                  if(arg538.getTermType() != IStrategoTerm.INT || 116 != ((IStrategoInt)arg538).intValue())
                    break Fail1610;
                  z_32985 = ((IStrategoList)arg537).tail();
                  b_32986 = term;
                  term = this.invoke(context, z_32985);
                  if(term == null)
                    break Fail1610;
                  a_32986 = term;
                  term = b_32986;
                  IStrategoList list33;
                  list33 = checkListTail(a_32986);
                  if(list33 == null)
                    break Fail1610;
                  term = (IStrategoTerm)termFactory.makeListCons(generated.const223, list33);
                  if(true)
                    break Success595;
                }
                term = term518;
                IStrategoTerm term519 = term;
                Success596:
                { 
                  Fail1611:
                  { 
                    IStrategoTerm c_32986 = null;
                    IStrategoTerm d_32986 = null;
                    IStrategoTerm e_32986 = null;
                    if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                      break Fail1611;
                    IStrategoTerm arg539 = ((IStrategoList)term).head();
                    if(arg539.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg539).intValue())
                      break Fail1611;
                    IStrategoTerm arg540 = ((IStrategoList)term).tail();
                    if(arg540.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg540).isEmpty())
                      break Fail1611;
                    IStrategoTerm arg541 = ((IStrategoList)arg540).head();
                    if(arg541.getTermType() != IStrategoTerm.INT || 114 != ((IStrategoInt)arg541).intValue())
                      break Fail1611;
                    c_32986 = ((IStrategoList)arg540).tail();
                    e_32986 = term;
                    term = this.invoke(context, c_32986);
                    if(term == null)
                      break Fail1611;
                    d_32986 = term;
                    term = e_32986;
                    IStrategoList list34;
                    list34 = checkListTail(d_32986);
                    if(list34 == null)
                      break Fail1611;
                    term = (IStrategoTerm)termFactory.makeListCons(generated.const224, list34);
                    if(true)
                      break Success596;
                  }
                  term = term519;
                  IStrategoTerm term520 = term;
                  Success597:
                  { 
                    Fail1612:
                    { 
                      IStrategoTerm f_32986 = null;
                      IStrategoTerm g_32986 = null;
                      IStrategoTerm h_32986 = null;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail1612;
                      IStrategoTerm arg542 = ((IStrategoList)term).head();
                      if(arg542.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg542).intValue())
                        break Fail1612;
                      IStrategoTerm arg543 = ((IStrategoList)term).tail();
                      if(arg543.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg543).isEmpty())
                        break Fail1612;
                      IStrategoTerm arg544 = ((IStrategoList)arg543).head();
                      if(arg544.getTermType() != IStrategoTerm.INT || 110 != ((IStrategoInt)arg544).intValue())
                        break Fail1612;
                      f_32986 = ((IStrategoList)arg543).tail();
                      h_32986 = term;
                      term = this.invoke(context, f_32986);
                      if(term == null)
                        break Fail1612;
                      g_32986 = term;
                      term = h_32986;
                      IStrategoList list35;
                      list35 = checkListTail(g_32986);
                      if(list35 == null)
                        break Fail1612;
                      term = (IStrategoTerm)termFactory.makeListCons(generated.const225, list35);
                      if(true)
                        break Success597;
                    }
                    term = term520;
                    IStrategoTerm term521 = term;
                    Success598:
                    { 
                      Fail1613:
                      { 
                        IStrategoTerm i_32986 = null;
                        IStrategoTerm j_32986 = null;
                        IStrategoTerm k_32986 = null;
                        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                          break Fail1613;
                        IStrategoTerm arg545 = ((IStrategoList)term).head();
                        if(arg545.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg545).intValue())
                          break Fail1613;
                        IStrategoTerm arg546 = ((IStrategoList)term).tail();
                        if(arg546.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg546).isEmpty())
                          break Fail1613;
                        IStrategoTerm arg547 = ((IStrategoList)arg546).head();
                        if(arg547.getTermType() != IStrategoTerm.INT || 60 != ((IStrategoInt)arg547).intValue())
                          break Fail1613;
                        i_32986 = ((IStrategoList)arg546).tail();
                        k_32986 = term;
                        term = this.invoke(context, i_32986);
                        if(term == null)
                          break Fail1613;
                        j_32986 = term;
                        term = k_32986;
                        IStrategoList list36;
                        list36 = checkListTail(j_32986);
                        if(list36 == null)
                          break Fail1613;
                        term = (IStrategoTerm)termFactory.makeListCons(generated.const226, list36);
                        if(true)
                          break Success598;
                      }
                      term = term521;
                      IStrategoTerm term522 = term;
                      Success599:
                      { 
                        Fail1614:
                        { 
                          IStrategoTerm l_32986 = null;
                          IStrategoTerm m_32986 = null;
                          IStrategoTerm n_32986 = null;
                          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                            break Fail1614;
                          IStrategoTerm arg548 = ((IStrategoList)term).head();
                          if(arg548.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg548).intValue())
                            break Fail1614;
                          IStrategoTerm arg549 = ((IStrategoList)term).tail();
                          if(arg549.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg549).isEmpty())
                            break Fail1614;
                          IStrategoTerm arg550 = ((IStrategoList)arg549).head();
                          if(arg550.getTermType() != IStrategoTerm.INT || 62 != ((IStrategoInt)arg550).intValue())
                            break Fail1614;
                          l_32986 = ((IStrategoList)arg549).tail();
                          n_32986 = term;
                          term = this.invoke(context, l_32986);
                          if(term == null)
                            break Fail1614;
                          m_32986 = term;
                          term = n_32986;
                          IStrategoList list37;
                          list37 = checkListTail(m_32986);
                          if(list37 == null)
                            break Fail1614;
                          term = (IStrategoTerm)termFactory.makeListCons(generated.const227, list37);
                          if(true)
                            break Success599;
                        }
                        term = term522;
                        IStrategoTerm term523 = term;
                        Success600:
                        { 
                          Fail1615:
                          { 
                            IStrategoTerm o_32986 = null;
                            IStrategoTerm p_32986 = null;
                            IStrategoTerm q_32986 = null;
                            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                              break Fail1615;
                            IStrategoTerm arg551 = ((IStrategoList)term).head();
                            if(arg551.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg551).intValue())
                              break Fail1615;
                            IStrategoTerm arg552 = ((IStrategoList)term).tail();
                            if(arg552.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg552).isEmpty())
                              break Fail1615;
                            IStrategoTerm arg553 = ((IStrategoList)arg552).head();
                            if(arg553.getTermType() != IStrategoTerm.INT || 91 != ((IStrategoInt)arg553).intValue())
                              break Fail1615;
                            o_32986 = ((IStrategoList)arg552).tail();
                            q_32986 = term;
                            term = this.invoke(context, o_32986);
                            if(term == null)
                              break Fail1615;
                            p_32986 = term;
                            term = q_32986;
                            IStrategoList list38;
                            list38 = checkListTail(p_32986);
                            if(list38 == null)
                              break Fail1615;
                            term = (IStrategoTerm)termFactory.makeListCons(generated.const228, list38);
                            if(true)
                              break Success600;
                          }
                          term = term523;
                          IStrategoTerm term524 = term;
                          Success601:
                          { 
                            Fail1616:
                            { 
                              IStrategoTerm r_32986 = null;
                              IStrategoTerm s_32986 = null;
                              IStrategoTerm t_32986 = null;
                              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                break Fail1616;
                              IStrategoTerm arg554 = ((IStrategoList)term).head();
                              if(arg554.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg554).intValue())
                                break Fail1616;
                              IStrategoTerm arg555 = ((IStrategoList)term).tail();
                              if(arg555.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg555).isEmpty())
                                break Fail1616;
                              IStrategoTerm arg556 = ((IStrategoList)arg555).head();
                              if(arg556.getTermType() != IStrategoTerm.INT || 93 != ((IStrategoInt)arg556).intValue())
                                break Fail1616;
                              r_32986 = ((IStrategoList)arg555).tail();
                              t_32986 = term;
                              term = this.invoke(context, r_32986);
                              if(term == null)
                                break Fail1616;
                              s_32986 = term;
                              term = t_32986;
                              IStrategoList list39;
                              list39 = checkListTail(s_32986);
                              if(list39 == null)
                                break Fail1616;
                              term = (IStrategoTerm)termFactory.makeListCons(generated.const229, list39);
                              if(true)
                                break Success601;
                            }
                            term = term524;
                            IStrategoTerm term525 = term;
                            Success602:
                            { 
                              Fail1617:
                              { 
                                IStrategoTerm u_32986 = null;
                                IStrategoTerm v_32986 = null;
                                IStrategoTerm w_32986 = null;
                                IStrategoTerm x_32986 = null;
                                IStrategoTerm y_32986 = null;
                                IStrategoTerm z_32986 = null;
                                IStrategoTerm e_32987 = null;
                                IStrategoTerm f_32987 = null;
                                IStrategoTerm g_32987 = null;
                                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                  break Fail1617;
                                IStrategoTerm arg557 = ((IStrategoList)term).head();
                                if(arg557.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg557).intValue())
                                  break Fail1617;
                                IStrategoTerm arg558 = ((IStrategoList)term).tail();
                                if(arg558.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg558).isEmpty())
                                  break Fail1617;
                                IStrategoTerm arg559 = ((IStrategoList)arg558).head();
                                if(arg559.getTermType() != IStrategoTerm.INT || 117 != ((IStrategoInt)arg559).intValue())
                                  break Fail1617;
                                u_32986 = ((IStrategoList)arg558).tail();
                                term = u_32986;
                                IStrategoTerm term526 = term;
                                Success603:
                                { 
                                  Fail1618:
                                  { 
                                    IStrategoTerm h_32987 = null;
                                    IStrategoTerm i_32987 = null;
                                    term = split_fetch_keep_1_0.instance.invoke(context, term, lifted405.instance);
                                    if(term == null)
                                      break Fail1618;
                                    if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
                                      break Fail1618;
                                    e_32987 = term.getSubterm(0);
                                    f_32987 = term.getSubterm(1);
                                    g_32987 = term.getSubterm(2);
                                    i_32987 = term;
                                    term = hex_chars_to_int_0_0.instance.invoke(context, e_32987);
                                    if(term == null)
                                      break Fail1618;
                                    h_32987 = term;
                                    term = i_32987;
                                    IStrategoList list40;
                                    list40 = checkListTail(g_32987);
                                    if(list40 == null)
                                      break Fail1618;
                                    term = (IStrategoTerm)termFactory.makeListCons(h_32987, termFactory.makeListCons(f_32987, list40));
                                    if(true)
                                      break Success603;
                                  }
                                  term = term526;
                                  term = hex_chars_to_int_0_0.instance.invoke(context, term);
                                  if(term == null)
                                    break Fail1617;
                                  term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3);
                                }
                                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                  break Fail1617;
                                v_32986 = ((IStrategoList)term).head();
                                w_32986 = ((IStrategoList)term).tail();
                                IStrategoList annos31 = term.getAnnotations();
                                z_32986 = annos31;
                                x_32986 = v_32986;
                                term = this.invoke(context, w_32986);
                                if(term == null)
                                  break Fail1617;
                                y_32986 = term;
                                IStrategoList list41;
                                list41 = checkListTail(y_32986);
                                if(list41 == null)
                                  break Fail1617;
                                term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(x_32986, list41), checkListAnnos(termFactory, z_32986));
                                if(true)
                                  break Success602;
                              }
                              term = term525;
                              IStrategoTerm term528 = term;
                              Success604:
                              { 
                                Fail1619:
                                { 
                                  IStrategoTerm a_32987 = null;
                                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                    break Fail1619;
                                  IStrategoTerm arg560 = ((IStrategoList)term).head();
                                  if(arg560.getTermType() != IStrategoTerm.INT || 60 != ((IStrategoInt)arg560).intValue())
                                    break Fail1619;
                                  IStrategoTerm arg561 = ((IStrategoList)term).tail();
                                  if(arg561.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg561).isEmpty())
                                    break Fail1619;
                                  IStrategoTerm arg562 = ((IStrategoList)arg561).head();
                                  if(arg562.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg562).intValue())
                                    break Fail1619;
                                  IStrategoTerm arg563 = ((IStrategoList)arg561).tail();
                                  if(arg563.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg563).isEmpty())
                                    break Fail1619;
                                  IStrategoTerm arg564 = ((IStrategoList)arg563).head();
                                  if(arg564.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg564).intValue())
                                    break Fail1619;
                                  IStrategoTerm arg565 = ((IStrategoList)arg563).tail();
                                  if(arg565.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg565).isEmpty())
                                    break Fail1619;
                                  IStrategoTerm arg566 = ((IStrategoList)arg565).head();
                                  if(arg566.getTermType() != IStrategoTerm.INT || 62 != ((IStrategoInt)arg566).intValue())
                                    break Fail1619;
                                  a_32987 = ((IStrategoList)arg565).tail();
                                  term = this.invoke(context, a_32987);
                                  if(term == null)
                                    break Fail1619;
                                  if(true)
                                    break Success604;
                                }
                                term = term528;
                                IStrategoTerm term529 = term;
                                Success605:
                                { 
                                  Fail1620:
                                  { 
                                    IStrategoTerm b_32987 = null;
                                    if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                      break Fail1620;
                                    IStrategoTerm arg567 = ((IStrategoList)term).head();
                                    if(arg567.getTermType() != IStrategoTerm.INT || 91 != ((IStrategoInt)arg567).intValue())
                                      break Fail1620;
                                    IStrategoTerm arg568 = ((IStrategoList)term).tail();
                                    if(arg568.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg568).isEmpty())
                                      break Fail1620;
                                    IStrategoTerm arg569 = ((IStrategoList)arg568).head();
                                    if(arg569.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg569).intValue())
                                      break Fail1620;
                                    IStrategoTerm arg570 = ((IStrategoList)arg568).tail();
                                    if(arg570.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg570).isEmpty())
                                      break Fail1620;
                                    IStrategoTerm arg571 = ((IStrategoList)arg570).head();
                                    if(arg571.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg571).intValue())
                                      break Fail1620;
                                    IStrategoTerm arg572 = ((IStrategoList)arg570).tail();
                                    if(arg572.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg572).isEmpty())
                                      break Fail1620;
                                    IStrategoTerm arg573 = ((IStrategoList)arg572).head();
                                    if(arg573.getTermType() != IStrategoTerm.INT || 93 != ((IStrategoInt)arg573).intValue())
                                      break Fail1620;
                                    b_32987 = ((IStrategoList)arg572).tail();
                                    term = this.invoke(context, b_32987);
                                    if(term == null)
                                      break Fail1620;
                                    if(true)
                                      break Success605;
                                  }
                                  term = term529;
                                  IStrategoTerm term530 = term;
                                  Success606:
                                  { 
                                    Fail1621:
                                    { 
                                      IStrategoTerm c_32987 = null;
                                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                        break Fail1621;
                                      c_32987 = ((IStrategoList)term).tail();
                                      term = this.invoke(context, c_32987);
                                      if(term == null)
                                        break Fail1621;
                                      if(true)
                                        break Success606;
                                    }
                                    term = term530;
                                    if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                                      break Fail1605;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}