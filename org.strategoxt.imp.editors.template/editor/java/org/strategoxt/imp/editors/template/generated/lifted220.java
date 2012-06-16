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

@SuppressWarnings("all") final class lifted220 extends Strategy 
{ 
  public static final lifted220 instance = new lifted220();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    Fail767:
    { 
      IStrategoTerm term290 = term;
      Success332:
      { 
        Fail768:
        { 
          IStrategoTerm b_9741 = null;
          b_9741 = term;
          IStrategoTerm term291 = term;
          Success333:
          { 
            Fail769:
            { 
              term = resolve_symbol_definition_0_0.instance.invoke(context, generated.const119);
              if(term == null)
                break Fail769;
              { 
                if(true)
                  break Fail768;
                if(true)
                  break Success333;
              }
            }
            term = term291;
          }
          term = b_9741;
          { 
            term = templatelang_index_option_0_0.instance.invoke(context, generated.const120);
            if(term == null)
              break Fail767;
            term = templatelang_index_option_0_0.instance.invoke(context, generated.const121);
            if(term == null)
              break Fail767;
            term = templatelang_index_option_0_0.instance.invoke(context, generated.const124);
            if(term == null)
              break Fail767;
            if(true)
              break Success332;
          }
        }
        term = term290;
      }
      if(true)
        return term;
    }
    return null;
  }
}