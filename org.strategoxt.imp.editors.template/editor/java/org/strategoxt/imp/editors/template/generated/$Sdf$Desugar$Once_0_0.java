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
    Fail1167:
    { 
      IStrategoTerm term613 = term;
      Success507:
      { 
        Fail1168:
        { 
          term = alltd_1_0.instance.invoke(context, term, $Ensure$Quotes_0_0.instance);
          if(term == null)
            break Fail1168;
          term = term_1_0.instance.invoke(context, term, implode_aterm_0_0.instance);
          if(term == null)
            break Fail1168;
          if(true)
            break Success507;
        }
        term = term613;
        IStrategoTerm term614 = term;
        IStrategoConstructor cons47 = term.getTermType() == IStrategoTerm.APPL ? ((IStrategoAppl)term).getConstructor() : null;
        Success508:
        { 
          if(cons47 == Main._conslit_1)
          { 
            Fail1169:
            { 
              IStrategoTerm p_32782 = null;
              p_32782 = term.getSubterm(0);
              term = un_double_quote_0_0.instance.invoke(context, p_32782);
              if(term == null)
                break Fail1169;
              term = termFactory.makeAppl(Main._conslit_1, new IStrategoTerm[]{term});
              if(true)
                break Success508;
            }
            term = term614;
          }
          if(cons47 == Main._consci_lit_1)
          { 
            IStrategoTerm m_32782 = null;
            m_32782 = term.getSubterm(0);
            term = un_single_quote_0_0.instance.invoke(context, m_32782);
            if(term == null)
              break Fail1167;
            term = termFactory.makeAppl(Main._consci_lit_1, new IStrategoTerm[]{term});
          }
          else
          { 
            break Fail1167;
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