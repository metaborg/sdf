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

@SuppressWarnings("all") public class $Sdf2$Parenthesize_0_0 extends Strategy 
{ 
  public static $Sdf2$Parenthesize_0_0 instance = new $Sdf2$Parenthesize_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail316:
    { 
      IStrategoTerm term329 = term;
      IStrategoConstructor cons25 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success223:
      { 
        if(cons25 == Main._conscomp_1)
        { 
          Fail317:
          { 
            IStrategoTerm a_9744 = null;
            a_9744 = term.getSubterm(0);
            term = a_9744;
            IStrategoTerm term330 = term;
            IStrategoConstructor cons26 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
            Success224:
            { 
              if(cons26 == Main._consunion_2)
              { 
                Fail318:
                { 
                  if(true)
                    break Success224;
                }
                term = term330;
              }
              Success225:
              { 
                if(cons26 == Main._consisect_2)
                { 
                  Fail319:
                  { 
                    if(true)
                      break Success225;
                  }
                  term = term330;
                }
                if(cons26 == Main._consdiff_2)
                { }
                else
                { 
                  break Fail317;
                }
              }
            }
            term = termFactory.makeAppl(Main._conscomp_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{a_9744})});
            if(true)
              break Success223;
          }
          term = term329;
        }
        Success226:
        { 
          if(cons25 == Main._consdiff_2)
          { 
            Fail320:
            { 
              IStrategoTerm x_9743 = null;
              IStrategoTerm y_9743 = null;
              y_9743 = term.getSubterm(0);
              x_9743 = term.getSubterm(1);
              term = y_9743;
              IStrategoTerm term333 = term;
              IStrategoConstructor cons27 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
              Success227:
              { 
                if(cons27 == Main._consunion_2)
                { 
                  Fail321:
                  { 
                    if(true)
                      break Success227;
                  }
                  term = term333;
                }
                if(cons27 == Main._consisect_2)
                { }
                else
                { 
                  break Fail320;
                }
              }
              term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{y_9743}), x_9743});
              if(true)
                break Success226;
            }
            term = term329;
          }
          Success228:
          { 
            if(cons25 == Main._consdiff_2)
            { 
              Fail322:
              { 
                IStrategoTerm u_9743 = null;
                IStrategoTerm v_9743 = null;
                u_9743 = term.getSubterm(0);
                v_9743 = term.getSubterm(1);
                term = v_9743;
                IStrategoTerm term335 = term;
                IStrategoConstructor cons28 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                Success229:
                { 
                  if(cons28 == Main._consunion_2)
                  { 
                    Fail323:
                    { 
                      if(true)
                        break Success229;
                    }
                    term = term335;
                  }
                  Success230:
                  { 
                    if(cons28 == Main._consisect_2)
                    { 
                      Fail324:
                      { 
                        if(true)
                          break Success230;
                      }
                      term = term335;
                    }
                    if(cons28 == Main._consdiff_2)
                    { }
                    else
                    { 
                      break Fail322;
                    }
                  }
                }
                term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{u_9743, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{v_9743})});
                if(true)
                  break Success228;
              }
              term = term329;
            }
            Success231:
            { 
              if(cons25 == Main._consiter_1)
              { 
                Fail325:
                { 
                  IStrategoTerm s_9743 = null;
                  s_9743 = term.getSubterm(0);
                  term = s_9743;
                  IStrategoTerm term338 = term;
                  IStrategoConstructor cons29 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                  Success232:
                  { 
                    if(cons29 == Main._conslabel_2)
                    { 
                      Fail326:
                      { 
                        if(true)
                          break Success232;
                      }
                      term = term338;
                    }
                    if(cons29 == Main._consalt_2)
                    { }
                    else
                    { 
                      break Fail325;
                    }
                  }
                  term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{s_9743})});
                  if(true)
                    break Success231;
                }
                term = term329;
              }
              Success233:
              { 
                if(cons25 == Main._consiter_star_1)
                { 
                  Fail327:
                  { 
                    IStrategoTerm q_9743 = null;
                    q_9743 = term.getSubterm(0);
                    term = q_9743;
                    IStrategoTerm term340 = term;
                    IStrategoConstructor cons30 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                    Success234:
                    { 
                      if(cons30 == Main._conslabel_2)
                      { 
                        Fail328:
                        { 
                          if(true)
                            break Success234;
                        }
                        term = term340;
                      }
                      if(cons30 == Main._consalt_2)
                      { }
                      else
                      { 
                        break Fail327;
                      }
                    }
                    term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{q_9743})});
                    if(true)
                      break Success233;
                  }
                  term = term329;
                }
                Success235:
                { 
                  if(cons25 == Main._consopt_1)
                  { 
                    Fail329:
                    { 
                      IStrategoTerm o_9743 = null;
                      o_9743 = term.getSubterm(0);
                      term = o_9743;
                      IStrategoTerm term342 = term;
                      IStrategoConstructor cons31 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                      Success236:
                      { 
                        if(cons31 == Main._conslabel_2)
                        { 
                          Fail330:
                          { 
                            if(true)
                              break Success236;
                          }
                          term = term342;
                        }
                        if(cons31 == Main._consalt_2)
                        { }
                        else
                        { 
                          break Fail329;
                        }
                      }
                      term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{o_9743})});
                      if(true)
                        break Success235;
                    }
                    term = term329;
                  }
                  Success237:
                  { 
                    if(cons25 == Main._consalt_2)
                    { 
                      Fail331:
                      { 
                        IStrategoTerm l_9743 = null;
                        IStrategoTerm m_9743 = null;
                        m_9743 = term.getSubterm(0);
                        l_9743 = term.getSubterm(1);
                        term = m_9743;
                        IStrategoTerm term344 = term;
                        IStrategoConstructor cons32 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                        Success238:
                        { 
                          if(cons32 == Main._conslabel_2)
                          { 
                            Fail332:
                            { 
                              if(true)
                                break Success238;
                            }
                            term = term344;
                          }
                          if(cons32 == Main._consalt_2)
                          { }
                          else
                          { 
                            break Fail331;
                          }
                        }
                        term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{m_9743}), l_9743});
                        if(true)
                          break Success237;
                      }
                      term = term329;
                    }
                    Success239:
                    { 
                      if(cons25 == Main._consalt_2)
                      { 
                        Fail333:
                        { 
                          IStrategoTerm i_9743 = null;
                          IStrategoTerm j_9743 = null;
                          i_9743 = term.getSubterm(0);
                          j_9743 = term.getSubterm(1);
                          term = j_9743;
                          if(term.getTermType() != IStrategoTerm.APPL || Main._conslabel_2 != ((IStrategoAppl)term).getConstructor())
                            break Fail333;
                          term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{i_9743, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{j_9743})});
                          if(true)
                            break Success239;
                        }
                        term = term329;
                      }
                      Success240:
                      { 
                        if(cons25 == Main._consseq_2)
                        { 
                          Fail334:
                          { 
                            IStrategoTerm f_9743 = null;
                            IStrategoTerm g_9743 = null;
                            g_9743 = term.getSubterm(0);
                            f_9743 = term.getSubterm(1);
                            term = g_9743;
                            if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                              break Fail334;
                            term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{g_9743}), f_9743});
                            if(true)
                              break Success240;
                          }
                          term = term329;
                        }
                        Success241:
                        { 
                          if(cons25 == Main._consseq_2)
                          { 
                            Fail335:
                            { 
                              IStrategoTerm c_9743 = null;
                              IStrategoTerm d_9743 = null;
                              c_9743 = term.getSubterm(0);
                              d_9743 = term.getSubterm(1);
                              term = d_9743;
                              if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                                break Fail335;
                              term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{c_9743, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{d_9743})});
                              if(true)
                                break Success241;
                            }
                            term = term329;
                          }
                          Success242:
                          { 
                            if(cons25 == Main._consisect_2)
                            { 
                              Fail336:
                              { 
                                IStrategoTerm z_9742 = null;
                                IStrategoTerm a_9743 = null;
                                a_9743 = term.getSubterm(0);
                                z_9742 = term.getSubterm(1);
                                term = a_9743;
                                if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                  break Fail336;
                                term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{a_9743}), z_9742});
                                if(true)
                                  break Success242;
                              }
                              term = term329;
                            }
                            Success243:
                            { 
                              if(cons25 == Main._consisect_2)
                              { 
                                Fail337:
                                { 
                                  IStrategoTerm w_9742 = null;
                                  IStrategoTerm x_9742 = null;
                                  w_9742 = term.getSubterm(0);
                                  x_9742 = term.getSubterm(1);
                                  term = x_9742;
                                  IStrategoTerm term350 = term;
                                  IStrategoConstructor cons33 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                                  Success244:
                                  { 
                                    if(cons33 == Main._consunion_2)
                                    { 
                                      Fail338:
                                      { 
                                        if(true)
                                          break Success244;
                                      }
                                      term = term350;
                                    }
                                    if(cons33 == Main._consisect_2)
                                    { }
                                    else
                                    { 
                                      break Fail337;
                                    }
                                  }
                                  term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{w_9742, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{x_9742})});
                                  if(true)
                                    break Success243;
                                }
                                term = term329;
                              }
                              Success245:
                              { 
                                if(cons25 == Main._consnon_transitive_1)
                                { 
                                  Fail339:
                                  { 
                                    IStrategoTerm u_9742 = null;
                                    u_9742 = term.getSubterm(0);
                                    term = u_9742;
                                    if(term.getTermType() != IStrategoTerm.APPL || Main._consnon_transitive_1 != ((IStrategoAppl)term).getConstructor())
                                      break Fail339;
                                    term = termFactory.makeAppl(Main._consnon_transitive_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{u_9742})});
                                    if(true)
                                      break Success245;
                                  }
                                  term = term329;
                                }
                                Success246:
                                { 
                                  if(cons25 == Main._consunion_2)
                                  { 
                                    Fail340:
                                    { 
                                      IStrategoTerm r_9742 = null;
                                      IStrategoTerm s_9742 = null;
                                      r_9742 = term.getSubterm(0);
                                      s_9742 = term.getSubterm(1);
                                      term = s_9742;
                                      if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                        break Fail340;
                                      term = termFactory.makeAppl(Main._consunion_2, new IStrategoTerm[]{r_9742, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{s_9742})});
                                      if(true)
                                        break Success246;
                                    }
                                    term = term329;
                                  }
                                  Success247:
                                  { 
                                    if(cons25 == Main._consconc_2)
                                    { 
                                      Fail341:
                                      { 
                                        IStrategoTerm o_9742 = null;
                                        IStrategoTerm p_9742 = null;
                                        p_9742 = term.getSubterm(0);
                                        o_9742 = term.getSubterm(1);
                                        term = p_9742;
                                        if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_2 != ((IStrategoAppl)term).getConstructor())
                                          break Fail341;
                                        term = termFactory.makeAppl(Main._consconc_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{p_9742}), o_9742});
                                        if(true)
                                          break Success247;
                                      }
                                      term = term329;
                                    }
                                    Success248:
                                    { 
                                      if(cons25 == Main._conswith_arguments_2)
                                      { 
                                        Fail342:
                                        { 
                                          IStrategoTerm l_9742 = null;
                                          IStrategoTerm m_9742 = null;
                                          m_9742 = term.getSubterm(0);
                                          l_9742 = term.getSubterm(1);
                                          term = m_9742;
                                          if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                            break Fail342;
                                          term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{m_9742}), l_9742});
                                          if(true)
                                            break Success248;
                                        }
                                        term = term329;
                                      }
                                      Success249:
                                      { 
                                        if(cons25 == Main._conswith_arguments_2)
                                        { 
                                          Fail343:
                                          { 
                                            IStrategoTerm i_9742 = null;
                                            IStrategoTerm j_9742 = null;
                                            i_9742 = term.getSubterm(0);
                                            j_9742 = term.getSubterm(1);
                                            term = j_9742;
                                            if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                              break Fail343;
                                            term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{i_9742, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{j_9742})});
                                            if(true)
                                              break Success249;
                                          }
                                          term = term329;
                                        }
                                        if(cons25 == Main._consconc_grammars_2)
                                        { 
                                          IStrategoTerm f_9742 = null;
                                          IStrategoTerm g_9742 = null;
                                          f_9742 = term.getSubterm(0);
                                          g_9742 = term.getSubterm(1);
                                          term = g_9742;
                                          if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_grammars_2 != ((IStrategoAppl)term).getConstructor())
                                            break Fail316;
                                          term = termFactory.makeAppl(Main._consconc_grammars_2, new IStrategoTerm[]{f_9742, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{g_9742})});
                                        }
                                        else
                                        { 
                                          break Fail316;
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
        return term;
    }
    context.push("Sdf2Parenthesize_0_0");
    context.popOnFailure();
    return null;
  }
}