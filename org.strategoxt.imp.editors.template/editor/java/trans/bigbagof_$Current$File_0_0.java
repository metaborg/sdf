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

@SuppressWarnings("all") public class bigbagof_$Current$File_0_0 extends Strategy 
{ 
  public static bigbagof_$Current$File_0_0 instance = new bigbagof_$Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_CurrentFile_0_0");
    Fail169:
    { 
      TermReference n_10731 = new TermReference();
      if(n_10731.value == null)
        n_10731.value = term;
      else
        if(n_10731.value != term && !n_10731.value.match(term))
          break Fail169;
      Success57:
      { 
        Fail170:
        { 
          IStrategoTerm q_10731 = null;
          IStrategoTerm s_10731 = null;
          IStrategoTerm t_10731 = null;
          s_10731 = term;
          q_10731 = trans.const3;
          t_10731 = s_10731;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, t_10731, q_10731, trans.constCons0);
          if(term == null)
            break Fail170;
          if(true)
            break Success57;
        }
        term = trans.constNil0;
      }
      lifted53 lifted530 = new lifted53();
      lifted530.n_10731 = n_10731;
      term = filter_1_0.instance.invoke(context, term, lifted530);
      if(term == null)
        break Fail169;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}