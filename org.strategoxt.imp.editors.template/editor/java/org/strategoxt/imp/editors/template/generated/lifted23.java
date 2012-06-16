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

@SuppressWarnings("all") final class lifted23 extends Strategy 
{ 
  TermReference j_9709;

  TermReference k_9709;

  TermReference l_9709;

  TermReference m_9709;

  TermReference n_9709;

  TermReference o_9709;

  TermReference p_9709;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail998:
    { 
      if(j_9709.value == null)
        break Fail998;
      term = termFactory.makeTuple(j_9709.value, generated.const45);
      term = thread_map_1_0.instance.invoke(context, term, rename_template_line_0_0.instance);
      if(term == null)
        break Fail998;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail998;
      if(l_9709.value == null)
        l_9709.value = term.getSubterm(0);
      else
        if(l_9709.value != term.getSubterm(0) && !l_9709.value.match(term.getSubterm(0)))
          break Fail998;
      if(l_9709.value == null)
        break Fail998;
      term = map_1_0.instance.invoke(context, l_9709.value, template_line_to_stratego_0_0.instance);
      if(term == null)
        break Fail998;
      if(k_9709.value == null)
        k_9709.value = term;
      else
        if(k_9709.value != term && !k_9709.value.match(term))
          break Fail998;
      if(l_9709.value == null)
        break Fail998;
      term = mapconcat_1_0.instance.invoke(context, l_9709.value, template_line_to_cons_arg_0_0.instance);
      if(term == null)
        break Fail998;
      if(o_9709.value == null)
        o_9709.value = term;
      else
        if(o_9709.value != term && !o_9709.value.match(term))
          break Fail998;
      IStrategoTerm term40 = term;
      Success405:
      { 
        Fail999:
        { 
          IStrategoTerm q_9709 = null;
          q_9709 = term;
          if(n_9709.value == null)
            break Fail999;
          term = fetch_cons_name_0_0.instance.invoke(context, n_9709.value);
          if(term == null)
            break Fail999;
          if(m_9709.value == null)
            m_9709.value = term;
          else
            if(m_9709.value != term && !m_9709.value.match(term))
              break Fail999;
          term = q_9709;
          { 
            if(m_9709.value == null || o_9709.value == null)
              break Fail998;
            term = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{m_9709.value, o_9709.value});
            if(p_9709.value == null)
              p_9709.value = term;
            else
              if(p_9709.value != term && !p_9709.value.match(term))
                break Fail998;
            if(true)
              break Success405;
          }
        }
        term = term40;
        IStrategoTerm term41 = term;
        Success406:
        { 
          Fail1000:
          { 
            IStrategoTerm r_9709 = null;
            r_9709 = term;
            if(o_9709.value == null)
              break Fail1000;
            term = o_9709.value;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1000;
            IStrategoTerm arg30 = ((IStrategoList)term).tail();
            if(arg30.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg30).isEmpty())
              break Fail1000;
            term = r_9709;
            { 
              Success407:
              { 
                Fail1001:
                { 
                  IStrategoTerm s_9709 = null;
                  s_9709 = term;
                  if(n_9709.value == null)
                    break Fail1001;
                  term = is_bracket_0_0.instance.invoke(context, n_9709.value);
                  if(term == null)
                    break Fail1001;
                  term = s_9709;
                  { 
                    if(o_9709.value == null)
                      break Fail998;
                    term = termFactory.makeAppl(Main._consOp_2, new IStrategoTerm[]{generated.const34, o_9709.value});
                    if(p_9709.value == null)
                      p_9709.value = term;
                    else
                      if(p_9709.value != term && !p_9709.value.match(term))
                        break Fail998;
                    if(true)
                      break Success407;
                  }
                }
                term = generated.constVar3;
                if(p_9709.value == null)
                  p_9709.value = term;
                else
                  if(p_9709.value != term && !p_9709.value.match(term))
                    break Fail998;
              }
              if(true)
                break Success406;
            }
          }
          term = term41;
          if(o_9709.value == null)
            break Fail998;
          term = termFactory.makeAppl(Main._consTuple_1, new IStrategoTerm[]{o_9709.value});
          if(p_9709.value == null)
            p_9709.value = term;
          else
            if(p_9709.value != term && !p_9709.value.match(term))
              break Fail998;
        }
      }
      if(true)
        return term;
    }
    return null;
  }
}