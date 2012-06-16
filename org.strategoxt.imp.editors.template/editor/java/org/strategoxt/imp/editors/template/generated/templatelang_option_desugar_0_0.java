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

@SuppressWarnings("all") public class templatelang_option_desugar_0_0 extends Strategy 
{ 
  public static templatelang_option_desugar_0_0 instance = new templatelang_option_desugar_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("templatelang_option_desugar_0_0");
    Fail274:
    { 
      IStrategoTerm term275 = term;
      IStrategoConstructor cons22 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
      Success200:
      { 
        if(cons22 == Main._consSeparator_1)
        { 
          Fail275:
          { 
            IStrategoTerm a_9739 = null;
            a_9739 = term.getSubterm(0);
            term = templatelang_origin_track_forced_1_0.instance.invoke(context, a_9739, lifted209.instance);
            if(term == null)
              break Fail275;
            term = termFactory.makeAppl(Main._consSeparator_1, new IStrategoTerm[]{term});
            if(true)
              break Success200;
          }
          term = term275;
        }
        if(cons22 == Main._consText_1)
        { 
          IStrategoTerm x_9738 = null;
          x_9738 = term.getSubterm(0);
          term = templatelang_origin_track_forced_1_0.instance.invoke(context, x_9738, lifted210.instance);
          if(term == null)
            break Fail274;
          term = termFactory.makeAppl(Main._consText_1, new IStrategoTerm[]{term});
        }
        else
        { 
          break Fail274;
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