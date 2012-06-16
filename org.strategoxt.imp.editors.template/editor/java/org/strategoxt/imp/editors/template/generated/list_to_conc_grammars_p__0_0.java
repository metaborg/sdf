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
    Fail311:
    { 
      IStrategoTerm term299 = term;
      Success221:
      { 
        Fail312:
        { 
          IStrategoTerm a_9742 = null;
          IStrategoTerm b_9742 = null;
          IStrategoTerm c_9742 = null;
          if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
            break Fail312;
          c_9742 = ((IStrategoList)term).head();
          IStrategoTerm arg447 = ((IStrategoList)term).tail();
          if(arg447.getTermType() != IStrategoTerm.LIST || ((IStrategoList)arg447).isEmpty())
            break Fail312;
          a_9742 = ((IStrategoList)arg447).head();
          b_9742 = ((IStrategoList)arg447).tail();
          IStrategoList list42;
          list42 = checkListTail(b_9742);
          if(list42 == null)
            break Fail312;
          term = (IStrategoTerm)termFactory.makeListCons(a_9742, list42);
          term = this.invoke(context, term);
          if(term == null)
            break Fail312;
          term = termFactory.makeAppl(Main._consconc_grammars_2, new IStrategoTerm[]{term, c_9742});
          if(true)
            break Success221;
        }
        term = term299;
        IStrategoTerm term300 = term;
        Success222:
        { 
          Fail313:
          { 
            IStrategoTerm z_9741 = null;
            if(term.getTermType() != IStrategoTerm.LIST || ((IStrategoList)term).isEmpty())
              break Fail313;
            z_9741 = ((IStrategoList)term).head();
            IStrategoTerm arg448 = ((IStrategoList)term).tail();
            if(arg448.getTermType() != IStrategoTerm.LIST || !((IStrategoList)arg448).isEmpty())
              break Fail313;
            term = z_9741;
            if(true)
              break Success222;
          }
          term = term300;
          if(term.getTermType() != IStrategoTerm.LIST || !((IStrategoList)term).isEmpty())
            break Fail311;
          term = generated.constNil0;
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