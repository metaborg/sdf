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

@SuppressWarnings("all") public class $Current$File_0_0 extends Strategy 
{ 
  public static $Current$File_0_0 instance = new $Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("CurrentFile_0_0");
    Fail176:
    { 
      TermReference u_10732 = new TermReference();
      IStrategoTerm x_10732 = null;
      IStrategoTerm z_10732 = null;
      IStrategoTerm a_10733 = null;
      if(u_10732.value == null)
        u_10732.value = term;
      else
        if(u_10732.value != term && !u_10732.value.match(term))
          break Fail176;
      z_10732 = term;
      x_10732 = trans.const3;
      a_10733 = z_10732;
      term = dr_lookup_rule_0_2.instance.invoke(context, a_10733, x_10732, trans.constCons0);
      if(term == null)
        break Fail176;
      lifted57 lifted570 = new lifted57();
      lifted570.u_10732 = u_10732;
      term = fetch_elem_1_0.instance.invoke(context, term, lifted570);
      if(term == null)
        break Fail176;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}