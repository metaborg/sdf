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

@SuppressWarnings("all") public class bigchain_$Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static bigchain_$Descriptor$P$P$Table_0_0 instance = new bigchain_$Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_DescriptorPPTable_0_0");
    Fail626:
    { 
      IStrategoTerm x_9767 = null;
      IStrategoTerm z_9767 = null;
      z_9767 = term;
      Success289:
      { 
        Fail627:
        { 
          IStrategoTerm a_9768 = null;
          IStrategoTerm c_9768 = null;
          IStrategoTerm d_9768 = null;
          c_9768 = term;
          a_9768 = generated.const126;
          d_9768 = c_9768;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, d_9768, a_9768, generated.constCons70);
          if(term == null)
            break Fail627;
          if(true)
            break Success289;
        }
        term = generated.constNil0;
      }
      x_9767 = term;
      term = z_9767;
      term = termFactory.makeTuple(x_9767, term);
      term = foldl_1_0.instance.invoke(context, term, lifted324.instance);
      if(term == null)
        break Fail626;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}