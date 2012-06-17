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

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy x_33016)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("fold_CurrentFile_1_0");
    Fail2011:
    { 
      IStrategoTerm y_33016 = null;
      IStrategoTerm a_33017 = null;
      a_33017 = term;
      Success725:
      { 
        Fail2012:
        { 
          IStrategoTerm b_33017 = null;
          IStrategoTerm d_33017 = null;
          IStrategoTerm e_33017 = null;
          d_33017 = term;
          b_33017 = trans.const273;
          e_33017 = d_33017;
          term = dr_lookup_rule_0_2.instance.invoke(context, e_33017, b_33017, trans.constCons84);
          if(term == null)
            break Fail2012;
          if(true)
            break Success725;
        }
        term = trans.constNil4;
      }
      y_33016 = term;
      term = a_33017;
      term = termFactory.makeTuple(y_33016, term);
      term = x_33016.invoke(context, term, lifted579.instance);
      if(term == null)
        break Fail2011;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}