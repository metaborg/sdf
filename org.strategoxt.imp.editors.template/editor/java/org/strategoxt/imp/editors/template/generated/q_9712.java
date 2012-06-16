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

@SuppressWarnings("all") final class q_9712 extends Strategy 
{ 
  TermReference k_9711;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail979:
    { 
      Success403:
      { 
        Fail980:
        { 
          o_9712 o_97120 = new o_9712();
          o_97120.k_9711 = k_9711;
          term = o_97120.invoke(context, term);
          if(term == null)
            break Fail980;
          { 
            Success404:
            { 
              Fail981:
              { 
                p_9712 p_97120 = new p_9712();
                p_97120.k_9711 = k_9711;
                term = p_97120.invoke(context, term);
                if(term == null)
                  break Fail981;
                { 
                  term = generated.const15;
                  if(true)
                    break Success404;
                }
              }
              term = generated.const6;
            }
            if(true)
              break Success403;
          }
        }
        term = generated.const17;
      }
      if(true)
        return term;
    }
    return null;
  }
}