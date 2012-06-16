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

@SuppressWarnings("all") public class determine_score_0_0 extends Strategy 
{ 
  public static determine_score_0_0 instance = new determine_score_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("determine_score_0_0");
    Fail196:
    { 
      IStrategoTerm s_9728 = null;
      IStrategoTerm t_9728 = null;
      IStrategoTerm u_9728 = null;
      u_9728 = term;
      term = u_9728;
      Success141:
      { 
        Fail197:
        { 
          term = is_deprecated_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail197;
          { 
            term = generated.const93;
            if(true)
              break Success141;
          }
        }
        term = generated.const45;
      }
      s_9728 = term;
      term = u_9728;
      Success142:
      { 
        Fail198:
        { 
          term = is_completion_prefer_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail198;
          { 
            term = generated.const94;
            if(true)
              break Success142;
          }
        }
        term = generated.const45;
      }
      t_9728 = term;
      term = u_9728;
      Success143:
      { 
        Fail199:
        { 
          term = is_completion_avoid_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail199;
          { 
            term = generated.const95;
            if(true)
              break Success143;
          }
        }
        term = generated.const45;
      }
      term = (IStrategoTerm)termFactory.makeListCons(s_9728, termFactory.makeListCons(t_9728, termFactory.makeListCons(term, (IStrategoList)generated.constNil0)));
      term = sum_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail196;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}