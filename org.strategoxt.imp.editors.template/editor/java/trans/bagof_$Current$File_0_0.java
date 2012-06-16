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

@SuppressWarnings("all") public class bagof_$Current$File_0_0 extends Strategy 
{ 
  public static bagof_$Current$File_0_0 instance = new bagof_$Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bagof_CurrentFile_0_0");
    Fail174:
    { 
      TermReference n_10732 = new TermReference();
      if(n_10732.value == null)
        n_10732.value = term;
      else
        if(n_10732.value != term && !n_10732.value.match(term))
          break Fail174;
      Success59:
      { 
        Fail175:
        { 
          IStrategoTerm q_10732 = null;
          IStrategoTerm s_10732 = null;
          IStrategoTerm t_10732 = null;
          s_10732 = term;
          q_10732 = trans.const3;
          t_10732 = s_10732;
          term = dr_lookup_rule_0_2.instance.invoke(context, t_10732, q_10732, trans.constCons0);
          if(term == null)
            break Fail175;
          if(true)
            break Success59;
        }
        term = trans.constNil0;
      }
      lifted56 lifted560 = new lifted56();
      lifted560.n_10732 = n_10732;
      term = filter_1_0.instance.invoke(context, term, lifted560);
      if(term == null)
        break Fail174;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}