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

@SuppressWarnings("all") public class bigfold_$Current$File_1_0 extends Strategy 
{ 
  public static bigfold_$Current$File_1_0 instance = new bigfold_$Current$File_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy v_10729)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("bigfold_CurrentFile_1_0");
    Fail161:
    { 
      IStrategoTerm w_10729 = null;
      IStrategoTerm y_10729 = null;
      y_10729 = term;
      Success53:
      { 
        Fail162:
        { 
          IStrategoTerm z_10729 = null;
          IStrategoTerm b_10730 = null;
          IStrategoTerm c_10730 = null;
          b_10730 = term;
          z_10729 = trans.const3;
          c_10730 = b_10730;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, c_10730, z_10729, trans.constCons0);
          if(term == null)
            break Fail162;
          if(true)
            break Success53;
        }
        term = trans.constNil0;
      }
      w_10729 = term;
      term = y_10729;
      term = termFactory.makeTuple(w_10729, term);
      term = v_10729.invoke(context, term, lifted49.instance);
      if(term == null)
        break Fail161;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}