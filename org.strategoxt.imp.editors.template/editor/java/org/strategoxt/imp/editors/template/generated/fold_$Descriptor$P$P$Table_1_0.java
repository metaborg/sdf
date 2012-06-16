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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy l_9767)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_DescriptorPPTable_1_0");
    Fail624:
    { 
      IStrategoTerm m_9767 = null;
      IStrategoTerm o_9767 = null;
      o_9767 = term;
      Success288:
      { 
        Fail625:
        { 
          IStrategoTerm p_9767 = null;
          IStrategoTerm r_9767 = null;
          IStrategoTerm s_9767 = null;
          r_9767 = term;
          p_9767 = generated.const126;
          s_9767 = r_9767;
          term = dr_lookup_rule_0_2.instance.invoke(context, s_9767, p_9767, generated.constCons70);
          if(term == null)
            break Fail625;
          if(true)
            break Success288;
        }
        term = generated.constNil0;
      }
      m_9767 = term;
      term = o_9767;
      term = termFactory.makeTuple(m_9767, term);
      term = l_9767.invoke(context, term, lifted323.instance);
      if(term == null)
        break Fail624;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}