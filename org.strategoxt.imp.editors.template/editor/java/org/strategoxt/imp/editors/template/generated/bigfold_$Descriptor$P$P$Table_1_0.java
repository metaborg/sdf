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

@SuppressWarnings("all") public class bigfold_$Descriptor$P$P$Table_1_0 extends Strategy 
{ 
  public static bigfold_$Descriptor$P$P$Table_1_0 instance = new bigfold_$Descriptor$P$P$Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy z_9766)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_DescriptorPPTable_1_0");
    Fail622:
    { 
      IStrategoTerm a_9767 = null;
      IStrategoTerm c_9767 = null;
      c_9767 = term;
      Success287:
      { 
        Fail623:
        { 
          IStrategoTerm d_9767 = null;
          IStrategoTerm f_9767 = null;
          IStrategoTerm g_9767 = null;
          f_9767 = term;
          d_9767 = generated.const126;
          g_9767 = f_9767;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, g_9767, d_9767, generated.constCons70);
          if(term == null)
            break Fail623;
          if(true)
            break Success287;
        }
        term = generated.constNil0;
      }
      a_9767 = term;
      term = c_9767;
      term = termFactory.makeTuple(a_9767, term);
      term = z_9766.invoke(context, term, lifted322.instance);
      if(term == null)
        break Fail622;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}