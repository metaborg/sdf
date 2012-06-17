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

@SuppressWarnings("all") public class template_line_to_stratego_0_0 extends Strategy 
{ 
  public static template_line_to_stratego_0_0 instance = new template_line_to_stratego_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("template_line_to_stratego_0_0");
    Fail875:
    { 
      IStrategoTerm term302 = term;
      IStrategoConstructor cons15 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success297:
      { 
        if(cons15 == Main._consLine_1)
        { 
          Fail876:
          { 
            IStrategoTerm l_32749 = null;
            IStrategoTerm m_32749 = null;
            IStrategoTerm n_32749 = null;
            IStrategoTerm arg187 = term.getSubterm(0);
            if(arg187.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg187).isEmpty())
              break Fail876;
            IStrategoTerm arg188 = ((IStrategoList)arg187).head();
            if(arg188.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg188).getConstructor())
              break Fail876;
            l_32749 = arg188.getSubterm(0);
            n_32749 = ((IStrategoList)arg187).tail();
            IStrategoTerm term303 = term;
            Success298:
            { 
              Fail877:
              { 
                term = l_32749;
                if(term.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)term).stringValue()))
                  break Fail877;
                { 
                  if(true)
                    break Fail876;
                  if(true)
                    break Success298;
                }
              }
              term = term303;
            }
            IStrategoTerm term304 = term;
            Success299:
            { 
              Fail878:
              { 
                term = n_32749;
                if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                  break Fail878;
                { 
                  if(true)
                    break Fail876;
                  if(true)
                    break Success299;
                }
              }
              term = term304;
            }
            term = string_length_0_0.instance.invoke(context, l_32749);
            if(term == null)
              break Fail876;
            term = int_to_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail876;
            term = double_quote_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail876;
            m_32749 = term;
            term = template_line_elements_to_stratego_0_0.instance.invoke(context, n_32749);
            if(term == null)
              break Fail876;
            term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{generated.constSVar9, generated.constNil3, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{m_32749})}), (IStrategoList)generated.constNil3)}), termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{term})})});
            if(true)
              break Success297;
          }
          term = term302;
        }
        Success300:
        { 
          if(cons15 == Main._consLine_1)
          { 
            Fail879:
            { 
              IStrategoTerm i_32749 = null;
              IStrategoTerm arg189 = term.getSubterm(0);
              if(arg189.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg189).isEmpty())
                break Fail879;
              IStrategoTerm arg190 = ((IStrategoList)arg189).head();
              if(arg190.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg190).getConstructor())
                break Fail879;
              IStrategoTerm arg191 = arg190.getSubterm(0);
              if(arg191.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)arg191).stringValue()))
                break Fail879;
              i_32749 = ((IStrategoList)arg189).tail();
              IStrategoTerm term306 = term;
              Success301:
              { 
                Fail880:
                { 
                  term = i_32749;
                  if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                    break Fail880;
                  { 
                    if(true)
                      break Fail879;
                    if(true)
                      break Success301;
                  }
                }
                term = term306;
              }
              term = template_line_elements_to_stratego_0_0.instance.invoke(context, i_32749);
              if(term == null)
                break Fail879;
              term = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const138, (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList5, termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil3))})});
              if(true)
                break Success300;
            }
            term = term302;
          }
          if(cons15 == Main._consLine_1)
          { 
            IStrategoTerm arg192 = term.getSubterm(0);
            if(arg192.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg192).isEmpty())
              break Fail875;
            IStrategoTerm arg193 = ((IStrategoList)arg192).head();
            if(arg193.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg193).getConstructor())
              break Fail875;
            IStrategoTerm arg195 = ((IStrategoList)arg192).tail();
            if(arg195.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg195).isEmpty())
              break Fail875;
            term = generated.constNoAnnoList32;
          }
          else
          { 
            break Fail875;
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