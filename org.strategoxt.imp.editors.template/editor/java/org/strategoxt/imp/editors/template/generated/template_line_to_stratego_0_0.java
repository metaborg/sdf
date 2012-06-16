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
    Fail56:
    { 
      IStrategoTerm term47 = term;
      IStrategoConstructor cons3 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success42:
      { 
        if(cons3 == Main._consLine_1)
        { 
          Fail57:
          { 
            IStrategoTerm d_9711 = null;
            IStrategoTerm e_9711 = null;
            IStrategoTerm f_9711 = null;
            IStrategoTerm arg39 = term.getSubterm(0);
            if(arg39.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg39).isEmpty())
              break Fail57;
            IStrategoTerm arg40 = ((IStrategoList)arg39).head();
            if(arg40.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg40).getConstructor())
              break Fail57;
            d_9711 = arg40.getSubterm(0);
            f_9711 = ((IStrategoList)arg39).tail();
            IStrategoTerm term48 = term;
            Success43:
            { 
              Fail58:
              { 
                term = d_9711;
                if(term.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)term).stringValue()))
                  break Fail58;
                { 
                  if(true)
                    break Fail57;
                  if(true)
                    break Success43;
                }
              }
              term = term48;
            }
            IStrategoTerm term49 = term;
            Success44:
            { 
              Fail59:
              { 
                term = f_9711;
                if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                  break Fail59;
                { 
                  if(true)
                    break Fail57;
                  if(true)
                    break Success44;
                }
              }
              term = term49;
            }
            term = string_length_0_0.instance.invoke(context, d_9711);
            if(term == null)
              break Fail57;
            term = int_to_string_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail57;
            term = double_quote_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail57;
            e_9711 = term;
            term = template_line_elements_to_stratego_0_0.instance.invoke(context, f_9711);
            if(term == null)
              break Fail57;
            term = termFactory.makeAppl(Main._consApp_2, new IStrategoTerm[]{termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{generated.constSVar9, generated.constNil0, (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{e_9711})}), (IStrategoList)generated.constNil0)}), termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{term})})});
            if(true)
              break Success42;
          }
          term = term47;
        }
        Success45:
        { 
          if(cons3 == Main._consLine_1)
          { 
            Fail60:
            { 
              IStrategoTerm a_9711 = null;
              IStrategoTerm arg41 = term.getSubterm(0);
              if(arg41.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg41).isEmpty())
                break Fail60;
              IStrategoTerm arg42 = ((IStrategoList)arg41).head();
              if(arg42.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg42).getConstructor())
                break Fail60;
              IStrategoTerm arg43 = arg42.getSubterm(0);
              if(arg43.getTermType() != IStrategoTerm.STRING || !"".equals(((IStrategoString)arg43).stringValue()))
                break Fail60;
              a_9711 = ((IStrategoList)arg41).tail();
              IStrategoTerm term51 = term;
              Success46:
              { 
                Fail61:
                { 
                  term = a_9711;
                  if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
                    break Fail61;
                  { 
                    if(true)
                      break Fail60;
                    if(true)
                      break Success46;
                  }
                }
                term = term51;
              }
              term = template_line_elements_to_stratego_0_0.instance.invoke(context, a_9711);
              if(term == null)
                break Fail60;
              term = termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const17, (IStrategoTerm)termFactory.makeListCons(generated.constNoAnnoList5, termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consList_1, new IStrategoTerm[]{term})}), (IStrategoList)generated.constNil0))})});
              if(true)
                break Success45;
            }
            term = term47;
          }
          if(cons3 == Main._consLine_1)
          { 
            IStrategoTerm arg44 = term.getSubterm(0);
            if(arg44.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg44).isEmpty())
              break Fail56;
            IStrategoTerm arg45 = ((IStrategoList)arg44).head();
            if(arg45.getTermType() != IStrategoTerm.APPL || Main._consLayout_1 != ((IStrategoAppl)arg45).getConstructor())
              break Fail56;
            IStrategoTerm arg47 = ((IStrategoList)arg44).tail();
            if(arg47.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg47).isEmpty())
              break Fail56;
            term = generated.constNoAnnoList32;
          }
          else
          { 
            break Fail56;
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