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
    Fail1020:
    { 
      IStrategoTerm term452 = term;
      IStrategoConstructor cons28 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success400:
      { 
        if(cons28 == Main._consSingleLineTemplate_1)
        { 
          Fail1021:
          { 
            IStrategoTerm l_32767 = null;
            l_32767 = term.getSubterm(0);
            term = listbu_1_0.instance.invoke(context, l_32767, expand_template_element_0_0.instance);
            if(term == null)
              break Fail1021;
            if(true)
              break Success400;
          }
          term = term452;
        }
        if(cons28 == Main._consTemplate_1)
        { 
          IStrategoTerm h_32767 = null;
          h_32767 = term.getSubterm(0);
          term = listbu_1_0.instance.invoke(context, h_32767, expand_template_line_0_0.instance);
          if(term == null)
            break Fail1020;
        }
        else
        { 
          break Fail1020;
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