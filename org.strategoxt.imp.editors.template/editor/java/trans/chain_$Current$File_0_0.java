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

@SuppressWarnings("all") public class chain_$Current$File_0_0 extends Strategy 
{ 
  public static chain_$Current$File_0_0 instance = new chain_$Current$File_0_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("chain_CurrentFile_0_0");
    Fail167:
    { 
      IStrategoTerm e_10731 = null;
      IStrategoTerm g_10731 = null;
      g_10731 = term;
      Success56:
      { 
        Fail168:
        { 
          IStrategoTerm h_10731 = null;
          IStrategoTerm j_10731 = null;
          IStrategoTerm k_10731 = null;
          j_10731 = term;
          h_10731 = trans.const3;
          k_10731 = j_10731;
          term = dr_lookup_rule_0_2.instance.invoke(context, k_10731, h_10731, trans.constCons0);
          if(term == null)
            break Fail168;
          if(true)
            break Success56;
        }
        term = trans.constNil0;
      }
      e_10731 = term;
      term = g_10731;
      term = termFactory.makeTuple(e_10731, term);
      term = foldl_1_0.instance.invoke(context, term, lifted52.instance);
      if(term == null)
        break Fail167;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}