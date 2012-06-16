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

@SuppressWarnings("all") final class l_9945 extends Strategy 
{ 
  public static final l_9945 instance = new l_9945();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail733:
    { 
      IStrategoTerm term301 = term;
      Success304:
      { 
        Fail734:
        { 
          IStrategoTerm term302 = term;
          IStrategoConstructor cons40 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
          Success305:
          { 
            if(cons40 == Main._conscomp_1)
            { 
              Fail735:
              { 
                IStrategoTerm n_9943 = null;
                n_9943 = term.getSubterm(0);
                term = n_9943;
                IStrategoTerm term303 = term;
                IStrategoConstructor cons41 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                Success306:
                { 
                  if(cons41 == Main._consunion_2)
                  { 
                    Fail736:
                    { 
                      if(true)
                        break Success306;
                    }
                    term = term303;
                  }
                  Success307:
                  { 
                    if(cons41 == Main._consisect_2)
                    { 
                      Fail737:
                      { 
                        if(true)
                          break Success307;
                      }
                      term = term303;
                    }
                    if(cons41 == Main._consdiff_2)
                    { }
                    else
                    { 
                      break Fail735;
                    }
                  }
                }
                term = termFactory.makeAppl(Main._conscomp_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{n_9943})});
                term = this.invoke(context, term);
                if(term == null)
                  break Fail735;
                if(true)
                  break Success305;
              }
              term = term302;
            }
            Success308:
            { 
              if(cons40 == Main._consdiff_2)
              { 
                Fail738:
                { 
                  IStrategoTerm p_9943 = null;
                  IStrategoTerm q_9943 = null;
                  q_9943 = term.getSubterm(0);
                  p_9943 = term.getSubterm(1);
                  term = q_9943;
                  IStrategoTerm term306 = term;
                  IStrategoConstructor cons42 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                  Success309:
                  { 
                    if(cons42 == Main._consunion_2)
                    { 
                      Fail739:
                      { 
                        if(true)
                          break Success309;
                      }
                      term = term306;
                    }
                    if(cons42 == Main._consisect_2)
                    { }
                    else
                    { 
                      break Fail738;
                    }
                  }
                  term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{q_9943}), p_9943});
                  term = this.invoke(context, term);
                  if(term == null)
                    break Fail738;
                  if(true)
                    break Success308;
                }
                term = term302;
              }
              Success310:
              { 
                if(cons40 == Main._consdiff_2)
                { 
                  Fail740:
                  { 
                    IStrategoTerm s_9943 = null;
                    IStrategoTerm t_9943 = null;
                    s_9943 = term.getSubterm(0);
                    t_9943 = term.getSubterm(1);
                    term = t_9943;
                    IStrategoTerm term308 = term;
                    IStrategoConstructor cons43 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                    Success311:
                    { 
                      if(cons43 == Main._consunion_2)
                      { 
                        Fail741:
                        { 
                          if(true)
                            break Success311;
                        }
                        term = term308;
                      }
                      Success312:
                      { 
                        if(cons43 == Main._consisect_2)
                        { 
                          Fail742:
                          { 
                            if(true)
                              break Success312;
                          }
                          term = term308;
                        }
                        if(cons43 == Main._consdiff_2)
                        { }
                        else
                        { 
                          break Fail740;
                        }
                      }
                    }
                    term = termFactory.makeAppl(Main._consdiff_2, new IStrategoTerm[]{s_9943, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{t_9943})});
                    term = this.invoke(context, term);
                    if(term == null)
                      break Fail740;
                    if(true)
                      break Success310;
                  }
                  term = term302;
                }
                Success313:
                { 
                  if(cons40 == Main._consiter_1)
                  { 
                    Fail743:
                    { 
                      IStrategoTerm v_9943 = null;
                      v_9943 = term.getSubterm(0);
                      term = v_9943;
                      IStrategoTerm term311 = term;
                      IStrategoConstructor cons44 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                      Success314:
                      { 
                        if(cons44 == Main._conslabel_2)
                        { 
                          Fail744:
                          { 
                            if(true)
                              break Success314;
                          }
                          term = term311;
                        }
                        if(cons44 == Main._consalt_2)
                        { }
                        else
                        { 
                          break Fail743;
                        }
                      }
                      term = termFactory.makeAppl(Main._consiter_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{v_9943})});
                      term = this.invoke(context, term);
                      if(term == null)
                        break Fail743;
                      if(true)
                        break Success313;
                    }
                    term = term302;
                  }
                  Success315:
                  { 
                    if(cons40 == Main._consiter_star_1)
                    { 
                      Fail745:
                      { 
                        IStrategoTerm x_9943 = null;
                        x_9943 = term.getSubterm(0);
                        term = x_9943;
                        IStrategoTerm term313 = term;
                        IStrategoConstructor cons45 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                        Success316:
                        { 
                          if(cons45 == Main._conslabel_2)
                          { 
                            Fail746:
                            { 
                              if(true)
                                break Success316;
                            }
                            term = term313;
                          }
                          if(cons45 == Main._consalt_2)
                          { }
                          else
                          { 
                            break Fail745;
                          }
                        }
                        term = termFactory.makeAppl(Main._consiter_star_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{x_9943})});
                        term = this.invoke(context, term);
                        if(term == null)
                          break Fail745;
                        if(true)
                          break Success315;
                      }
                      term = term302;
                    }
                    Success317:
                    { 
                      if(cons40 == Main._consopt_1)
                      { 
                        Fail747:
                        { 
                          IStrategoTerm z_9943 = null;
                          z_9943 = term.getSubterm(0);
                          term = z_9943;
                          IStrategoTerm term315 = term;
                          IStrategoConstructor cons46 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                          Success318:
                          { 
                            if(cons46 == Main._conslabel_2)
                            { 
                              Fail748:
                              { 
                                if(true)
                                  break Success318;
                              }
                              term = term315;
                            }
                            if(cons46 == Main._consalt_2)
                            { }
                            else
                            { 
                              break Fail747;
                            }
                          }
                          term = termFactory.makeAppl(Main._consopt_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{z_9943})});
                          term = this.invoke(context, term);
                          if(term == null)
                            break Fail747;
                          if(true)
                            break Success317;
                        }
                        term = term302;
                      }
                      Success319:
                      { 
                        if(cons40 == Main._consalt_2)
                        { 
                          Fail749:
                          { 
                            IStrategoTerm b_9944 = null;
                            IStrategoTerm c_9944 = null;
                            c_9944 = term.getSubterm(0);
                            b_9944 = term.getSubterm(1);
                            term = c_9944;
                            IStrategoTerm term317 = term;
                            IStrategoConstructor cons47 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                            Success320:
                            { 
                              if(cons47 == Main._conslabel_2)
                              { 
                                Fail750:
                                { 
                                  if(true)
                                    break Success320;
                                }
                                term = term317;
                              }
                              if(cons47 == Main._consalt_2)
                              { }
                              else
                              { 
                                break Fail749;
                              }
                            }
                            term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{c_9944}), b_9944});
                            term = this.invoke(context, term);
                            if(term == null)
                              break Fail749;
                            if(true)
                              break Success319;
                          }
                          term = term302;
                        }
                        Success321:
                        { 
                          if(cons40 == Main._consalt_2)
                          { 
                            Fail751:
                            { 
                              IStrategoTerm e_9944 = null;
                              IStrategoTerm f_9944 = null;
                              e_9944 = term.getSubterm(0);
                              f_9944 = term.getSubterm(1);
                              term = f_9944;
                              if(term.getTermType() != IStrategoTerm.APPL || Main._conslabel_2 != ((IStrategoAppl)term).getConstructor())
                                break Fail751;
                              term = termFactory.makeAppl(Main._consalt_2, new IStrategoTerm[]{e_9944, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{f_9944})});
                              term = this.invoke(context, term);
                              if(term == null)
                                break Fail751;
                              if(true)
                                break Success321;
                            }
                            term = term302;
                          }
                          Success322:
                          { 
                            if(cons40 == Main._consseq_2)
                            { 
                              Fail752:
                              { 
                                IStrategoTerm h_9944 = null;
                                IStrategoTerm i_9944 = null;
                                i_9944 = term.getSubterm(0);
                                h_9944 = term.getSubterm(1);
                                term = i_9944;
                                if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                                  break Fail752;
                                term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{i_9944}), h_9944});
                                term = this.invoke(context, term);
                                if(term == null)
                                  break Fail752;
                                if(true)
                                  break Success322;
                              }
                              term = term302;
                            }
                            Success323:
                            { 
                              if(cons40 == Main._consseq_2)
                              { 
                                Fail753:
                                { 
                                  IStrategoTerm k_9944 = null;
                                  IStrategoTerm l_9944 = null;
                                  k_9944 = term.getSubterm(0);
                                  l_9944 = term.getSubterm(1);
                                  term = l_9944;
                                  if(term.getTermType() != IStrategoTerm.APPL || Main._consalt_2 != ((IStrategoAppl)term).getConstructor())
                                    break Fail753;
                                  term = termFactory.makeAppl(Main._consseq_2, new IStrategoTerm[]{k_9944, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{l_9944})});
                                  term = this.invoke(context, term);
                                  if(term == null)
                                    break Fail753;
                                  if(true)
                                    break Success323;
                                }
                                term = term302;
                              }
                              Success324:
                              { 
                                if(cons40 == Main._consisect_2)
                                { 
                                  Fail754:
                                  { 
                                    IStrategoTerm n_9944 = null;
                                    IStrategoTerm o_9944 = null;
                                    o_9944 = term.getSubterm(0);
                                    n_9944 = term.getSubterm(1);
                                    term = o_9944;
                                    if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                      break Fail754;
                                    term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{o_9944}), n_9944});
                                    term = this.invoke(context, term);
                                    if(term == null)
                                      break Fail754;
                                    if(true)
                                      break Success324;
                                  }
                                  term = term302;
                                }
                                Success325:
                                { 
                                  if(cons40 == Main._consisect_2)
                                  { 
                                    Fail755:
                                    { 
                                      IStrategoTerm q_9944 = null;
                                      IStrategoTerm r_9944 = null;
                                      q_9944 = term.getSubterm(0);
                                      r_9944 = term.getSubterm(1);
                                      term = r_9944;
                                      IStrategoTerm term323 = term;
                                      IStrategoConstructor cons48 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
                                      Success326:
                                      { 
                                        if(cons48 == Main._consunion_2)
                                        { 
                                          Fail756:
                                          { 
                                            if(true)
                                              break Success326;
                                          }
                                          term = term323;
                                        }
                                        if(cons48 == Main._consisect_2)
                                        { }
                                        else
                                        { 
                                          break Fail755;
                                        }
                                      }
                                      term = termFactory.makeAppl(Main._consisect_2, new IStrategoTerm[]{q_9944, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{r_9944})});
                                      term = this.invoke(context, term);
                                      if(term == null)
                                        break Fail755;
                                      if(true)
                                        break Success325;
                                    }
                                    term = term302;
                                  }
                                  Success327:
                                  { 
                                    if(cons40 == Main._consnon_transitive_1)
                                    { 
                                      Fail757:
                                      { 
                                        IStrategoTerm t_9944 = null;
                                        t_9944 = term.getSubterm(0);
                                        term = t_9944;
                                        if(term.getTermType() != IStrategoTerm.APPL || Main._consnon_transitive_1 != ((IStrategoAppl)term).getConstructor())
                                          break Fail757;
                                        term = termFactory.makeAppl(Main._consnon_transitive_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{t_9944})});
                                        term = this.invoke(context, term);
                                        if(term == null)
                                          break Fail757;
                                        if(true)
                                          break Success327;
                                      }
                                      term = term302;
                                    }
                                    Success328:
                                    { 
                                      if(cons40 == Main._consunion_2)
                                      { 
                                        Fail758:
                                        { 
                                          IStrategoTerm v_9944 = null;
                                          IStrategoTerm w_9944 = null;
                                          v_9944 = term.getSubterm(0);
                                          w_9944 = term.getSubterm(1);
                                          term = w_9944;
                                          if(term.getTermType() != IStrategoTerm.APPL || Main._consunion_2 != ((IStrategoAppl)term).getConstructor())
                                            break Fail758;
                                          term = termFactory.makeAppl(Main._consunion_2, new IStrategoTerm[]{v_9944, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{w_9944})});
                                          term = this.invoke(context, term);
                                          if(term == null)
                                            break Fail758;
                                          if(true)
                                            break Success328;
                                        }
                                        term = term302;
                                      }
                                      Success329:
                                      { 
                                        if(cons40 == Main._consconc_2)
                                        { 
                                          Fail759:
                                          { 
                                            IStrategoTerm y_9944 = null;
                                            IStrategoTerm z_9944 = null;
                                            z_9944 = term.getSubterm(0);
                                            y_9944 = term.getSubterm(1);
                                            term = z_9944;
                                            if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_2 != ((IStrategoAppl)term).getConstructor())
                                              break Fail759;
                                            term = termFactory.makeAppl(Main._consconc_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{z_9944}), y_9944});
                                            term = this.invoke(context, term);
                                            if(term == null)
                                              break Fail759;
                                            if(true)
                                              break Success329;
                                          }
                                          term = term302;
                                        }
                                        Success330:
                                        { 
                                          if(cons40 == Main._conswith_arguments_2)
                                          { 
                                            Fail760:
                                            { 
                                              IStrategoTerm b_9945 = null;
                                              IStrategoTerm c_9945 = null;
                                              c_9945 = term.getSubterm(0);
                                              b_9945 = term.getSubterm(1);
                                              term = c_9945;
                                              if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                                break Fail760;
                                              term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{c_9945}), b_9945});
                                              term = this.invoke(context, term);
                                              if(term == null)
                                                break Fail760;
                                              if(true)
                                                break Success330;
                                            }
                                            term = term302;
                                          }
                                          Success331:
                                          { 
                                            if(cons40 == Main._conswith_arguments_2)
                                            { 
                                              Fail761:
                                              { 
                                                IStrategoTerm e_9945 = null;
                                                IStrategoTerm f_9945 = null;
                                                e_9945 = term.getSubterm(0);
                                                f_9945 = term.getSubterm(1);
                                                term = f_9945;
                                                if(term.getTermType() != IStrategoTerm.APPL || Main._conswith_arguments_2 != ((IStrategoAppl)term).getConstructor())
                                                  break Fail761;
                                                term = termFactory.makeAppl(Main._conswith_arguments_2, new IStrategoTerm[]{e_9945, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{f_9945})});
                                                term = this.invoke(context, term);
                                                if(term == null)
                                                  break Fail761;
                                                if(true)
                                                  break Success331;
                                              }
                                              term = term302;
                                            }
                                            if(cons40 == Main._consconc_grammars_2)
                                            { 
                                              IStrategoTerm h_9945 = null;
                                              IStrategoTerm i_9945 = null;
                                              h_9945 = term.getSubterm(0);
                                              i_9945 = term.getSubterm(1);
                                              term = i_9945;
                                              if(term.getTermType() != IStrategoTerm.APPL || Main._consconc_grammars_2 != ((IStrategoAppl)term).getConstructor())
                                                break Fail734;
                                              term = termFactory.makeAppl(Main._consconc_grammars_2, new IStrategoTerm[]{h_9945, termFactory.makeAppl(Main._consParenthetical_1, new IStrategoTerm[]{i_9945})});
                                              term = this.invoke(context, term);
                                              if(term == null)
                                                break Fail734;
                                            }
                                            else
                                            { 
                                              break Fail734;
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
            break Success304;
        }
        term = term301;
      }
      if(true)
        return term;
    }
    return null;
  }
}