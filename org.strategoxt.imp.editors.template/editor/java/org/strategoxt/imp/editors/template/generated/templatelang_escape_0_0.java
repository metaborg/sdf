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

@SuppressWarnings("all") public class templatelang_escape_0_0 extends Strategy 
{ 
  public static templatelang_escape_0_0 instance = new templatelang_escape_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("templatelang_escape_0_0");
    Fail368:
    { 
      IStrategoTerm i_9747 = null;
      IStrategoTerm k_9747 = null;
      IStrategoTerm l_9747 = null;
      IStrategoTerm m_9747 = null;
      IStrategoTerm o_9747 = null;
      IStrategoTerm p_9747 = null;
      IStrategoTerm q_9747 = null;
      IStrategoTerm s_9747 = null;
      IStrategoTerm t_9747 = null;
      IStrategoTerm u_9747 = null;
      IStrategoTerm w_9747 = null;
      IStrategoTerm x_9747 = null;
      IStrategoTerm y_9747 = null;
      IStrategoTerm a_9748 = null;
      IStrategoTerm b_9748 = null;
      IStrategoTerm c_9748 = null;
      IStrategoTerm e_9748 = null;
      IStrategoTerm f_9748 = null;
      k_9747 = term;
      i_9747 = generated.const131;
      l_9747 = k_9747;
      term = string_replace_0_2.instance.invoke(context, l_9747, i_9747, generated.const132);
      if(term == null)
        break Fail368;
      o_9747 = term;
      m_9747 = generated.const85;
      p_9747 = o_9747;
      term = string_replace_0_2.instance.invoke(context, p_9747, m_9747, generated.const82);
      if(term == null)
        break Fail368;
      s_9747 = term;
      q_9747 = generated.const133;
      t_9747 = s_9747;
      term = string_replace_0_2.instance.invoke(context, t_9747, q_9747, generated.const134);
      if(term == null)
        break Fail368;
      w_9747 = term;
      u_9747 = generated.const39;
      x_9747 = w_9747;
      term = string_replace_0_2.instance.invoke(context, x_9747, u_9747, generated.const80);
      if(term == null)
        break Fail368;
      a_9748 = term;
      y_9747 = generated.const135;
      b_9748 = a_9748;
      term = string_replace_0_2.instance.invoke(context, b_9748, y_9747, generated.const136);
      if(term == null)
        break Fail368;
      e_9748 = term;
      c_9748 = generated.const75;
      f_9748 = e_9748;
      term = string_replace_0_2.instance.invoke(context, f_9748, c_9748, generated.const137);
      if(term == null)
        break Fail368;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}