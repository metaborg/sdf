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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy i_32805)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_DescriptorPPTable_1_0");
    Fail1442:
    { 
      IStrategoTerm j_32805 = null;
      IStrategoTerm l_32805 = null;
      l_32805 = term;
      Success543:
      { 
        Fail1443:
        { 
          IStrategoTerm m_32805 = null;
          IStrategoTerm o_32805 = null;
          IStrategoTerm p_32805 = null;
          o_32805 = term;
          m_32805 = generated.const247;
          p_32805 = o_32805;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, p_32805, m_32805, generated.constCons83);
          if(term == null)
            break Fail1443;
          if(true)
            break Success543;
        }
        term = generated.constNil3;
      }
      j_32805 = term;
      term = l_32805;
      term = termFactory.makeTuple(j_32805, term);
      term = i_32805.invoke(context, term, lifted521.instance);
      if(term == null)
        break Fail1442;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}