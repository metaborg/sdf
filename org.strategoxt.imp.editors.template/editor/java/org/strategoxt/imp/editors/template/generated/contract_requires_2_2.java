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

@SuppressWarnings("all") public class contract_requires_2_2 extends Strategy 
{ 
  public static contract_requires_2_2 instance = new contract_requires_2_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy j_32788, Strategy k_32788, IStrategoTerm h_32788, IStrategoTerm i_32788)
  { 
    context.push("contract_requires_2_2");
    Fail1202:
    { 
      IStrategoTerm term632 = term;
      Success519:
      { 
        Fail1203:
        { 
          term = contract_requires_1_2.instance.invoke(context, term, j_32788, h_32788, i_32788);
          if(term == null)
            break Fail1203;
          if(true)
            break Success519;
        }
        term = k_32788.invoke(context, term632);
        if(term == null)
          break Fail1202;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}