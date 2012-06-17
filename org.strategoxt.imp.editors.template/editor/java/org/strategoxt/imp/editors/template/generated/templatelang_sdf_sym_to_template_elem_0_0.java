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

@SuppressWarnings("all") public class templatelang_sdf_sym_to_template_elem_0_0 extends Strategy 
{ 
  public static templatelang_sdf_sym_to_template_elem_0_0 instance = new templatelang_sdf_sym_to_template_elem_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_sdf_sym_to_template_elem_0_0");
    Fail1003:
    { 
      IStrategoTerm term440 = term;
      IStrategoConstructor cons26 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success388:
      { 
        if(cons26 == Main._conslit_1)
        { 
          Fail1004:
          { 
            IStrategoTerm k_32766 = null;
            k_32766 = term.getSubterm(0);
            term = un_double_quote_0_0.instance.invoke(context, k_32766);
            if(term == null)
              break Fail1004;
            term = unescape_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1004;
            term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{term});
            if(true)
              break Success388;
          }
          term = term440;
        }
        Success389:
        { 
          if(cons26 == Main._conssort_1)
          { 
            Fail1005:
            { 
              term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, term, generated.constNone0, generated.constNil3});
              if(true)
                break Success389;
            }
            term = term440;
          }
          Success390:
          { 
            if(cons26 == Main._consopt_1)
            { 
              Fail1006:
              { 
                IStrategoTerm i_32766 = null;
                IStrategoTerm arg389 = term.getSubterm(0);
                i_32766 = arg389;
                if(arg389.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg389).getConstructor())
                  break Fail1006;
                term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, i_32766, generated.constOption0, generated.constNil3});
                if(true)
                  break Success390;
              }
              term = term440;
            }
            Success391:
            { 
              if(cons26 == Main._consiter_star_1)
              { 
                Fail1007:
                { 
                  IStrategoTerm h_32766 = null;
                  IStrategoTerm arg391 = term.getSubterm(0);
                  h_32766 = arg391;
                  if(arg391.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg391).getConstructor())
                    break Fail1007;
                  term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, h_32766, generated.constStar0, generated.constNil3});
                  if(true)
                    break Success391;
                }
                term = term440;
              }
              Success392:
              { 
                if(cons26 == Main._consiter_1)
                { 
                  Fail1008:
                  { 
                    IStrategoTerm g_32766 = null;
                    IStrategoTerm arg393 = term.getSubterm(0);
                    g_32766 = arg393;
                    if(arg393.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg393).getConstructor())
                      break Fail1008;
                    term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, g_32766, generated.constPlus0, generated.constNil3});
                    if(true)
                      break Success392;
                  }
                  term = term440;
                }
                Success393:
                { 
                  if(cons26 == Main._consiter_star_sep_2)
                  { 
                    Fail1009:
                    { 
                      IStrategoTerm c_32766 = null;
                      IStrategoTerm d_32766 = null;
                      IStrategoTerm arg395 = term.getSubterm(0);
                      c_32766 = arg395;
                      if(arg395.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg395).getConstructor())
                        break Fail1009;
                      IStrategoTerm arg397 = term.getSubterm(1);
                      if(arg397.getTermType() != IStrategoTerm.APPL || Main._conslit_1 != ((IStrategoAppl)arg397).getConstructor())
                        break Fail1009;
                      d_32766 = arg397.getSubterm(0);
                      term = un_double_quote_0_0.instance.invoke(context, d_32766);
                      if(term == null)
                        break Fail1009;
                      term = unescape_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail1009;
                      term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, c_32766, generated.constStar0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term}), (IStrategoList)generated.constNil3)});
                      if(true)
                        break Success393;
                    }
                    term = term440;
                  }
                  Success394:
                  { 
                    if(cons26 == Main._consiter_sep_2)
                    { 
                      Fail1010:
                      { 
                        IStrategoTerm y_32765 = null;
                        IStrategoTerm z_32765 = null;
                        IStrategoTerm arg398 = term.getSubterm(0);
                        y_32765 = arg398;
                        if(arg398.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg398).getConstructor())
                          break Fail1010;
                        IStrategoTerm arg400 = term.getSubterm(1);
                        if(arg400.getTermType() != IStrategoTerm.APPL || Main._conslit_1 != ((IStrategoAppl)arg400).getConstructor())
                          break Fail1010;
                        z_32765 = arg400.getSubterm(0);
                        term = un_double_quote_0_0.instance.invoke(context, z_32765);
                        if(term == null)
                          break Fail1010;
                        term = unescape_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail1010;
                        term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, y_32765, generated.constPlus0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term}), (IStrategoList)generated.constNil3)});
                        if(true)
                          break Success394;
                      }
                      term = term440;
                    }
                    term = debug_1_0.instance.invoke(context, term, lifted344.instance);
                    if(term == null)
                      break Fail1003;
                    if(true)
                      break Fail1003;
                  }
                }
              }
            }
          }
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