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

@SuppressWarnings("all") public class list_to_conc_grammars_p__0_0 extends Strategy 
{ 
  public static list_to_conc_grammars_p__0_0 instance = new list_to_conc_grammars_p__0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("list_to_conc_grammars_p__0_0");
    Fail1131:
    { 
      IStrategoTerm term555 = term;
      Success477:
      { 
        Fail1132:
        { 
          IStrategoTerm j_32780 = null;
          IStrategoTerm k_32780 = null;
          IStrategoTerm l_32780 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail1132;
          l_32780 = ((IStrategoList)term).head();
          IStrategoTerm arg600 = ((IStrategoList)term).tail();
          if(arg600.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg600).isEmpty())
            break Fail1132;
          j_32780 = ((IStrategoList)arg600).head();
          k_32780 = ((IStrategoList)arg600).tail();
          IStrategoList list45;
          list45 = checkListTail(k_32780);
          if(list45 == null)
            break Fail1132;
          term = (IStrategoTerm)termFactory.makeListCons(j_32780, list45);
          term = this.invoke(context, term);
          if(term == null)
            break Fail1132;
          term = termFactory.makeAppl(Main._consconc_grammars_2, new IStrategoTerm[]{term, l_32780});
          if(true)
            break Success477;
        }
        term = term555;
        IStrategoTerm term556 = term;
        Success478:
        { 
          Fail1133:
          { 
            IStrategoTerm i_32780 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail1133;
            i_32780 = ((IStrategoList)term).head();
            IStrategoTerm arg601 = ((IStrategoList)term).tail();
            if(arg601.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg601).isEmpty())
              break Fail1133;
            term = i_32780;
            if(true)
              break Success478;
          }
          term = term556;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail1131;
          term = generated.constNil3;
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