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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy n_9718, Strategy o_9718)
  { 
    context.push("maybe_separating_2_0");
    Fail93:
    { 
      IStrategoTerm term102 = term;
      Success67:
      { 
        Fail94:
        { 
          IStrategoTerm m_9718 = null;
          m_9718 = term;
          term = templatelang_get_option_0_0.instance.invoke(context, generated.constNewlines0);
          if(term == null)
            break Fail94;
          if(term.getTermType() != IStrategoTerm.APPL || Main._consSeparating_0 != ((IStrategoAppl)term).getConstructor())
            break Fail94;
          term = m_9718;
          { 
            term = n_9718.invoke(context, term);
            if(term == null)
              break Fail93;
            if(true)
              break Success67;
          }
        }
        term = o_9718.invoke(context, term102);
        if(term == null)
          break Fail93;
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}