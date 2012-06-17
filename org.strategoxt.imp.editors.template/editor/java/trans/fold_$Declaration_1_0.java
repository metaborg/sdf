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

@SuppressWarnings("all") public class fold_$Declaration_1_0 extends Strategy 
{ 
  public static fold_$Declaration_1_0 instance = new fold_$Declaration_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_33011)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_Declaration_1_0");
    Fail1985:
    { 
      IStrategoTerm s_33011 = null;
      IStrategoTerm t_33011 = null;
      IStrategoTerm y_33011 = null;
      IStrategoTerm a_33012 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1985;
      s_33011 = term.getSubterm(0);
      t_33011 = term.getSubterm(1);
      a_33012 = term;
      Success718:
      { 
        Fail1986:
        { 
          IStrategoTerm b_33012 = null;
          IStrategoTerm d_33012 = null;
          IStrategoTerm e_33012 = null;
          d_33012 = term;
          b_33012 = trans.const269;
          e_33012 = d_33012;
          term = termFactory.annotateTerm(termFactory.makeTuple(s_33011, t_33011), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_rule_0_2.instance.invoke(context, e_33012, b_33012, term);
          if(term == null)
            break Fail1986;
          if(true)
            break Success718;
        }
        term = trans.constNil4;
      }
      y_33011 = term;
      term = a_33012;
      term = termFactory.makeTuple(y_33011, term);
      term = x_33011.invoke(context, term, lifted570.instance);
      if(term == null)
        break Fail1985;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}