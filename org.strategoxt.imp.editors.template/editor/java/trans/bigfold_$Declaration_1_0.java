package trans;

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

@SuppressWarnings("all") public class bigfold_$Declaration_1_0 extends Strategy 
{ 
  public static bigfold_$Declaration_1_0 instance = new bigfold_$Declaration_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_33011)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_Declaration_1_0");
    Fail1983:
    { 
      IStrategoTerm c_33011 = null;
      IStrategoTerm d_33011 = null;
      IStrategoTerm i_33011 = null;
      IStrategoTerm k_33011 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1983;
      c_33011 = term.getSubterm(0);
      d_33011 = term.getSubterm(1);
      k_33011 = term;
      Success717:
      { 
        Fail1984:
        { 
          IStrategoTerm l_33011 = null;
          IStrategoTerm n_33011 = null;
          IStrategoTerm o_33011 = null;
          n_33011 = term;
          l_33011 = trans.const269;
          o_33011 = n_33011;
          term = termFactory.annotateTerm(termFactory.makeTuple(c_33011, d_33011), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_all_rules_0_2.instance.invoke(context, o_33011, l_33011, term);
          if(term == null)
            break Fail1984;
          if(true)
            break Success717;
        }
        term = trans.constNil4;
      }
      i_33011 = term;
      term = k_33011;
      term = termFactory.makeTuple(i_33011, term);
      term = h_33011.invoke(context, term, lifted569.instance);
      if(term == null)
        break Fail1983;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}