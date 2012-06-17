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
    Fail2017:
    { 
      TermReference d_33018 = new TermReference();
      if(d_33018.value == null)
        d_33018.value = term;
      else
        if(d_33018.value != term && !d_33018.value.match(term))
          break Fail2017;
      Success728:
      { 
        Fail2018:
        { 
          IStrategoTerm g_33018 = null;
          IStrategoTerm i_33018 = null;
          IStrategoTerm j_33018 = null;
          i_33018 = term;
          g_33018 = trans.const273;
          j_33018 = i_33018;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, j_33018, g_33018, trans.constCons84);
          if(term == null)
            break Fail2018;
          if(true)
            break Success728;
        }
        term = trans.constNil4;
      }
      lifted582 lifted5820 = new lifted582();
      lifted5820.d_33018 = d_33018;
      term = filter_1_0.instance.invoke(context, term, lifted5820);
      if(term == null)
        break Fail2017;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}