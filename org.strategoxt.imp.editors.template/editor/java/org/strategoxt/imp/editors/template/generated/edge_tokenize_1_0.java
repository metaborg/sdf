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

@SuppressWarnings("all") public class edge_tokenize_1_0 extends Strategy 
{ 
  public static edge_tokenize_1_0 instance = new edge_tokenize_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_32780)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("edge_tokenize_1_0");
    Fail1121:
    { 
      IStrategoTerm z_32779 = null;
      IStrategoTerm a_32780 = null;
      IStrategoTerm b_32780 = null;
      IStrategoTerm c_32780 = null;
      IStrategoTerm d_32780 = null;
      IStrategoTerm e_32780 = null;
      IStrategoTerm term550 = term;
      Success472:
      { 
        Fail1122:
        { 
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1122;
          e_32780 = ((IStrategoList)term).head();
          z_32779 = ((IStrategoList)term).tail();
          Success473:
          { 
            Fail1123:
            { 
              IStrategoTerm f_32780 = null;
              f_32780 = term;
              term = $Hd_0_0.instance.invoke(context, z_32779);
              if(term == null)
                break Fail1123;
              a_32780 = term;
              term = f_32780;
              { 
                term = this.invoke(context, z_32779, h_32780);
                if(term == null)
                  break Fail1122;
                b_32780 = term;
                Success474:
                { 
                  Fail1124:
                  { 
                    IStrategoTerm g_32780 = null;
                    g_32780 = term;
                    Success475:
                    { 
                      Fail1125:
                      { 
                        term = h_32780.invoke(context, e_32780);
                        if(term == null)
                          break Fail1125;
                        { 
                          term = a_32780;
                          IStrategoTerm term554 = term;
                          Success476:
                          { 
                            Fail1126:
                            { 
                              term = h_32780.invoke(context, term);
                              if(term == null)
                                break Fail1126;
                              { 
                                if(true)
                                  break Fail1124;
                                if(true)
                                  break Success476;
                              }
                            }
                            term = term554;
                          }
                          if(true)
                            break Success475;
                        }
                      }
                      term = h_32780.invoke(context, a_32780);
                      if(term == null)
                        break Fail1124;
                    }
                    term = g_32780;
                    { 
                      IStrategoList list42;
                      list42 = checkListTail(b_32780);
                      if(list42 == null)
                        break Fail1122;
                      term = (IStrategoTerm)termFactory.makeListCons((IStrategoTerm)termFactory.makeListCons(e_32780, (IStrategoList)generated.constNil3), list42);
                      if(true)
                        break Success474;
                    }
                  }
                  term = b_32780;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail1122;
                  c_32780 = ((IStrategoList)term).head();
                  d_32780 = ((IStrategoList)term).tail();
                  IStrategoList list44;
                  IStrategoList list43;
                  list43 = checkListTail(d_32780);
                  if(list43 == null)
                    break Fail1122;
                  list44 = checkListTail(c_32780);
                  if(list44 == null)
                    break Fail1122;
                  term = (IStrategoTerm)termFactory.makeListCons((IStrategoTerm)termFactory.makeListCons(e_32780, list44), list43);
                }
                if(true)
                  break Success473;
              }
            }
            term = (IStrategoTerm)termFactory.makeListCons((IStrategoTerm)termFactory.makeListCons(e_32780, (IStrategoList)generated.constNil3), (IStrategoList)generated.constNil3);
          }
          if(true)
            break Success472;
        }
        term = term550;
        if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
          break Fail1121;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}