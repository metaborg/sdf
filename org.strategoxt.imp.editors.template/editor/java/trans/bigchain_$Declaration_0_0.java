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

@SuppressWarnings("all") public class bigchain_$Declaration_0_0 extends Strategy 
{ 
  public static bigchain_$Declaration_0_0 instance = new bigchain_$Declaration_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_Declaration_0_0");
    Fail139:
    { 
      IStrategoTerm s_10725 = null;
      IStrategoTerm t_10725 = null;
      IStrategoTerm x_10725 = null;
      IStrategoTerm z_10725 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail139;
      s_10725 = term.getSubterm(0);
      t_10725 = term.getSubterm(1);
      z_10725 = term;
      Success48:
      { 
        Fail140:
        { 
          IStrategoTerm a_10726 = null;
          IStrategoTerm c_10726 = null;
          IStrategoTerm d_10726 = null;
          c_10726 = term;
          a_10726 = trans.const0;
          d_10726 = c_10726;
          term = termFactory.annotateTerm(termFactory.makeTuple(s_10725, t_10725), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_all_rules_0_2.instance.invoke(context, d_10726, a_10726, term);
          if(term == null)
            break Fail140;
          if(true)
            break Success48;
        }
        term = trans.constNil0;
      }
      x_10725 = term;
      term = z_10725;
      term = termFactory.makeTuple(x_10725, term);
      term = foldl_1_0.instance.invoke(context, term, lifted42.instance);
      if(term == null)
        break Fail139;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}