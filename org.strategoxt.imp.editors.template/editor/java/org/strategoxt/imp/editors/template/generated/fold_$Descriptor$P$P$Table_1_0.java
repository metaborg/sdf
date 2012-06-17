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

@SuppressWarnings("all") public class fold_$Descriptor$P$P$Table_1_0 extends Strategy 
{ 
  public static fold_$Descriptor$P$P$Table_1_0 instance = new fold_$Descriptor$P$P$Table_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_32805)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_DescriptorPPTable_1_0");
    Fail1444:
    { 
      IStrategoTerm v_32805 = null;
      IStrategoTerm x_32805 = null;
      x_32805 = term;
      Success544:
      { 
        Fail1445:
        { 
          IStrategoTerm y_32805 = null;
          IStrategoTerm a_32806 = null;
          IStrategoTerm b_32806 = null;
          a_32806 = term;
          y_32805 = generated.const247;
          b_32806 = a_32806;
          term = dr_lookup_rule_0_2.instance.invoke(context, b_32806, y_32805, generated.constCons83);
          if(term == null)
            break Fail1445;
          if(true)
            break Success544;
        }
        term = generated.constNil3;
      }
      v_32805 = term;
      term = x_32805;
      term = termFactory.makeTuple(v_32805, term);
      term = u_32805.invoke(context, term, lifted522.instance);
      if(term == null)
        break Fail1444;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}