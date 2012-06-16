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

@SuppressWarnings("all") public class $Sdf$Desugar$Once_0_0 extends Strategy 
{ 
  public static $Sdf$Desugar$Once_0_0 instance = new $Sdf$Desugar$Once_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("SdfDesugarOnce_0_0");
    Fail347:
    { 
      IStrategoTerm term357 = term;
      Success251:
      { 
        Fail348:
        { 
          term = alltd_1_0.instance.invoke(context, term, $Ensure$Quotes_0_0.instance);
          if(term == null)
            break Fail348;
          term = term_1_0.instance.invoke(context, term, implode_aterm_0_0.instance);
          if(term == null)
            break Fail348;
          if(true)
            break Success251;
        }
        term = term357;
        IStrategoTerm term358 = term;
        IStrategoConstructor cons35 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
        Success252:
        { 
          if(cons35 == Main._conslit_1)
          { 
            Fail349:
            { 
              IStrategoTerm g_9744 = null;
              g_9744 = term.getSubterm(0);
              term = un_double_quote_0_0.instance.invoke(context, g_9744);
              if(term == null)
                break Fail349;
              term = termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{term});
              if(true)
                break Success252;
            }
            term = term358;
          }
          if(cons35 == Main._consci_lit_1)
          { 
            IStrategoTerm d_9744 = null;
            d_9744 = term.getSubterm(0);
            term = un_single_quote_0_0.instance.invoke(context, d_9744);
            if(term == null)
              break Fail347;
            term = termFactory.makeAppl(Main._consci_lit_1, new IStrategoTerm[]{term});
          }
          else
          { 
            break Fail347;
          }
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