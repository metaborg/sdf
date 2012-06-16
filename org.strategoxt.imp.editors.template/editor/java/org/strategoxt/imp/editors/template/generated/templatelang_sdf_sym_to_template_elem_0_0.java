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
    Fail183:
    { 
      IStrategoTerm term184 = term;
      IStrategoConstructor cons14 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success132:
      { 
        if(cons14 == Main._conslit_1)
        { 
          Fail184:
          { 
            IStrategoTerm b_9728 = null;
            b_9728 = term.getSubterm(0);
            term = un_double_quote_0_0.instance.invoke(context, b_9728);
            if(term == null)
              break Fail184;
            term = unescape_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail184;
            term = termFactory.makeAppl(Main._consString_1, new IStrategoTerm[]{term});
            if(true)
              break Success132;
          }
          term = term184;
        }
        Success133:
        { 
          if(cons14 == Main._conssort_1)
          { 
            Fail185:
            { 
              term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, term, generated.constNone0, generated.constNil0});
              if(true)
                break Success133;
            }
            term = term184;
          }
          Success134:
          { 
            if(cons14 == Main._consopt_1)
            { 
              Fail186:
              { 
                IStrategoTerm z_9727 = null;
                IStrategoTerm arg236 = term.getSubterm(0);
                z_9727 = arg236;
                if(arg236.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg236).getConstructor())
                  break Fail186;
                term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, z_9727, generated.constOption0, generated.constNil0});
                if(true)
                  break Success134;
              }
              term = term184;
            }
            Success135:
            { 
              if(cons14 == Main._consiter_star_1)
              { 
                Fail187:
                { 
                  IStrategoTerm y_9727 = null;
                  IStrategoTerm arg238 = term.getSubterm(0);
                  y_9727 = arg238;
                  if(arg238.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg238).getConstructor())
                    break Fail187;
                  term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, y_9727, generated.constStar0, generated.constNil0});
                  if(true)
                    break Success135;
                }
                term = term184;
              }
              Success136:
              { 
                if(cons14 == Main._consiter_1)
                { 
                  Fail188:
                  { 
                    IStrategoTerm x_9727 = null;
                    IStrategoTerm arg240 = term.getSubterm(0);
                    x_9727 = arg240;
                    if(arg240.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg240).getConstructor())
                      break Fail188;
                    term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, x_9727, generated.constPlus0, generated.constNil0});
                    if(true)
                      break Success136;
                  }
                  term = term184;
                }
                Success137:
                { 
                  if(cons14 == Main._consiter_star_sep_2)
                  { 
                    Fail189:
                    { 
                      IStrategoTerm t_9727 = null;
                      IStrategoTerm u_9727 = null;
                      IStrategoTerm arg242 = term.getSubterm(0);
                      t_9727 = arg242;
                      if(arg242.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg242).getConstructor())
                        break Fail189;
                      IStrategoTerm arg244 = term.getSubterm(1);
                      if(arg244.getTermType() != IStrategoTerm.APPL || Main._conslit_1 != ((IStrategoAppl)arg244).getConstructor())
                        break Fail189;
                      u_9727 = arg244.getSubterm(0);
                      term = un_double_quote_0_0.instance.invoke(context, u_9727);
                      if(term == null)
                        break Fail189;
                      term = unescape_0_0.instance.invoke(context, term);
                      if(term == null)
                        break Fail189;
                      term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, t_9727, generated.constStar0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term}), (IStrategoList)generated.constNil0)});
                      if(true)
                        break Success137;
                    }
                    term = term184;
                  }
                  Success138:
                  { 
                    if(cons14 == Main._consiter_sep_2)
                    { 
                      Fail190:
                      { 
                        IStrategoTerm p_9727 = null;
                        IStrategoTerm q_9727 = null;
                        IStrategoTerm arg245 = term.getSubterm(0);
                        p_9727 = arg245;
                        if(arg245.getTermType() != IStrategoTerm.APPL || Main._conssort_1 != ((IStrategoAppl)arg245).getConstructor())
                          break Fail190;
                        IStrategoTerm arg247 = term.getSubterm(1);
                        if(arg247.getTermType() != IStrategoTerm.APPL || Main._conslit_1 != ((IStrategoAppl)arg247).getConstructor())
                          break Fail190;
                        q_9727 = arg247.getSubterm(0);
                        term = un_double_quote_0_0.instance.invoke(context, q_9727);
                        if(term == null)
                          break Fail190;
                        term = unescape_0_0.instance.invoke(context, term);
                        if(term == null)
                          break Fail190;
                        term = termFactory.makeAppl(Main._consPlaceholder_4, new IStrategoTerm[]{generated.constNone0, p_9727, generated.constPlus0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term}), (IStrategoList)generated.constNil0)});
                        if(true)
                          break Success138;
                      }
                      term = term184;
                    }
                    term = debug_1_0.instance.invoke(context, term, lifted145.instance);
                    if(term == null)
                      break Fail183;
                    if(true)
                      break Fail183;
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