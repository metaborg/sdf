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

@SuppressWarnings("all") public class chain_$Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static chain_$Descriptor$P$P$Table_0_0 instance = new chain_$Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("chain_DescriptorPPTable_0_0");
    Fail628:
    { 
      IStrategoTerm i_9768 = null;
      IStrategoTerm k_9768 = null;
      k_9768 = term;
      Success290:
      { 
        Fail629:
        { 
          IStrategoTerm l_9768 = null;
          IStrategoTerm n_9768 = null;
          IStrategoTerm o_9768 = null;
          n_9768 = term;
          l_9768 = generated.const126;
          o_9768 = n_9768;
          term = dr_lookup_rule_0_2.instance.invoke(context, o_9768, l_9768, generated.constCons70);
          if(term == null)
            break Fail629;
          if(true)
            break Success290;
        }
        term = generated.constNil0;
      }
      i_9768 = term;
      term = k_9768;
      term = termFactory.makeTuple(i_9768, term);
      term = foldl_1_0.instance.invoke(context, term, lifted325.instance);
      if(term == null)
        break Fail628;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}