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
    Fail1446:
    { 
      IStrategoTerm g_32806 = null;
      IStrategoTerm i_32806 = null;
      i_32806 = term;
      Success545:
      { 
        Fail1447:
        { 
          IStrategoTerm j_32806 = null;
          IStrategoTerm l_32806 = null;
          IStrategoTerm m_32806 = null;
          l_32806 = term;
          j_32806 = generated.const247;
          m_32806 = l_32806;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, m_32806, j_32806, generated.constCons83);
          if(term == null)
            break Fail1447;
          if(true)
            break Success545;
        }
        term = generated.constNil3;
      }
      g_32806 = term;
      term = i_32806;
      term = termFactory.makeTuple(g_32806, term);
      term = foldl_1_0.instance.invoke(context, term, lifted523.instance);
      if(term == null)
        break Fail1446;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}