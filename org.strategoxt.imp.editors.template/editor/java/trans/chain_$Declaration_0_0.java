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
    Fail141:
    { 
      IStrategoTerm h_10726 = null;
      IStrategoTerm i_10726 = null;
      IStrategoTerm m_10726 = null;
      IStrategoTerm o_10726 = null;
      if(term.getTermType() != IStrategoTerm.TUPLE || term.getSubtermCount() != 2)
        break Fail141;
      h_10726 = term.getSubterm(0);
      i_10726 = term.getSubterm(1);
      o_10726 = term;
      Success49:
      { 
        Fail142:
        { 
          IStrategoTerm p_10726 = null;
          IStrategoTerm r_10726 = null;
          IStrategoTerm s_10726 = null;
          r_10726 = term;
          p_10726 = trans.const0;
          s_10726 = r_10726;
          term = termFactory.annotateTerm(termFactory.makeTuple(h_10726, i_10726), checkListAnnos(termFactory, trans.constCons0));
          term = dr_lookup_rule_0_2.instance.invoke(context, s_10726, p_10726, term);
          if(term == null)
            break Fail142;
          if(true)
            break Success49;
        }
        term = trans.constNil0;
      }
      m_10726 = term;
      term = o_10726;
      term = termFactory.makeTuple(m_10726, term);
      term = foldl_1_0.instance.invoke(context, term, lifted43.instance);
      if(term == null)
        break Fail141;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}