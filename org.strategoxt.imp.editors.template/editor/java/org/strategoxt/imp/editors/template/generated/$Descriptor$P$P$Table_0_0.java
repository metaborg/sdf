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

@SuppressWarnings("all") public class $Descriptor$P$P$Table_0_0 extends Strategy 
{ 
  public static $Descriptor$P$P$Table_0_0 instance = new $Descriptor$P$P$Table_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("DescriptorPPTable_0_0");
    Fail1457:
    { 
      TermReference h_32808 = new TermReference();
      IStrategoTerm k_32808 = null;
      IStrategoTerm m_32808 = null;
      IStrategoTerm n_32808 = null;
      if(h_32808.value == null)
        h_32808.value = term;
      else
        if(h_32808.value != term && !h_32808.value.match(term))
          break Fail1457;
      m_32808 = term;
      k_32808 = generated.const247;
      n_32808 = m_32808;
      term = dr_lookup_rule_0_2.instance.invoke(context, n_32808, k_32808, generated.constCons83);
      if(term == null)
        break Fail1457;
      lifted529 lifted5290 = new lifted529();
      lifted5290.h_32808 = h_32808;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted5290);
      if(term == null)
        break Fail1457;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}