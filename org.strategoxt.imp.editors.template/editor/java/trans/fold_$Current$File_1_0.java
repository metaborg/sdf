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

@SuppressWarnings("all") public class fold_$Current$File_1_0 extends Strategy 
{ 
  public static fold_$Current$File_1_0 instance = new fold_$Current$File_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy h_10730)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_CurrentFile_1_0");
    Fail163:
    { 
      IStrategoTerm i_10730 = null;
      IStrategoTerm k_10730 = null;
      k_10730 = term;
      Success54:
      { 
        Fail164:
        { 
          IStrategoTerm l_10730 = null;
          IStrategoTerm n_10730 = null;
          IStrategoTerm o_10730 = null;
          n_10730 = term;
          l_10730 = trans.const3;
          o_10730 = n_10730;
          term = dr_lookup_rule_0_2.instance.invoke(context, o_10730, l_10730, trans.constCons0);
          if(term == null)
            break Fail164;
          if(true)
            break Success54;
        }
        term = trans.constNil0;
      }
      i_10730 = term;
      term = k_10730;
      term = termFactory.makeTuple(i_10730, term);
      term = h_10730.invoke(context, term, lifted50.instance);
      if(term == null)
        break Fail163;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}