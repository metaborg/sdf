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

@SuppressWarnings("all") public class chain_$Declaration_0_0 extends Strategy 
{ 
  public static chain_$Declaration_0_0 instance = new chain_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("chain_Declaration_0_0");
    Fail1989:
    { 
      IStrategoTerm x_33012 = null;
      IStrategoTerm y_33012 = null;
      IStrategoTerm c_33013 = null;
      IStrategoTerm e_33013 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail1989;
      x_33012 = term.getSubterm(0);
      y_33012 = term.getSubterm(1);
      e_33013 = term;
      Success720:
      { 
        Fail1990:
        { 
          IStrategoTerm f_33013 = null;
          IStrategoTerm h_33013 = null;
          IStrategoTerm i_33013 = null;
          h_33013 = term;
          f_33013 = trans.const269;
          i_33013 = h_33013;
          term = termFactory.annotateTerm(termFactory.makeTuple(x_33012, y_33012), checkListAnnos(termFactory, trans.constCons84));
          term = dr_lookup_rule_0_2.instance.invoke(context, i_33013, f_33013, term);
          if(term == null)
            break Fail1990;
          if(true)
            break Success720;
        }
        term = trans.constNil4;
      }
      c_33013 = term;
      term = e_33013;
      term = termFactory.makeTuple(c_33013, term);
      term = foldl_1_0.instance.invoke(context, term, lifted572.instance);
      if(term == null)
        break Fail1989;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}