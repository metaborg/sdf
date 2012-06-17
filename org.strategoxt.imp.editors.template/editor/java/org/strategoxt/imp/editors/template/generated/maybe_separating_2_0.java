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

@SuppressWarnings("all") public class maybe_separating_2_0 extends Strategy 
{ 
  public static maybe_separating_2_0 instance = new maybe_separating_2_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_32756, Strategy w_32756)
  { 
    context.push("maybe_separating_2_0");
    Fail912:
    { 
      IStrategoTerm term357 = term;
      Success322:
      { 
        Fail913:
        { 
          IStrategoTerm u_32756 = null;
          u_32756 = term;
          term = templatelang_get_option_0_0.instance.invoke(context, generated.constNewlines0);
          if(term == null)
            break Fail913;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consSeparating_0 != ((IStrategoAppl)term).getConstructor())
            break Fail913;
          term = u_32756;
          { 
            term = v_32756.invoke(context, term);
            if(term == null)
              break Fail912;
            if(true)
              break Success322;
          }
        }
        term = w_32756.invoke(context, term357);
        if(term == null)
          break Fail912;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}