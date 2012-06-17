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
    Fail1188:
    { 
      IStrategoTerm r_32785 = null;
      IStrategoTerm t_32785 = null;
      IStrategoTerm u_32785 = null;
      IStrategoTerm v_32785 = null;
      IStrategoTerm x_32785 = null;
      IStrategoTerm y_32785 = null;
      IStrategoTerm z_32785 = null;
      IStrategoTerm b_32786 = null;
      IStrategoTerm c_32786 = null;
      IStrategoTerm d_32786 = null;
      IStrategoTerm f_32786 = null;
      IStrategoTerm g_32786 = null;
      IStrategoTerm h_32786 = null;
      IStrategoTerm j_32786 = null;
      IStrategoTerm k_32786 = null;
      IStrategoTerm l_32786 = null;
      IStrategoTerm n_32786 = null;
      IStrategoTerm o_32786 = null;
      t_32785 = term;
      r_32785 = generated.const252;
      u_32785 = t_32785;
      term = string_replace_0_2.instance.invoke(context, u_32785, r_32785, generated.const253);
      if(term == null)
        break Fail1188;
      x_32785 = term;
      v_32785 = generated.const206;
      y_32785 = x_32785;
      term = string_replace_0_2.instance.invoke(context, y_32785, v_32785, generated.const203);
      if(term == null)
        break Fail1188;
      b_32786 = term;
      z_32785 = generated.const254;
      c_32786 = b_32786;
      term = string_replace_0_2.instance.invoke(context, c_32786, z_32785, generated.const255);
      if(term == null)
        break Fail1188;
      f_32786 = term;
      d_32786 = generated.const160;
      g_32786 = f_32786;
      term = string_replace_0_2.instance.invoke(context, g_32786, d_32786, generated.const201);
      if(term == null)
        break Fail1188;
      j_32786 = term;
      h_32786 = generated.const256;
      k_32786 = j_32786;
      term = string_replace_0_2.instance.invoke(context, k_32786, h_32786, generated.const257);
      if(term == null)
        break Fail1188;
      n_32786 = term;
      l_32786 = generated.const196;
      o_32786 = n_32786;
      term = string_replace_0_2.instance.invoke(context, o_32786, l_32786, generated.const258);
      if(term == null)
        break Fail1188;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}