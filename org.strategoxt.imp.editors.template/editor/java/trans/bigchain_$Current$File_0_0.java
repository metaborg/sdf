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

@SuppressWarnings("all") public class bigchain_$Current$File_0_0 extends Strategy 
{ 
  public static bigchain_$Current$File_0_0 instance = new bigchain_$Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigchain_CurrentFile_0_0");
    Fail165:
    { 
      IStrategoTerm t_10730 = null;
      IStrategoTerm v_10730 = null;
      v_10730 = term;
      Success55:
      { 
        Fail166:
        { 
          IStrategoTerm w_10730 = null;
          IStrategoTerm y_10730 = null;
          IStrategoTerm z_10730 = null;
          y_10730 = term;
          w_10730 = trans.const3;
          z_10730 = y_10730;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, z_10730, w_10730, trans.constCons0);
          if(term == null)
            break Fail166;
          if(true)
            break Success55;
        }
        term = trans.constNil0;
      }
      t_10730 = term;
      term = v_10730;
      term = termFactory.makeTuple(t_10730, term);
      term = foldl_1_0.instance.invoke(context, term, lifted51.instance);
      if(term == null)
        break Fail165;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}