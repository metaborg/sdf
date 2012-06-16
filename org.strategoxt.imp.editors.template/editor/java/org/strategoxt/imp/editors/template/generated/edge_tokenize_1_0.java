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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy y_9741)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("edge_tokenize_1_0");
    Fail301:
    { 
      IStrategoTerm q_9741 = null;
      IStrategoTerm r_9741 = null;
      IStrategoTerm s_9741 = null;
      IStrategoTerm t_9741 = null;
      IStrategoTerm u_9741 = null;
      IStrategoTerm v_9741 = null;
      IStrategoTerm term294 = term;
      Success216:
      { 
        Fail302:
        { 
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail302;
          v_9741 = ((IStrategoList)term).head();
          q_9741 = ((IStrategoList)term).tail();
          Success217:
          { 
            Fail303:
            { 
              IStrategoTerm w_9741 = null;
              w_9741 = term;
              term = $Hd_0_0.instance.invoke(context, q_9741);
              if(term == null)
                break Fail303;
              r_9741 = term;
              term = w_9741;
              { 
                term = this.invoke(context, q_9741, y_9741);
                if(term == null)
                  break Fail302;
                s_9741 = term;
                Success218:
                { 
                  Fail304:
                  { 
                    IStrategoTerm x_9741 = null;
                    x_9741 = term;
                    Success219:
                    { 
                      Fail305:
                      { 
                        term = y_9741.invoke(context, v_9741);
                        if(term == null)
                          break Fail305;
                        { 
                          term = r_9741;
                          IStrategoTerm term298 = term;
                          Success220:
                          { 
                            Fail306:
                            { 
                              term = y_9741.invoke(context, term);
                              if(term == null)
                                break Fail306;
                              { 
                                if(true)
                                  break Fail304;
                                if(true)
                                  break Success220;
                              }
                            }
                            term = term298;
                          }
                          if(true)
                            break Success219;
                        }
                      }
                      term = y_9741.invoke(context, r_9741);
                      if(term == null)
                        break Fail304;
                    }
                    term = x_9741;
                    { 
                      IStrategoList list39;
                      list39 = checkListTail(s_9741);
                      if(list39 == null)
                        break Fail302;
                      term = (IStrategoTerm)termFactory.makeListCons((IStrategoTerm)termFactory.makeListCons(v_9741, (IStrategoList)generated.constNil0), list39);
                      if(true)
                        break Success218;
                    }
                  }
                  term = s_9741;
                  if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
                    break Fail302;
                  t_9741 = ((IStrategoList)term).head();
                  u_9741 = ((IStrategoList)term).tail();
                  IStrategoList list41;
                  IStrategoList list40;
                  list40 = checkListTail(u_9741);
                  if(list40 == null)
                    break Fail302;
                  list41 = checkListTail(t_9741);
                  if(list41 == null)
                    break Fail302;
                  term = (IStrategoTerm)termFactory.makeListCons((IStrategoTerm)termFactory.makeListCons(v_9741, list41), list40);
                }
                if(true)
                  break Success217;
              }
            }
            term = (IStrategoTerm)termFactory.makeListCons((IStrategoTerm)termFactory.makeListCons(v_9741, (IStrategoList)generated.constNil0), (IStrategoList)generated.constNil0);
          }
          if(true)
            break Success216;
        }
        term = term294;
        if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
          break Fail301;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}