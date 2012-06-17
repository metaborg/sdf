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
    Fail1136:
    { 
      IStrategoTerm term585 = term;
      IStrategoConstructor cons37 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success479:
      { 
        if(cons37 == Main._conscomp_1)
        { 
          Fail1137:
          { 
            IStrategoTerm j_32782 = null;
            j_32782 = term.getSubterm(0);
            term = j_32782;
            IStrategoTerm term586 = term;
            IStrategoConstructor cons38 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
            Success480:
            { 
              if(cons38 == Main._consunion_2)
              { 
                Fail1138:
                { 
                  if(true)
                    break Success480;
                }
                term = term586;
              }
              Success481:
              { 
                if(cons38 == Main._consisect_2)
                { 
                  Fail1139:
                  { 
                    if(true)
                      break Success481;
                  }
                  term = term586;
                }
                if(cons38 == Main._consdiff_2)
                { }
                else
                { 
                  break Fail1137;
                }
              }
            }
            term = termFactory.makeAppl(Main._conscomp_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{j_32782})});
            if(true)
              break Success479;
          }
          term = term585;
        }
        Success482:
        { 
          if(cons37 == Main._consdiff_2)
          { 
            Fail1140:
            { 
              IStrategoTerm g_32782 = null;
              IStrategoTerm h_32782 = null;
              h_32782 = term.getSubterm(0);
              g_32782 = term.getSubterm(1);
              term = h_32782;
              IStrategoTerm term589 = term;
              IStrategoConstructor cons39 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
              Success483:
              { 
                if(cons39 == Main._consunion_2)
                { 
                  Fail1141:
                  { 
                    if(true)
                      break Success483;
                  }
                  term = term589;
                }
                if(cons39 == Main._consisect_2)
                { }
                else
                { 
                  break Fail1140;
                }
              }
              term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{h_32782}), g_32782});
              if(true)
                break Success482;
            }
            term = term585;
          }
          Success484:
          { 
            if(cons37 == Main._consdiff_2)
            { 
              Fail1142:
              { 
                IStrategoTerm d_32782 = null;
                IStrategoTerm e_32782 = null;
                d_32782 = term.getSubterm(0);
                e_32782 = term.getSubterm(1);
                term = e_32782;
                IStrategoTerm term591 = term;
                IStrategoConstructor cons40 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                Success485:
                { 
                  if(cons40 == Main._consunion_2)
                  { 
                    Fail1143:
                    { 
                      if(true)
                        break Success485;
                    }
                    term = term591;
                  }
                  Success486:
                  { 
                    if(cons40 == Main._consisect_2)
                    { 
                      Fail1144:
                      { 
                        if(true)
                          break Success486;
                      }
                      term = term591;
                    }
                    if(cons40 == Main._consdiff_2)
                    { }
                    else
                    { 
                      break Fail1142;
                    }
                  }
                }
                term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{d_32782, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{e_32782})});
                if(true)
                  break Success484;
              }
              term = term585;
            }
            Success487:
            { 
              if(cons37 == Main._consiter_1)
              { 
                Fail1145:
                { 
                  IStrategoTerm b_32782 = null;
                  b_32782 = term.getSubterm(0);
                  term = b_32782;
                  IStrategoTerm term594 = term;
                  IStrategoConstructor cons41 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                  Success488:
                  { 
                    if(cons41 == Main._conslabel_2)
                    { 
                      Fail1146:
                      { 
                        if(true)
                          break Success488;
                      }
                      term = term594;
                    }
                    if(cons41 == Main._consalt_2)
                    { }
                    else
                    { 
                      break Fail1145;
                    }
                  }
                  term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{b_32782})});
                  if(true)
                    break Success487;
                }
                term = term585;
              }
              Success489:
              { 
                if(cons37 == Main._consiter_star_1)
                { 
                  Fail1147:
                  { 
                    IStrategoTerm z_32781 = null;
                    z_32781 = term.getSubterm(0);
                    term = z_32781;
                    IStrategoTerm term596 = term;
                    IStrategoConstructor cons42 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                    Success490:
                    { 
                      if(cons42 == Main._conslabel_2)
                      { 
                        Fail1148:
                        { 
                          if(true)
                            break Success490;
                        }
                        term = term596;
                      }
                      if(cons42 == Main._consalt_2)
                      { }
                      else
                      { 
                        break Fail1147;
                      }
                    }
                    term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{z_32781})});
                    if(true)
                      break Success489;
                  }
                  term = term585;
                }
                Success491:
                { 
                  if(cons37 == Main._consopt_1)
                  { 
                    Fail1149:
                    { 
                      IStrategoTerm x_32781 = null;
                      x_32781 = term.getSubterm(0);
                      term = x_32781;
                      IStrategoTerm term598 = term;
                      IStrategoConstructor cons43 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                      Success492:
                      { 
                        if(cons43 == Main._conslabel_2)
                        { 
                          Fail1150:
                          { 
                            if(true)
                              break Success492;
                          }
                          term = term598;
                        }
                        if(cons43 == Main._consalt_2)
                        { }
                        else
                        { 
                          break Fail1149;
                        }
                      }
                      term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{x_32781})});
                      if(true)
                        break Success491;
                    }
                    term = term585;
                  }
                  Success493:
                  { 
                    if(cons37 == Main._consalt_2)
                    { 
                      Fail1151:
                      { 
                        IStrategoTerm u_32781 = null;
                        IStrategoTerm v_32781 = null;
                        v_32781 = term.getSubterm(0);
                        u_32781 = term.getSubterm(1);
                        term = v_32781;
                        IStrategoTerm term600 = term;
                        IStrategoConstructor cons44 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                        Success494:
                        { 
                          if(cons44 == Main._conslabel_2)
                          { 
                            Fail1152:
                            { 
                              if(true)
                                break Success494;
                            }
                            term = term600;
                          }
                          if(cons44 == Main._consalt_2)
                          { }
                          else
                          { 
                            break Fail1151;
                          }
                        }
                        term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{v_32781}), u_32781});
                        if(true)
                          break Success493;
                      }
                      term = term585;
                    }
                    Success495:
                    { 
                      if(cons37 == Main._consalt_2)
                      { 
                        Fail1153:
                        { 
                          IStrategoTerm r_32781 = null;
                          IStrategoTerm s_32781 = null;
                          r_32781 = term.getSubterm(0);
                          s_32781 = term.getSubterm(1);
                          term = s_32781;
                          if(term.getTermType() != IStrategoTerm.APPL || Main._conslabel_2 != ((IStrategoAppl)term).getConstructor())
                            break Fail1153;
                          term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{r_32781, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{s_32781})});
                          if(true)
                            break Success495;
                        }
                        term = term585;
                      }
                      Success496:
                      { 
                        if(cons37 == Main._consseq_2)
                        { 
                          Fail1154:
                          { 
                            IStrategoTerm o_32781 = null;
                            IStrategoTerm p_32781 = null;
                            p_32781 = term.getSubterm(0);
                            o_32781 = term.getSubterm(1);
                            term = p_32781;
                            if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                              break Fail1154;
                            term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{p_32781}), o_32781});
                            if(true)
                              break Success496;
                          }
                          term = term585;
                        }
                        Success497:
                        { 
                          if(cons37 == Main._consseq_2)
                          { 
                            Fail1155:
                            { 
                              IStrategoTerm l_32781 = null;
                              IStrategoTerm m_32781 = null;
                              l_32781 = term.getSubterm(0);
                              m_32781 = term.getSubterm(1);
                              term = m_32781;
                              if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                                break Fail1155;
                              term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{l_32781, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{m_32781})});
                              if(true)
                                break Success497;
                            }
                            term = term585;
                          }
                          Success498:
                          { 
                            if(cons37 == Main._consisect_2)
                            { 
                              Fail1156:
                              { 
                                IStrategoTerm i_32781 = null;
                                IStrategoTerm j_32781 = null;
                                j_32781 = term.getSubterm(0);
                                i_32781 = term.getSubterm(1);
                                term = j_32781;
                                if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                  break Fail1156;
                                term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{j_32781}), i_32781});
                                if(true)
                                  break Success498;
                              }
                              term = term585;
                            }
                            Success499:
                            { 
                              if(cons37 == Main._consisect_2)
                              { 
                                Fail1157:
                                { 
                                  IStrategoTerm f_32781 = null;
                                  IStrategoTerm g_32781 = null;
                                  f_32781 = term.getSubterm(0);
                                  g_32781 = term.getSubterm(1);
                                  term = g_32781;
                                  IStrategoTerm term606 = term;
                                  IStrategoConstructor cons45 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                                  Success500:
                                  { 
                                    if(cons45 == Main._consunion_2)
                                    { 
                                      Fail1158:
                                      { 
                                        if(true)
                                          break Success500;
                                      }
                                      term = term606;
                                    }
                                    if(cons45 == Main._consisect_2)
                                    { }
                                    else
                                    { 
                                      break Fail1157;
                                    }
                                  }
                                  term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{f_32781, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{g_32781})});
                                  if(true)
                                    break Success499;
                                }
                                term = term585;
                              }
                              Success501:
                              { 
                                if(cons37 == Main._consnon_transitive_1)
                                { 
                                  Fail1159:
                                  { 
                                    IStrategoTerm d_32781 = null;
                                    d_32781 = term.getSubterm(0);
                                    term = d_32781;
                                    if(term.getTermType() != IStrategoTerm.APPL || Main._consnon_transitive_1 != ((IStrategoAppl)term).getConstructor())
                                      break Fail1159;
                                    term = termFactory.makeAppl(Main._consnon_transitive_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{d_32781})});
                                    if(true)
                                      break Success501;
                                  }
                                  term = term585;
                                }
                                Success502:
                                { 
                                  if(cons37 == Main._consunion_2)
                                  { 
                                    Fail1160:
                                    { 
                                      IStrategoTerm a_32781 = null;
                                      IStrategoTerm b_32781 = null;
                                      a_32781 = term.getSubterm(0);
                                      b_32781 = term.getSubterm(1);
                                      term = b_32781;
                                      if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                        break Fail1160;
                                      term = termFactory.makeAppl(Main._consunion_2, new IStrategoTerm[]{a_32781, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{b_32781})});
                                      if(true)
                                        break Success502;
                                    }
                                    term = term585;
                                  }
                                  Success503:
                                  { 
                                    if(cons37 == Main._consconc_2)
                                    { 
                                      Fail1161:
                                      { 
                                        IStrategoTerm x_32780 = null;
                                        IStrategoTerm y_32780 = null;
                                        y_32780 = term.getSubterm(0);
                                        x_32780 = term.getSubterm(1);
                                        term = y_32780;
                                        if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_2 != ((IStrategoAppl)term).getConstructor())
                                          break Fail1161;
                                        term = termFactory.makeAppl(Main._consconc_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{y_32780}), x_32780});
                                        if(true)
                                          break Success503;
                                      }
                                      term = term585;
                                    }
                                    Success504:
                                    { 
                                      if(cons37 == Main._conswith_arguments_2)
                                      { 
                                        Fail1162:
                                        { 
                                          IStrategoTerm u_32780 = null;
                                          IStrategoTerm v_32780 = null;
                                          v_32780 = term.getSubterm(0);
                                          u_32780 = term.getSubterm(1);
                                          term = v_32780;
                                          if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                            break Fail1162;
                                          term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{v_32780}), u_32780});
                                          if(true)
                                            break Success504;
                                        }
                                        term = term585;
                                      }
                                      Success505:
                                      { 
                                        if(cons37 == Main._conswith_arguments_2)
                                        { 
                                          Fail1163:
                                          { 
                                            IStrategoTerm r_32780 = null;
                                            IStrategoTerm s_32780 = null;
                                            r_32780 = term.getSubterm(0);
                                            s_32780 = term.getSubterm(1);
                                            term = s_32780;
                                            if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                              break Fail1163;
                                            term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{r_32780, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{s_32780})});
                                            if(true)
                                              break Success505;
                                          }
                                          term = term585;
                                        }
                                        if(cons37 == Main._consconc_grammars_2)
                                        { 
                                          IStrategoTerm o_32780 = null;
                                          IStrategoTerm p_32780 = null;
                                          o_32780 = term.getSubterm(0);
                                          p_32780 = term.getSubterm(1);
                                          term = p_32780;
                                          if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_grammars_2 != ((IStrategoAppl)term).getConstructor())
                                            break Fail1136;
                                          term = termFactory.makeAppl(Main._consconc_grammars_2, new IStrategoTerm[]{o_32780, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{p_32780})});
                                        }
                                        else
                                        { 
                                          break Fail1136;
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