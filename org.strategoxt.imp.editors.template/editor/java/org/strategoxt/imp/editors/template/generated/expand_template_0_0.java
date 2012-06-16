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

@SuppressWarnings("all") public class expand_template_0_0 extends Strategy 
{ 
  public static expand_template_0_0 instance = new expand_template_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("expand_template_0_0");
    Fail200:
    { 
      IStrategoTerm term196 = term;
      IStrategoConstructor cons16 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success144:
      { 
        if(cons16 == Main._consSingleLineTemplate_1)
        { 
          Fail201:
          { 
            IStrategoTerm c_9729 = null;
            c_9729 = term.getSubterm(0);
            term = listbu_1_0.instance.invoke(context, c_9729, expand_template_element_0_0.instance);
            if(term == null)
              break Fail201;
            if(true)
              break Success144;
          }
          term = term196;
        }
        if(cons16 == Main._consTemplate_1)
        { 
          IStrategoTerm y_9728 = null;
          y_9728 = term.getSubterm(0);
          term = listbu_1_0.instance.invoke(context, y_9728, expand_template_line_0_0.instance);
          if(term == null)
            break Fail200;
        }
        else
        { 
          break Fail200;
        }
      }
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}