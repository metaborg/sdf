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
    Fail1170:
    { 
      IStrategoTerm s_32782 = null;
      if(term.getTermType() != IStrategoTerm.APPL || Main._consquoted_1 != ((IStrategoAppl)term).getConstructor())
        break Fail1170;
      s_32782 = term.getSubterm(0);
      IStrategoTerm term615 = term;
      Success509:
      { 
        Fail1171:
        { 
          term = un_double_quote_0_0.instance.invoke(context, s_32782);
          if(term == null)
            break Fail1171;
          { 
            if(true)
              break Fail1170;
            if(true)
              break Success509;
          }
        }
        term = term615;
      }
      term = double_quote_0_0.instance.invoke(context, s_32782);
      if(term == null)
        break Fail1170;
      term = termFactory.makeAppl(Main._consquoted_1, new IStrategoTerm[]{term});
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}