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
    Fail1448:
    { 
      IStrategoTerm r_32806 = null;
      IStrategoTerm t_32806 = null;
      t_32806 = term;
      Success546:
      { 
        Fail1449:
        { 
          IStrategoTerm u_32806 = null;
          IStrategoTerm w_32806 = null;
          IStrategoTerm x_32806 = null;
          w_32806 = term;
          u_32806 = generated.const247;
          x_32806 = w_32806;
          term = dr_lookup_rule_0_2.instance.invoke(context, x_32806, u_32806, generated.constCons83);
          if(term == null)
            break Fail1449;
          if(true)
            break Success546;
        }
        term = generated.constNil3;
      }
      r_32806 = term;
      term = t_32806;
      term = termFactory.makeTuple(r_32806, term);
      term = foldl_1_0.instance.invoke(context, term, lifted524.instance);
      if(term == null)
        break Fail1448;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}