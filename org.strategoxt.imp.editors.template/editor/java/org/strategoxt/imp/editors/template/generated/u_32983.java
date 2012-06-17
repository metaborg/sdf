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

@SuppressWarnings("all") final class u_32983 extends Strategy 
{ 
  public static final u_32983 instance = new u_32983();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1553:
    { 
      IStrategoTerm term557 = term;
      Success560:
      { 
        Fail1554:
        { 
          IStrategoTerm term558 = term;
          IStrategoConstructor cons52 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
          Success561:
          { 
            if(cons52 == Main._conscomp_1)
            { 
              Fail1555:
              { 
                IStrategoTerm w_32981 = null;
                w_32981 = term.getSubterm(0);
                term = w_32981;
                IStrategoTerm term559 = term;
                IStrategoConstructor cons53 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                Success562:
                { 
                  if(cons53 == Main._consunion_2)
                  { 
                    Fail1556:
                    { 
                      if(true)
                        break Success562;
                    }
                    term = term559;
                  }
                  Success563:
                  { 
                    if(cons53 == Main._consisect_2)
                    { 
                      Fail1557:
                      { 
                        if(true)
                          break Success563;
                      }
                      term = term559;
                    }
                    if(cons53 == Main._consdiff_2)
                    { }
                    else
                    { 
                      break Fail1555;
                    }
                  }
                }
                term = termFactory.makeAppl(Main._conscomp_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{w_32981})});
                term = this.invoke(context, term);
                if(term == null)
                  break Fail1555;
                if(true)
                  break Success561;
              }
              term = term558;
            }
            Success564:
            { 
              if(cons52 == Main._consdiff_2)
              { 
                Fail1558:
                { 
                  IStrategoTerm y_32981 = null;
                  IStrategoTerm z_32981 = null;
                  z_32981 = term.getSubterm(0);
                  y_32981 = term.getSubterm(1);
                  term = z_32981;
                  IStrategoTerm term562 = term;
                  IStrategoConstructor cons54 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                  Success565:
                  { 
                    if(cons54 == Main._consunion_2)
                    { 
                      Fail1559:
                      { 
                        if(true)
                          break Success565;
                      }
                      term = term562;
                    }
                    if(cons54 == Main._consisect_2)
                    { }
                    else
                    { 
                      break Fail1558;
                    }
                  }
                  term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{z_32981}), y_32981});
                  term = this.invoke(context, term);
                  if(term == null)
                    break Fail1558;
                  if(true)
                    break Success564;
                }
                term = term558;
              }
              Success566:
              { 
                if(cons52 == Main._consdiff_2)
                { 
                  Fail1560:
                  { 
                    IStrategoTerm b_32982 = null;
                    IStrategoTerm c_32982 = null;
                    b_32982 = term.getSubterm(0);
                    c_32982 = term.getSubterm(1);
                    term = c_32982;
                    IStrategoTerm term564 = term;
                    IStrategoConstructor cons55 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                    Success567:
                    { 
                      if(cons55 == Main._consunion_2)
                      { 
                        Fail1561:
                        { 
                          if(true)
                            break Success567;
                        }
                        term = term564;
                      }
                      Success568:
                      { 
                        if(cons55 == Main._consisect_2)
                        { 
                          Fail1562:
                          { 
                            if(true)
                              break Success568;
                          }
                          term = term564;
                        }
                        if(cons55 == Main._consdiff_2)
                        { }
                        else
                        { 
                          break Fail1560;
                        }
                      }
                    }
                    term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{b_32982, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{c_32982})});
                    term = this.invoke(context, term);
                    if(term == null)
                      break Fail1560;
                    if(true)
                      break Success566;
                  }
                  term = term558;
                }
                Success569:
                { 
                  if(cons52 == Main._consiter_1)
                  { 
                    Fail1563:
                    { 
                      IStrategoTerm e_32982 = null;
                      e_32982 = term.getSubterm(0);
                      term = e_32982;
                      IStrategoTerm term567 = term;
                      IStrategoConstructor cons56 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                      Success570:
                      { 
                        if(cons56 == Main._conslabel_2)
                        { 
                          Fail1564:
                          { 
                            if(true)
                              break Success570;
                          }
                          term = term567;
                        }
                        if(cons56 == Main._consalt_2)
                        { }
                        else
                        { 
                          break Fail1563;
                        }
                      }
                      term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{e_32982})});
                      term = this.invoke(context, term);
                      if(term == null)
                        break Fail1563;
                      if(true)
                        break Success569;
                    }
                    term = term558;
                  }
                  Success571:
                  { 
                    if(cons52 == Main._consiter_star_1)
                    { 
                      Fail1565:
                      { 
                        IStrategoTerm g_32982 = null;
                        g_32982 = term.getSubterm(0);
                        term = g_32982;
                        IStrategoTerm term569 = term;
                        IStrategoConstructor cons57 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                        Success572:
                        { 
                          if(cons57 == Main._conslabel_2)
                          { 
                            Fail1566:
                            { 
                              if(true)
                                break Success572;
                            }
                            term = term569;
                          }
                          if(cons57 == Main._consalt_2)
                          { }
                          else
                          { 
                            break Fail1565;
                          }
                        }
                        term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{g_32982})});
                        term = this.invoke(context, term);
                        if(term == null)
                          break Fail1565;
                        if(true)
                          break Success571;
                      }
                      term = term558;
                    }
                    Success573:
                    { 
                      if(cons52 == Main._consopt_1)
                      { 
                        Fail1567:
                        { 
                          IStrategoTerm i_32982 = null;
                          i_32982 = term.getSubterm(0);
                          term = i_32982;
                          IStrategoTerm term571 = term;
                          IStrategoConstructor cons58 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                          Success574:
                          { 
                            if(cons58 == Main._conslabel_2)
                            { 
                              Fail1568:
                              { 
                                if(true)
                                  break Success574;
                              }
                              term = term571;
                            }
                            if(cons58 == Main._consalt_2)
                            { }
                            else
                            { 
                              break Fail1567;
                            }
                          }
                          term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{i_32982})});
                          term = this.invoke(context, term);
                          if(term == null)
                            break Fail1567;
                          if(true)
                            break Success573;
                        }
                        term = term558;
                      }
                      Success575:
                      { 
                        if(cons52 == Main._consalt_2)
                        { 
                          Fail1569:
                          { 
                            IStrategoTerm k_32982 = null;
                            IStrategoTerm l_32982 = null;
                            l_32982 = term.getSubterm(0);
                            k_32982 = term.getSubterm(1);
                            term = l_32982;
                            IStrategoTerm term573 = term;
                            IStrategoConstructor cons59 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                            Success576:
                            { 
                              if(cons59 == Main._conslabel_2)
                              { 
                                Fail1570:
                                { 
                                  if(true)
                                    break Success576;
                                }
                                term = term573;
                              }
                              if(cons59 == Main._consalt_2)
                              { }
                              else
                              { 
                                break Fail1569;
                              }
                            }
                            term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{l_32982}), k_32982});
                            term = this.invoke(context, term);
                            if(term == null)
                              break Fail1569;
                            if(true)
                              break Success575;
                          }
                          term = term558;
                        }
                        Success577:
                        { 
                          if(cons52 == Main._consalt_2)
                          { 
                            Fail1571:
                            { 
                              IStrategoTerm n_32982 = null;
                              IStrategoTerm o_32982 = null;
                              n_32982 = term.getSubterm(0);
                              o_32982 = term.getSubterm(1);
                              term = o_32982;
                              if(term.getTermType() != IStrategoTerm.APPL || Main._conslabel_2 != ((IStrategoAppl)term).getConstructor())
                                break Fail1571;
                              term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{n_32982, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{o_32982})});
                              term = this.invoke(context, term);
                              if(term == null)
                                break Fail1571;
                              if(true)
                                break Success577;
                            }
                            term = term558;
                          }
                          Success578:
                          { 
                            if(cons52 == Main._consseq_2)
                            { 
                              Fail1572:
                              { 
                                IStrategoTerm q_32982 = null;
                                IStrategoTerm r_32982 = null;
                                r_32982 = term.getSubterm(0);
                                q_32982 = term.getSubterm(1);
                                term = r_32982;
                                if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                                  break Fail1572;
                                term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{r_32982}), q_32982});
                                term = this.invoke(context, term);
                                if(term == null)
                                  break Fail1572;
                                if(true)
                                  break Success578;
                              }
                              term = term558;
                            }
                            Success579:
                            { 
                              if(cons52 == Main._consseq_2)
                              { 
                                Fail1573:
                                { 
                                  IStrategoTerm t_32982 = null;
                                  IStrategoTerm u_32982 = null;
                                  t_32982 = term.getSubterm(0);
                                  u_32982 = term.getSubterm(1);
                                  term = u_32982;
                                  if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                                    break Fail1573;
                                  term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{t_32982, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{u_32982})});
                                  term = this.invoke(context, term);
                                  if(term == null)
                                    break Fail1573;
                                  if(true)
                                    break Success579;
                                }
                                term = term558;
                              }
                              Success580:
                              { 
                                if(cons52 == Main._consisect_2)
                                { 
                                  Fail1574:
                                  { 
                                    IStrategoTerm w_32982 = null;
                                    IStrategoTerm x_32982 = null;
                                    x_32982 = term.getSubterm(0);
                                    w_32982 = term.getSubterm(1);
                                    term = x_32982;
                                    if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                      break Fail1574;
                                    term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{x_32982}), w_32982});
                                    term = this.invoke(context, term);
                                    if(term == null)
                                      break Fail1574;
                                    if(true)
                                      break Success580;
                                  }
                                  term = term558;
                                }
                                Success581:
                                { 
                                  if(cons52 == Main._consisect_2)
                                  { 
                                    Fail1575:
                                    { 
                                      IStrategoTerm z_32982 = null;
                                      IStrategoTerm a_32983 = null;
                                      z_32982 = term.getSubterm(0);
                                      a_32983 = term.getSubterm(1);
                                      term = a_32983;
                                      IStrategoTerm term579 = term;
                                      IStrategoConstructor cons60 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                                      Success582:
                                      { 
                                        if(cons60 == Main._consunion_2)
                                        { 
                                          Fail1576:
                                          { 
                                            if(true)
                                              break Success582;
                                          }
                                          term = term579;
                                        }
                                        if(cons60 == Main._consisect_2)
                                        { }
                                        else
                                        { 
                                          break Fail1575;
                                        }
                                      }
                                      term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{z_32982, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{a_32983})});
                                      term = this.invoke(context, term);
                                      if(term == null)
                                        break Fail1575;
                                      if(true)
                                        break Success581;
                                    }
                                    term = term558;
                                  }
                                  Success583:
                                  { 
                                    if(cons52 == Main._consnon_transitive_1)
                                    { 
                                      Fail1577:
                                      { 
                                        IStrategoTerm c_32983 = null;
                                        c_32983 = term.getSubterm(0);
                                        term = c_32983;
                                        if(term.getTermType() != IStrategoTerm.APPL || Main._consnon_transitive_1 != ((IStrategoAppl)term).getConstructor())
                                          break Fail1577;
                                        term = termFactory.makeAppl(Main._consnon_transitive_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{c_32983})});
                                        term = this.invoke(context, term);
                                        if(term == null)
                                          break Fail1577;
                                        if(true)
                                          break Success583;
                                      }
                                      term = term558;
                                    }
                                    Success584:
                                    { 
                                      if(cons52 == Main._consunion_2)
                                      { 
                                        Fail1578:
                                        { 
                                          IStrategoTerm e_32983 = null;
                                          IStrategoTerm f_32983 = null;
                                          e_32983 = term.getSubterm(0);
                                          f_32983 = term.getSubterm(1);
                                          term = f_32983;
                                          if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                            break Fail1578;
                                          term = termFactory.makeAppl(Main._consunion_2, new IStrategoTerm[]{e_32983, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{f_32983})});
                                          term = this.invoke(context, term);
                                          if(term == null)
                                            break Fail1578;
                                          if(true)
                                            break Success584;
                                        }
                                        term = term558;
                                      }
                                      Success585:
                                      { 
                                        if(cons52 == Main._consconc_2)
                                        { 
                                          Fail1579:
                                          { 
                                            IStrategoTerm h_32983 = null;
                                            IStrategoTerm i_32983 = null;
                                            i_32983 = term.getSubterm(0);
                                            h_32983 = term.getSubterm(1);
                                            term = i_32983;
                                            if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_2 != ((IStrategoAppl)term).getConstructor())
                                              break Fail1579;
                                            term = termFactory.makeAppl(Main._consconc_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{i_32983}), h_32983});
                                            term = this.invoke(context, term);
                                            if(term == null)
                                              break Fail1579;
                                            if(true)
                                              break Success585;
                                          }
                                          term = term558;
                                        }
                                        Success586:
                                        { 
                                          if(cons52 == Main._conswith_arguments_2)
                                          { 
                                            Fail1580:
                                            { 
                                              IStrategoTerm k_32983 = null;
                                              IStrategoTerm l_32983 = null;
                                              l_32983 = term.getSubterm(0);
                                              k_32983 = term.getSubterm(1);
                                              term = l_32983;
                                              if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                                break Fail1580;
                                              term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{l_32983}), k_32983});
                                              term = this.invoke(context, term);
                                              if(term == null)
                                                break Fail1580;
                                              if(true)
                                                break Success586;
                                            }
                                            term = term558;
                                          }
                                          Success587:
                                          { 
                                            if(cons52 == Main._conswith_arguments_2)
                                            { 
                                              Fail1581:
                                              { 
                                                IStrategoTerm n_32983 = null;
                                                IStrategoTerm o_32983 = null;
                                                n_32983 = term.getSubterm(0);
                                                o_32983 = term.getSubterm(1);
                                                term = o_32983;
                                                if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                                  break Fail1581;
                                                term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{n_32983, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{o_32983})});
                                                term = this.invoke(context, term);
                                                if(term == null)
                                                  break Fail1581;
                                                if(true)
                                                  break Success587;
                                              }
                                              term = term558;
                                            }
                                            if(cons52 == Main._consconc_grammars_2)
                                            { 
                                              IStrategoTerm q_32983 = null;
                                              IStrategoTerm r_32983 = null;
                                              q_32983 = term.getSubterm(0);
                                              r_32983 = term.getSubterm(1);
                                              term = r_32983;
                                              if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_grammars_2 != ((IStrategoAppl)term).getConstructor())
                                                break Fail1554;
                                              term = termFactory.makeAppl(Main._consconc_grammars_2, new IStrategoTerm[]{q_32983, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{r_32983})});
                                              term = this.invoke(context, term);
                                              if(term == null)
                                                break Fail1554;
                                            }
                                            else
                                            { 
                                              break Fail1554;
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
              }
            }
          }
          if(true)
            break Success560;
        }
        term = term557;
      }
      if(true)
        return term;
    }
    return null;
  }
}