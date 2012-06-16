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

@SuppressWarnings("all") public class bigbagof_$Is$Imported_0_0 extends Strategy 
{ 
  public static bigbagof_$Is$Imported_0_0 instance = new bigbagof_$Is$Imported_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    context.push("bigbagof_IsImported_0_0");
    Fail195:
    { 
      TermReference u_10735 = new TermReference();
      TermReference v_10735 = new TermReference();
      if(v_10735.value == null)
        v_10735.value = term;
      else
        if(v_10735.value != term && !v_10735.value.match(term))
          break Fail195;
      if(u_10735.value == null)
        u_10735.value = term;
      else
        if(u_10735.value != term && !u_10735.value.match(term))
          break Fail195;
      Success64:
      { 
        Fail196:
        { 
          IStrategoTerm z_10735 = null;
          z_10735 = term;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, z_10735, trans.const5, v_10735.value);
          if(term == null)
            break Fail196;
          if(true)
            break Success64;
        }
        term = trans.constNil0;
      }
      lifted62 lifted620 = new lifted62();
      lifted620.u_10735 = u_10735;
      lifted620.v_10735 = v_10735;
      term = filter_1_0.instance.invoke(context, term, lifted620);
      if(term == null)
        break Fail195;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}