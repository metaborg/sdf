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

@SuppressWarnings("all") public class descriptor_pp_table_0_0 extends Strategy 
{ 
  public static descriptor_pp_table_0_0 instance = new descriptor_pp_table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("descriptor_pp_table_0_0");
    Fail1175:
    { 
      IStrategoTerm j_32783 = null;
      Success510:
      { 
        Fail1176:
        { 
          term = $Descriptor$P$P$Table_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1176;
          if(true)
            break Success510;
        }
        IStrategoTerm n_32783 = null;
        IStrategoTerm k_32783 = null;
        IStrategoTerm l_32783 = null;
        IStrategoTerm p_32783 = null;
        IStrategoTerm q_32783 = null;
        IStrategoTerm s_32783 = null;
        IStrategoTerm t_32783 = null;
        IStrategoTerm u_32783 = null;
        n_32783 = generated.constEditorServiceprettyPpAf;
        term = generated.constEditorServiceprettyPpAf;
        j_32783 = n_32783;
        k_32783 = term;
        term = j_32783;
        l_32783 = j_32783;
        s_32783 = term;
        p_32783 = generated.const247;
        t_32783 = s_32783;
        q_32783 = generated.constCons83;
        u_32783 = t_32783;
        term = termFactory.makeTuple(generated.const248, l_32783);
        term = dr_set_rule_0_3.instance.invoke(context, u_32783, p_32783, q_32783, term);
        if(term == null)
          break Fail1175;
        term = k_32783;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}