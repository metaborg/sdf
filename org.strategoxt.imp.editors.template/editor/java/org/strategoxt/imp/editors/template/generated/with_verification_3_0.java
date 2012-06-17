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

@SuppressWarnings("all") public class with_verification_3_0 extends Strategy 
{ 
  public static with_verification_3_0 instance = new with_verification_3_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy a_32789, Strategy b_32789, Strategy c_32789)
  { 
    context.push("with_verification_3_0");
    Fail1211:
    { 
      IStrategoTerm y_32788 = null;
      IStrategoTerm z_32788 = null;
      y_32788 = term;
      term = a_32789.invoke(context, term);
      if(term == null)
        break Fail1211;
      term = b_32789.invoke(context, y_32788);
      if(term == null)
        break Fail1211;
      z_32788 = term;
      term = c_32789.invoke(context, term);
      if(term == null)
        break Fail1211;
      term = z_32788;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}