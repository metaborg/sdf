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

@SuppressWarnings("all") public class $Ensure$Quotes_0_0 extends Strategy 
{ 
  public static $Ensure$Quotes_0_0 instance = new $Ensure$Quotes_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("EnsureQuotes_0_0");
    Fail350:
    { 
      IStrategoTerm j_9744 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)term).getConstructor())
        break Fail350;
      j_9744 = term.getSubterm(0);
      IStrategoTerm term359 = term;
      Success253:
      { 
        Fail351:
        { 
          term = un_double_quote_0_0.instance.invoke(context, j_9744);
          if(term == null)
            break Fail351;
          { 
            if(true)
              break Fail350;
            if(true)
              break Success253;
          }
        }
        term = term359;
      }
      term = double_quote_0_0.instance.invoke(context, j_9744);
      if(term == null)
        break Fail350;
      term = termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{term});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}