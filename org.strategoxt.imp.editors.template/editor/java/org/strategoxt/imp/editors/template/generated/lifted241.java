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

@SuppressWarnings("all") final class lifted241 extends Strategy 
{ 
  TermReference s_32749;

  TermReference t_32749;

  TermReference u_32749;

  TermReference v_32749;

  TermReference w_32749;

  TermReference x_32749;

  TermReference y_32749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1782:
    { 
      IStrategoTerm term322 = term;
      Success648:
      { 
        Fail1783:
        { 
          IStrategoTerm r_32750 = null;
          r_32750 = term;
          z_32750 z_327500 = new z_32750();
          z_327500.s_32749 = s_32749;
          term = z_327500.invoke(context, term);
          if(term == null)
            break Fail1783;
          if(u_32749.value == null)
            u_32749.value = term;
          else
            if(u_32749.value != term && !u_32749.value.match(term))
              break Fail1783;
          term = r_32750;
          { 
            IStrategoTerm s_32750 = null;
            IStrategoTerm t_32750 = null;
            t_32750 = term;
            if(u_32749.value == null)
              break Fail1782;
            term = explode_string_0_0.instance.invoke(context, u_32749.value);
            if(term == null)
              break Fail1782;
            term = occurrences_1_0.instance.invoke(context, term, lifted245.instance);
            if(term == null)
              break Fail1782;
            term = dec_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1782;
            if(w_32749.value == null)
              w_32749.value = term;
            else
              if(w_32749.value != term && !w_32749.value.match(term))
                break Fail1782;
            s_32750 = term;
            term = t_32750;
            IStrategoTerm term323 = term;
            Success649:
            { 
              Fail1784:
              { 
                IStrategoTerm u_32750 = null;
                u_32750 = term;
                term = s_32750;
                if(term.getTermType() != IStrategoTerm.INT || -1 != ((IStrategoInt)term).intValue())
                  break Fail1784;
                term = u_32750;
                { 
                  IStrategoTerm n_32751 = null;
                  IStrategoTerm p_32751 = null;
                  IStrategoTerm o_32751 = null;
                  IStrategoTerm q_32751 = null;
                  if(u_32749.value == null)
                    break Fail1782;
                  term = templatelang_escape_0_0.instance.invoke(context, u_32749.value);
                  if(term == null)
                    break Fail1782;
                  term = double_quote_0_0.instance.invoke(context, term);
                  if(term == null)
                    break Fail1782;
                  if(v_32749.value == null)
                    v_32749.value = term;
                  else
                    if(v_32749.value != term && !v_32749.value.match(term))
                      break Fail1782;
                  p_32751 = term;
                  a_32751 a_327510 = new a_32751();
                  a_327510.s_32749 = s_32749;
                  term = a_327510.invoke(context, term);
                  if(term == null)
                    break Fail1782;
                  n_32751 = term;
                  term = p_32751;
                  q_32751 = p_32751;
                  b_32751 b_327510 = new b_32751();
                  b_327510.t_32749 = t_32749;
                  term = b_327510.invoke(context, term);
                  if(term == null)
                    break Fail1782;
                  o_32751 = term;
                  term = q_32751;
                  if(v_32749.value == null)
                    break Fail1782;
                  term = termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{n_32751, (IStrategoTerm)termFactory.makeListCons(o_32751, (IStrategoList)generated.constNil3), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{v_32749.value})}), (IStrategoList)generated.constNil3)});
                  if(y_32749.value == null)
                    y_32749.value = term;
                  else
                    if(y_32749.value != term && !y_32749.value.match(term))
                      break Fail1782;
                  if(true)
                    break Success649;
                }
              }
              term = term323;
              IStrategoTerm term324 = term;
              Success650:
              { 
                Fail1785:
                { 
                  IStrategoTerm v_32750 = null;
                  v_32750 = term;
                  term = s_32750;
                  if(term.getTermType() != IStrategoTerm.INT || 0 != ((IStrategoInt)term).intValue())
                    break Fail1785;
                  term = v_32750;
                  { 
                    b_32751 b_327511 = new b_32751();
                    b_327511.t_32749 = t_32749;
                    term = b_327511.invoke(context, term);
                    if(term == null)
                      break Fail1782;
                    term = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{generated.constSVar11, (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3)});
                    if(y_32749.value == null)
                      y_32749.value = term;
                    else
                      if(y_32749.value != term && !y_32749.value.match(term))
                        break Fail1782;
                    if(true)
                      break Success650;
                  }
                }
                term = term324;
                IStrategoTerm t_32751 = null;
                IStrategoTerm u_32751 = null;
                if(w_32749.value == null)
                  break Fail1782;
                term = int_to_string_0_0.instance.invoke(context, w_32749.value);
                if(term == null)
                  break Fail1782;
                term = double_quote_0_0.instance.invoke(context, term);
                if(term == null)
                  break Fail1782;
                if(x_32749.value == null)
                  x_32749.value = term;
                else
                  if(x_32749.value != term && !x_32749.value.match(term))
                    break Fail1782;
                u_32751 = term;
                b_32751 b_327512 = new b_32751();
                b_327512.t_32749 = t_32749;
                term = b_327512.invoke(context, term);
                if(term == null)
                  break Fail1782;
                t_32751 = term;
                term = u_32751;
                if(x_32749.value == null)
                  break Fail1782;
                term = termFactory.makeAppl(Main._consCallT_3, new IStrategoTerm[]{generated.constSVar11, (IStrategoTerm)termFactory.makeListCons(t_32751, (IStrategoList)generated.constNil3), (IStrategoTerm)termFactory.makeListCons(termFactory.makeAppl(Main._consNoAnnoList_1, new IStrategoTerm[]{termFactory.makeAppl(Main._consStr_1, new IStrategoTerm[]{x_32749.value})}), (IStrategoList)generated.constNil3)});
                if(y_32749.value == null)
                  y_32749.value = term;
                else
                  if(y_32749.value != term && !y_32749.value.match(term))
                    break Fail1782;
              }
            }
            if(true)
              break Success648;
          }
        }
        term = term322;
        IStrategoTerm v_32751 = null;
        IStrategoTerm x_32751 = null;
        x_32751 = term;
        a_32751 a_327511 = new a_32751();
        a_327511.s_32749 = s_32749;
        term = a_327511.invoke(context, term);
        if(term == null)
          break Fail1782;
        v_32751 = term;
        term = x_32751;
        b_32751 b_327513 = new b_32751();
        b_327513.t_32749 = t_32749;
        term = b_327513.invoke(context, term);
        if(term == null)
          break Fail1782;
        term = termFactory.makeAppl(Main._consCall_2, new IStrategoTerm[]{v_32751, (IStrategoTerm)termFactory.makeListCons(term, (IStrategoList)generated.constNil3)});
        if(y_32749.value == null)
          y_32749.value = term;
        else
          if(y_32749.value != term && !y_32749.value.match(term))
            break Fail1782;
      }
      if(true)
        return term;
    }
    return null;
  }
}