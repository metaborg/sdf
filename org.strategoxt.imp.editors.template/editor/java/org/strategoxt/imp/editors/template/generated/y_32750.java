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

@SuppressWarnings("all") final class y_32750 extends Strategy 
{ 
  TermReference s_32749;

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1799:
    { 
      Success659:
      { 
        Fail1800:
        { 
          w_32750 w_327500 = new w_32750();
          w_327500.s_32749 = s_32749;
          term = w_327500.invoke(context, term);
          if(term == null)
            break Fail1800;
          { 
            Success660:
            { 
              Fail1801:
              { 
                x_32750 x_327500 = new x_32750();
                x_327500.s_32749 = s_32749;
                term = x_327500.invoke(context, term);
                if(term == null)
                  break Fail1801;
                { 
                  term = generated.const136;
                  if(true)
                    break Success660;
                }
              }
              term = generated.const127;
            }
            if(true)
              break Success659;
          }
        }
        term = generated.const138;
      }
      if(true)
        return term;
    }
    return null;
  }
}