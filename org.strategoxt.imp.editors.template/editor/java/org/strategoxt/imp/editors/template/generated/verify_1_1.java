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

@SuppressWarnings("all") public class verify_1_1 extends Strategy 
{ 
  public static verify_1_1 instance = new verify_1_1();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy f_32788, IStrategoTerm ref_e_32788)
  { 
    TermReference e_32788 = new TermReference(ref_e_32788);
    context.push("verify_1_1");
    Fail1200:
    { 
      lifted446 lifted4460 = new lifted446();
      lifted4460.f_32788 = f_32788;
      lifted4460.e_32788 = e_32788;
      term = contracts_1_0.instance.invoke(context, term, lifted4460);
      if(term == null)
        break Fail1200;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}