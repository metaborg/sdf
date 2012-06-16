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
    Fail355:
    { 
      IStrategoTerm a_9745 = null;
      Success254:
      { 
        Fail356:
        { 
          term = $Descriptor$P$P$Table_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail356;
          if(true)
            break Success254;
        }
        IStrategoTerm e_9745 = null;
        IStrategoTerm b_9745 = null;
        IStrategoTerm c_9745 = null;
        IStrategoTerm g_9745 = null;
        IStrategoTerm h_9745 = null;
        IStrategoTerm j_9745 = null;
        IStrategoTerm k_9745 = null;
        IStrategoTerm l_9745 = null;
        e_9745 = generated.constEditorServiceprettyPpAf;
        term = generated.constEditorServiceprettyPpAf;
        a_9745 = e_9745;
        b_9745 = term;
        term = a_9745;
        c_9745 = a_9745;
        j_9745 = term;
        g_9745 = generated.const126;
        k_9745 = j_9745;
        h_9745 = generated.constCons70;
        l_9745 = k_9745;
        term = termFactory.makeTuple(generated.const127, c_9745);
        term = dr_set_rule_0_3.instance.invoke(context, l_9745, g_9745, h_9745, term);
        if(term == null)
          break Fail355;
        term = b_9745;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}