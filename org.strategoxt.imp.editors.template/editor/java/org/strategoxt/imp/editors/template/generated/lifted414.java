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

@SuppressWarnings("all") final class lifted414 extends Strategy 
{ 
  TermReference q_32778;

  TermReference r_32778;

  TermReference s_32778;

  TermReference t_32778;

  TermReference u_32778;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    Fail1594:
    { 
      if(r_32778.value == null || u_32778.value == null)
        break Fail1594;
      term = termFactory.makeTuple(r_32778.value, generated.constTemplateBySort0, u_32778.value);
      term = index_symbol_definition_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1594;
      IStrategoTerm term543 = term;
      Success590:
      { 
        Fail1595:
        { 
          IStrategoTerm v_32778 = null;
          v_32778 = term;
          if(q_32778.value == null)
            break Fail1595;
          term = fetch_cons_name_0_0.instance.invoke(context, q_32778.value);
          if(term == null)
            break Fail1595;
          if(s_32778.value == null)
            s_32778.value = term;
          else
            if(s_32778.value != term && !s_32778.value.match(term))
              break Fail1595;
          term = v_32778;
          { 
            if(r_32778.value == null || s_32778.value == null)
              break Fail1594;
            term = termFactory.makeTuple(r_32778.value, s_32778.value);
            if(t_32778.value == null)
              t_32778.value = term;
            else
              if(t_32778.value != term && !t_32778.value.match(term))
                break Fail1594;
            if(t_32778.value == null || u_32778.value == null)
              break Fail1594;
            term = termFactory.makeTuple(t_32778.value, generated.constTemplateBySortCons0, u_32778.value);
            term = index_symbol_definition_0_0.instance.invoke(context, term);
            if(term == null)
              break Fail1594;
            if(true)
              break Success590;
          }
        }
        term = term543;
      }
      if(true)
        return term;
    }
    return null;
  }
}