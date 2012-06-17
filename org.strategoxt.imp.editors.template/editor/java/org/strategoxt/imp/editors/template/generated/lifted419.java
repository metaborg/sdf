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

@SuppressWarnings("all") final class lifted419 extends Strategy 
{ 
  public static final lifted419 instance = new lifted419();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail1587:
    { 
      IStrategoTerm term546 = term;
      Success588:
      { 
        Fail1588:
        { 
          IStrategoTerm k_32779 = null;
          k_32779 = term;
          IStrategoTerm term547 = term;
          Success589:
          { 
            Fail1589:
            { 
              term = resolve_symbol_definition_0_0.instance.invoke(context, generated.const240);
              if(term == null)
                break Fail1589;
              { 
                if(true)
                  break Fail1588;
                if(true)
                  break Success589;
              }
            }
            term = term547;
          }
          term = k_32779;
          { 
            term = templatelang_index_option_0_0.instance.invoke(context, generated.const241);
            if(term == null)
              break Fail1587;
            term = templatelang_index_option_0_0.instance.invoke(context, generated.const242);
            if(term == null)
              break Fail1587;
            term = templatelang_index_option_0_0.instance.invoke(context, generated.const245);
            if(term == null)
              break Fail1587;
            if(true)
              break Success588;
          }
        }
        term = term546;
      }
      if(true)
        return term;
    }
    return null;
  }
}