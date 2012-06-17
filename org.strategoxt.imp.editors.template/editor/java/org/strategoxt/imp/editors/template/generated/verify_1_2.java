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

@SuppressWarnings("all") public class verify_1_2 extends Strategy 
{ 
  public static verify_1_2 instance = new verify_1_2();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy d_32788, IStrategoTerm ref_b_32788, IStrategoTerm ref_c_32788)
  { 
    TermReference b_32788 = new TermReference(ref_b_32788);
    TermReference c_32788 = new TermReference(ref_c_32788);
    context.push("verify_1_2");
    Fail1199:
    { 
      lifted445 lifted4450 = new lifted445();
      lifted4450.d_32788 = d_32788;
      lifted4450.b_32788 = b_32788;
      lifted4450.c_32788 = c_32788;
      term = contracts_1_0.instance.invoke(context, term, lifted4450);
      if(term == null)
        break Fail1199;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}