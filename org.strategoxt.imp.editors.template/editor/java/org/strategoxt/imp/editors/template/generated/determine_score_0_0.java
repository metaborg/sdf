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
    Fail1016:
    { 
      IStrategoTerm b_32767 = null;
      IStrategoTerm c_32767 = null;
      IStrategoTerm d_32767 = null;
      d_32767 = term;
      term = d_32767;
      Success397:
      { 
        Fail1017:
        { 
          term = is_deprecated_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1017;
          { 
            term = generated.const214;
            if(true)
              break Success397;
          }
        }
        term = generated.const166;
      }
      b_32767 = term;
      term = d_32767;
      Success398:
      { 
        Fail1018:
        { 
          term = is_completion_prefer_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1018;
          { 
            term = generated.const215;
            if(true)
              break Success398;
          }
        }
        term = generated.const166;
      }
      c_32767 = term;
      term = d_32767;
      Success399:
      { 
        Fail1019:
        { 
          term = is_completion_avoid_0_0.instance.invoke(context, term);
          if(term == null)
            break Fail1019;
          { 
            term = generated.const216;
            if(true)
              break Success399;
          }
        }
        term = generated.const166;
      }
      term = (IStrategoTerm)termFactory.makeListCons(b_32767, termFactory.makeListCons(c_32767, termFactory.makeListCons(term, (IStrategoList)generated.constNil3)));
      term = sum_0_0.instance.invoke(context, term);
      if(term == null)
        break Fail1016;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}