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

@SuppressWarnings("all") final class lifted222 extends Strategy 
{ 
  TermReference r_32747;

  TermReference s_32747;

  TermReference t_32747;

  TermReference u_32747;

  TermReference v_32747;

  TermReference w_32747;

  TermReference x_32747;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1818:
    { 
      if(r_32747.value == null)
        break Fail1818;
      term = termFactory.makeTuple(r_32747.value, generated.const166);
      term = thread_map_1_0.instance.invoke(context, term, rename_template_line_0_0.instance);
      if(term == null)
        break Fail1818;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1818;
      if(t_32747.value == null)
        t_32747.value = term.getSubterm(0);
      else
        if(t_32747.value != term.getSubterm(0) && !t_32747.value.match(term.getSubterm(0)))
          break Fail1818;
      if(t_32747.value == null)
        break Fail1818;
      term = map_1_0.instance.invoke(context, t_32747.value, template_line_to_stratego_0_0.instance);
      if(term == null)
        break Fail1818;
      if(s_32747.value == null)
        s_32747.value = term;
      else
        if(s_32747.value != term && !s_32747.value.match(term))
          break Fail1818;
      if(t_32747.value == null)
        break Fail1818;
      term = mapconcat_1_0.instance.invoke(context, t_32747.value, template_line_to_cons_arg_0_0.instance);
      if(term == null)
        break Fail1818;
      if(w_32747.value == null)
        w_32747.value = term;
      else
        if(w_32747.value != term && !w_32747.value.match(term))
          break Fail1818;
      IStrategoTerm term295 = term;
      Success661:
      { 
        Fail1819:
        { 
          IStrategoTerm y_32747 = null;
          y_32747 = term;
          if(v_32747.value == null)
            break Fail1819;
          term = fetch_cons_name_0_0.instance.invoke(context, v_32747.value);
          if(term == null)
            break Fail1819;
          if(u_32747.value == null)
            u_32747.value = term;
          else
            if(u_32747.value != term && !u_32747.value.match(term))
              break Fail1819;
          term = y_32747;
          { 
            if(u_32747.value == null || w_32747.value == null)
              break Fail1818;
            term = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{u_32747.value, w_32747.value});
            if(x_32747.value == null)
              x_32747.value = term;
            else
              if(x_32747.value != term && !x_32747.value.match(term))
                break Fail1818;
            if(true)
              break Success661;
          }
        }
        term = term295;
        IStrategoTerm term296 = term;
        Success662:
        { 
          Fail1820:
          { 
            IStrategoTerm z_32747 = null;
            z_32747 = term;
            if(w_32747.value == null)
              break Fail1820;
            term = w_32747.value;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1820;
            IStrategoTerm arg178 = ((IStrategoList)term).tail();
            if(arg178.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg178).isEmpty())
              break Fail1820;
            term = z_32747;
            { 
              Success663:
              { 
                Fail1821:
                { 
                  IStrategoTerm a_32748 = null;
                  a_32748 = term;
                  if(v_32747.value == null)
                    break Fail1821;
                  term = is_bracket_0_0.instance.invoke(context, v_32747.value);
                  if(term == null)
                    break Fail1821;
                  term = a_32748;
                  { 
                    if(w_32747.value == null)
                      break Fail1818;
                    term = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const155, w_32747.value});
                    if(x_32747.value == null)
                      x_32747.value = term;
                    else
                      if(x_32747.value != term && !x_32747.value.match(term))
                        break Fail1818;
                    if(true)
                      break Success663;
                  }
                }
                term = generated.constVar3;
                if(x_32747.value == null)
                  x_32747.value = term;
                else
                  if(x_32747.value != term && !x_32747.value.match(term))
                    break Fail1818;
              }
              if(true)
                break Success662;
            }
          }
          term = term296;
          if(w_32747.value == null)
            break Fail1818;
          term = termFactory.makeAppl(Main._consTuple_1, new IStrategoTerm[]{w_32747.value});
          if(x_32747.value == null)
            x_32747.value = term;
          else
            if(x_32747.value != term && !x_32747.value.match(term))
              break Fail1818;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}