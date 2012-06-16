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

@SuppressWarnings("all") final class u_9948 extends Strategy 
{ 
  public static final u_9948 instance = new u_9948();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail785:
    { 
      IStrategoTerm term258 = term;
      Success335:
      { 
        Fail786:
        { 
          IStrategoTerm e_9947 = null;
          IStrategoTerm f_9947 = null;
          IStrategoTerm g_9947 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail786;
          IStrategoTerm arg371 = ((IStrategoList)term).head();
          if(arg371.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg371).intValue())
            break Fail786;
          IStrategoTerm arg372 = ((IStrategoList)term).tail();
          if(arg372.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg372).isEmpty())
            break Fail786;
          IStrategoTerm arg373 = ((IStrategoList)arg372).head();
          if(arg373.getTermType() != IStrategoTerm.INT || 32 != ((IStrategoInt)arg373).intValue())
            break Fail786;
          e_9947 = ((IStrategoList)arg372).tail();
          g_9947 = term;
          term = this.invoke(context, e_9947);
          if(term == null)
            break Fail786;
          f_9947 = term;
          term = g_9947;
          IStrategoList list26;
          list26 = checkListTail(f_9947);
          if(list26 == null)
            break Fail786;
          term = (IStrategoTerm)termFactory.makeListCons(generated.const83, list26);
          if(true)
            break Success335;
        }
        term = term258;
        IStrategoTerm term259 = term;
        Success336:
        { 
          Fail787:
          { 
            IStrategoTerm h_9947 = null;
            IStrategoTerm i_9947 = null;
            IStrategoTerm j_9947 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail787;
            IStrategoTerm arg374 = ((IStrategoList)term).head();
            if(arg374.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg374).intValue())
              break Fail787;
            IStrategoTerm arg375 = ((IStrategoList)term).tail();
            if(arg375.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg375).isEmpty())
              break Fail787;
            IStrategoTerm arg376 = ((IStrategoList)arg375).head();
            if(arg376.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg376).intValue())
              break Fail787;
            h_9947 = ((IStrategoList)arg375).tail();
            j_9947 = term;
            term = this.invoke(context, h_9947);
            if(term == null)
              break Fail787;
            i_9947 = term;
            term = j_9947;
            IStrategoList list27;
            list27 = checkListTail(i_9947);
            if(list27 == null)
              break Fail787;
            term = (IStrategoTerm)termFactory.makeListCons(generated.const99, list27);
            if(true)
              break Success336;
          }
          term = term259;
          IStrategoTerm term260 = term;
          Success337:
          { 
            Fail788:
            { 
              IStrategoTerm k_9947 = null;
              IStrategoTerm l_9947 = null;
              IStrategoTerm m_9947 = null;
              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                break Fail788;
              IStrategoTerm arg377 = ((IStrategoList)term).head();
              if(arg377.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg377).intValue())
                break Fail788;
              IStrategoTerm arg378 = ((IStrategoList)term).tail();
              if(arg378.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg378).isEmpty())
                break Fail788;
              IStrategoTerm arg379 = ((IStrategoList)arg378).head();
              if(arg379.getTermType() != IStrategoTerm.INT || 34 != ((IStrategoInt)arg379).intValue())
                break Fail788;
              k_9947 = ((IStrategoList)arg378).tail();
              m_9947 = term;
              term = this.invoke(context, k_9947);
              if(term == null)
                break Fail788;
              l_9947 = term;
              term = m_9947;
              IStrategoList list28;
              list28 = checkListTail(l_9947);
              if(list28 == null)
                break Fail788;
              term = (IStrategoTerm)termFactory.makeListCons(generated.const100, list28);
              if(true)
                break Success337;
            }
            term = term260;
            IStrategoTerm term261 = term;
            Success338:
            { 
              Fail789:
              { 
                IStrategoTerm n_9947 = null;
                IStrategoTerm o_9947 = null;
                IStrategoTerm p_9947 = null;
                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                  break Fail789;
                IStrategoTerm arg380 = ((IStrategoList)term).head();
                if(arg380.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg380).intValue())
                  break Fail789;
                IStrategoTerm arg381 = ((IStrategoList)term).tail();
                if(arg381.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg381).isEmpty())
                  break Fail789;
                IStrategoTerm arg382 = ((IStrategoList)arg381).head();
                if(arg382.getTermType() != IStrategoTerm.INT || 39 != ((IStrategoInt)arg382).intValue())
                  break Fail789;
                n_9947 = ((IStrategoList)arg381).tail();
                p_9947 = term;
                term = this.invoke(context, n_9947);
                if(term == null)
                  break Fail789;
                o_9947 = term;
                term = p_9947;
                IStrategoList list29;
                list29 = checkListTail(o_9947);
                if(list29 == null)
                  break Fail789;
                term = (IStrategoTerm)termFactory.makeListCons(generated.const101, list29);
                if(true)
                  break Success338;
              }
              term = term261;
              IStrategoTerm term262 = term;
              Success339:
              { 
                Fail790:
                { 
                  IStrategoTerm q_9947 = null;
                  IStrategoTerm r_9947 = null;
                  IStrategoTerm s_9947 = null;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail790;
                  IStrategoTerm arg383 = ((IStrategoList)term).head();
                  if(arg383.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg383).intValue())
                    break Fail790;
                  IStrategoTerm arg384 = ((IStrategoList)term).tail();
                  if(arg384.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg384).isEmpty())
                    break Fail790;
                  IStrategoTerm arg385 = ((IStrategoList)arg384).head();
                  if(arg385.getTermType() != IStrategoTerm.INT || 116 != ((IStrategoInt)arg385).intValue())
                    break Fail790;
                  q_9947 = ((IStrategoList)arg384).tail();
                  s_9947 = term;
                  term = this.invoke(context, q_9947);
                  if(term == null)
                    break Fail790;
                  r_9947 = term;
                  term = s_9947;
                  IStrategoList list30;
                  list30 = checkListTail(r_9947);
                  if(list30 == null)
                    break Fail790;
                  term = (IStrategoTerm)termFactory.makeListCons(generated.const102, list30);
                  if(true)
                    break Success339;
                }
                term = term262;
                IStrategoTerm term263 = term;
                Success340:
                { 
                  Fail791:
                  { 
                    IStrategoTerm t_9947 = null;
                    IStrategoTerm u_9947 = null;
                    IStrategoTerm v_9947 = null;
                    if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                      break Fail791;
                    IStrategoTerm arg386 = ((IStrategoList)term).head();
                    if(arg386.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg386).intValue())
                      break Fail791;
                    IStrategoTerm arg387 = ((IStrategoList)term).tail();
                    if(arg387.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg387).isEmpty())
                      break Fail791;
                    IStrategoTerm arg388 = ((IStrategoList)arg387).head();
                    if(arg388.getTermType() != IStrategoTerm.INT || 114 != ((IStrategoInt)arg388).intValue())
                      break Fail791;
                    t_9947 = ((IStrategoList)arg387).tail();
                    v_9947 = term;
                    term = this.invoke(context, t_9947);
                    if(term == null)
                      break Fail791;
                    u_9947 = term;
                    term = v_9947;
                    IStrategoList list31;
                    list31 = checkListTail(u_9947);
                    if(list31 == null)
                      break Fail791;
                    term = (IStrategoTerm)termFactory.makeListCons(generated.const103, list31);
                    if(true)
                      break Success340;
                  }
                  term = term263;
                  IStrategoTerm term264 = term;
                  Success341:
                  { 
                    Fail792:
                    { 
                      IStrategoTerm w_9947 = null;
                      IStrategoTerm x_9947 = null;
                      IStrategoTerm y_9947 = null;
                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                        break Fail792;
                      IStrategoTerm arg389 = ((IStrategoList)term).head();
                      if(arg389.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg389).intValue())
                        break Fail792;
                      IStrategoTerm arg390 = ((IStrategoList)term).tail();
                      if(arg390.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg390).isEmpty())
                        break Fail792;
                      IStrategoTerm arg391 = ((IStrategoList)arg390).head();
                      if(arg391.getTermType() != IStrategoTerm.INT || 110 != ((IStrategoInt)arg391).intValue())
                        break Fail792;
                      w_9947 = ((IStrategoList)arg390).tail();
                      y_9947 = term;
                      term = this.invoke(context, w_9947);
                      if(term == null)
                        break Fail792;
                      x_9947 = term;
                      term = y_9947;
                      IStrategoList list32;
                      list32 = checkListTail(x_9947);
                      if(list32 == null)
                        break Fail792;
                      term = (IStrategoTerm)termFactory.makeListCons(generated.const104, list32);
                      if(true)
                        break Success341;
                    }
                    term = term264;
                    IStrategoTerm term265 = term;
                    Success342:
                    { 
                      Fail793:
                      { 
                        IStrategoTerm z_9947 = null;
                        IStrategoTerm a_9948 = null;
                        IStrategoTerm b_9948 = null;
                        if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                          break Fail793;
                        IStrategoTerm arg392 = ((IStrategoList)term).head();
                        if(arg392.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg392).intValue())
                          break Fail793;
                        IStrategoTerm arg393 = ((IStrategoList)term).tail();
                        if(arg393.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg393).isEmpty())
                          break Fail793;
                        IStrategoTerm arg394 = ((IStrategoList)arg393).head();
                        if(arg394.getTermType() != IStrategoTerm.INT || 60 != ((IStrategoInt)arg394).intValue())
                          break Fail793;
                        z_9947 = ((IStrategoList)arg393).tail();
                        b_9948 = term;
                        term = this.invoke(context, z_9947);
                        if(term == null)
                          break Fail793;
                        a_9948 = term;
                        term = b_9948;
                        IStrategoList list33;
                        list33 = checkListTail(a_9948);
                        if(list33 == null)
                          break Fail793;
                        term = (IStrategoTerm)termFactory.makeListCons(generated.const105, list33);
                        if(true)
                          break Success342;
                      }
                      term = term265;
                      IStrategoTerm term266 = term;
                      Success343:
                      { 
                        Fail794:
                        { 
                          IStrategoTerm c_9948 = null;
                          IStrategoTerm d_9948 = null;
                          IStrategoTerm e_9948 = null;
                          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                            break Fail794;
                          IStrategoTerm arg395 = ((IStrategoList)term).head();
                          if(arg395.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg395).intValue())
                            break Fail794;
                          IStrategoTerm arg396 = ((IStrategoList)term).tail();
                          if(arg396.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg396).isEmpty())
                            break Fail794;
                          IStrategoTerm arg397 = ((IStrategoList)arg396).head();
                          if(arg397.getTermType() != IStrategoTerm.INT || 62 != ((IStrategoInt)arg397).intValue())
                            break Fail794;
                          c_9948 = ((IStrategoList)arg396).tail();
                          e_9948 = term;
                          term = this.invoke(context, c_9948);
                          if(term == null)
                            break Fail794;
                          d_9948 = term;
                          term = e_9948;
                          IStrategoList list34;
                          list34 = checkListTail(d_9948);
                          if(list34 == null)
                            break Fail794;
                          term = (IStrategoTerm)termFactory.makeListCons(generated.const106, list34);
                          if(true)
                            break Success343;
                        }
                        term = term266;
                        IStrategoTerm term267 = term;
                        Success344:
                        { 
                          Fail795:
                          { 
                            IStrategoTerm f_9948 = null;
                            IStrategoTerm g_9948 = null;
                            IStrategoTerm h_9948 = null;
                            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                              break Fail795;
                            IStrategoTerm arg398 = ((IStrategoList)term).head();
                            if(arg398.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg398).intValue())
                              break Fail795;
                            IStrategoTerm arg399 = ((IStrategoList)term).tail();
                            if(arg399.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg399).isEmpty())
                              break Fail795;
                            IStrategoTerm arg400 = ((IStrategoList)arg399).head();
                            if(arg400.getTermType() != IStrategoTerm.INT || 91 != ((IStrategoInt)arg400).intValue())
                              break Fail795;
                            f_9948 = ((IStrategoList)arg399).tail();
                            h_9948 = term;
                            term = this.invoke(context, f_9948);
                            if(term == null)
                              break Fail795;
                            g_9948 = term;
                            term = h_9948;
                            IStrategoList list35;
                            list35 = checkListTail(g_9948);
                            if(list35 == null)
                              break Fail795;
                            term = (IStrategoTerm)termFactory.makeListCons(generated.const107, list35);
                            if(true)
                              break Success344;
                          }
                          term = term267;
                          IStrategoTerm term268 = term;
                          Success345:
                          { 
                            Fail796:
                            { 
                              IStrategoTerm i_9948 = null;
                              IStrategoTerm j_9948 = null;
                              IStrategoTerm k_9948 = null;
                              if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                break Fail796;
                              IStrategoTerm arg401 = ((IStrategoList)term).head();
                              if(arg401.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg401).intValue())
                                break Fail796;
                              IStrategoTerm arg402 = ((IStrategoList)term).tail();
                              if(arg402.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg402).isEmpty())
                                break Fail796;
                              IStrategoTerm arg403 = ((IStrategoList)arg402).head();
                              if(arg403.getTermType() != IStrategoTerm.INT || 93 != ((IStrategoInt)arg403).intValue())
                                break Fail796;
                              i_9948 = ((IStrategoList)arg402).tail();
                              k_9948 = term;
                              term = this.invoke(context, i_9948);
                              if(term == null)
                                break Fail796;
                              j_9948 = term;
                              term = k_9948;
                              IStrategoList list36;
                              list36 = checkListTail(j_9948);
                              if(list36 == null)
                                break Fail796;
                              term = (IStrategoTerm)termFactory.makeListCons(generated.const108, list36);
                              if(true)
                                break Success345;
                            }
                            term = term268;
                            IStrategoTerm term269 = term;
                            Success346:
                            { 
                              Fail797:
                              { 
                                IStrategoTerm l_9948 = null;
                                IStrategoTerm m_9948 = null;
                                IStrategoTerm n_9948 = null;
                                IStrategoTerm o_9948 = null;
                                IStrategoTerm p_9948 = null;
                                IStrategoTerm q_9948 = null;
                                IStrategoTerm v_9948 = null;
                                IStrategoTerm w_9948 = null;
                                IStrategoTerm x_9948 = null;
                                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                  break Fail797;
                                IStrategoTerm arg404 = ((IStrategoList)term).head();
                                if(arg404.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg404).intValue())
                                  break Fail797;
                                IStrategoTerm arg405 = ((IStrategoList)term).tail();
                                if(arg405.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg405).isEmpty())
                                  break Fail797;
                                IStrategoTerm arg406 = ((IStrategoList)arg405).head();
                                if(arg406.getTermType() != IStrategoTerm.INT || 117 != ((IStrategoInt)arg406).intValue())
                                  break Fail797;
                                l_9948 = ((IStrategoList)arg405).tail();
                                term = l_9948;
                                IStrategoTerm term270 = term;
                                Success347:
                                { 
                                  Fail798:
                                  { 
                                    IStrategoTerm y_9948 = null;
                                    IStrategoTerm z_9948 = null;
                                    term = split_fetch_keep_1_0.instance.invoke(context, term, lifted206.instance);
                                    if(term == null)
                                      break Fail798;
                                    if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 3)
                                      break Fail798;
                                    v_9948 = term.getSubterm(0);
                                    w_9948 = term.getSubterm(1);
                                    x_9948 = term.getSubterm(2);
                                    z_9948 = term;
                                    term = hex_chars_to_int_0_0.instance.invoke(context, v_9948);
                                    if(term == null)
                                      break Fail798;
                                    y_9948 = term;
                                    term = z_9948;
                                    IStrategoList list37;
                                    list37 = checkListTail(x_9948);
                                    if(list37 == null)
                                      break Fail798;
                                    term = (IStrategoTerm)termFactory.makeListCons(y_9948, termFactory.makeListCons(w_9948, list37));
                                    if(true)
                                      break Success347;
                                  }
                                  term = term270;
                                  term = hex_chars_to_int_0_0.instance.invoke(context, term);
                                  if(term == null)
                                    break Fail797;
                                  term = (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil0);
                                }
                                if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                  break Fail797;
                                m_9948 = ((IStrategoList)term).head();
                                n_9948 = ((IStrategoList)term).tail();
                                IStrategoList annos13 = term.getAnnotations();
                                q_9948 = annos13;
                                o_9948 = m_9948;
                                term = this.invoke(context, n_9948);
                                if(term == null)
                                  break Fail797;
                                p_9948 = term;
                                IStrategoList list38;
                                list38 = checkListTail(p_9948);
                                if(list38 == null)
                                  break Fail797;
                                term = termFactory.annotateTerm((IStrategoTerm)termFactory.makeListCons(o_9948, list38), checkListAnnos(termFactory, q_9948));
                                if(true)
                                  break Success346;
                              }
                              term = term269;
                              IStrategoTerm term272 = term;
                              Success348:
                              { 
                                Fail799:
                                { 
                                  IStrategoTerm r_9948 = null;
                                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                    break Fail799;
                                  IStrategoTerm arg407 = ((IStrategoList)term).head();
                                  if(arg407.getTermType() != IStrategoTerm.INT || 60 != ((IStrategoInt)arg407).intValue())
                                    break Fail799;
                                  IStrategoTerm arg408 = ((IStrategoList)term).tail();
                                  if(arg408.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg408).isEmpty())
                                    break Fail799;
                                  IStrategoTerm arg409 = ((IStrategoList)arg408).head();
                                  if(arg409.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg409).intValue())
                                    break Fail799;
                                  IStrategoTerm arg410 = ((IStrategoList)arg408).tail();
                                  if(arg410.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg410).isEmpty())
                                    break Fail799;
                                  IStrategoTerm arg411 = ((IStrategoList)arg410).head();
                                  if(arg411.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg411).intValue())
                                    break Fail799;
                                  IStrategoTerm arg412 = ((IStrategoList)arg410).tail();
                                  if(arg412.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg412).isEmpty())
                                    break Fail799;
                                  IStrategoTerm arg413 = ((IStrategoList)arg412).head();
                                  if(arg413.getTermType() != IStrategoTerm.INT || 62 != ((IStrategoInt)arg413).intValue())
                                    break Fail799;
                                  r_9948 = ((IStrategoList)arg412).tail();
                                  term = this.invoke(context, r_9948);
                                  if(term == null)
                                    break Fail799;
                                  if(true)
                                    break Success348;
                                }
                                term = term272;
                                IStrategoTerm term273 = term;
                                Success349:
                                { 
                                  Fail800:
                                  { 
                                    IStrategoTerm s_9948 = null;
                                    if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                      break Fail800;
                                    IStrategoTerm arg414 = ((IStrategoList)term).head();
                                    if(arg414.getTermType() != IStrategoTerm.INT || 91 != ((IStrategoInt)arg414).intValue())
                                      break Fail800;
                                    IStrategoTerm arg415 = ((IStrategoList)term).tail();
                                    if(arg415.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg415).isEmpty())
                                      break Fail800;
                                    IStrategoTerm arg416 = ((IStrategoList)arg415).head();
                                    if(arg416.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg416).intValue())
                                      break Fail800;
                                    IStrategoTerm arg417 = ((IStrategoList)arg415).tail();
                                    if(arg417.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg417).isEmpty())
                                      break Fail800;
                                    IStrategoTerm arg418 = ((IStrategoList)arg417).head();
                                    if(arg418.getTermType() != IStrategoTerm.INT || 92 != ((IStrategoInt)arg418).intValue())
                                      break Fail800;
                                    IStrategoTerm arg419 = ((IStrategoList)arg417).tail();
                                    if(arg419.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg419).isEmpty())
                                      break Fail800;
                                    IStrategoTerm arg420 = ((IStrategoList)arg419).head();
                                    if(arg420.getTermType() != IStrategoTerm.INT || 93 != ((IStrategoInt)arg420).intValue())
                                      break Fail800;
                                    s_9948 = ((IStrategoList)arg419).tail();
                                    term = this.invoke(context, s_9948);
                                    if(term == null)
                                      break Fail800;
                                    if(true)
                                      break Success349;
                                  }
                                  term = term273;
                                  IStrategoTerm term274 = term;
                                  Success350:
                                  { 
                                    Fail801:
                                    { 
                                      IStrategoTerm t_9948 = null;
                                      if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                                        break Fail801;
                                      t_9948 = ((IStrategoList)term).tail();
                                      term = this.invoke(context, t_9948);
                                      if(term == null)
                                        break Fail801;
                                      if(true)
                                        break Success350;
                                    }
                                    term = term274;
                                    if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                                      break Fail785;
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