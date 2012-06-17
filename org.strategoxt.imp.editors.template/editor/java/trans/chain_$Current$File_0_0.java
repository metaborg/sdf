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
    Fail2015:
    { 
      IStrategoTerm u_33017 = null;
      IStrategoTerm w_33017 = null;
      w_33017 = term;
      Success727:
      { 
        Fail2016:
        { 
          IStrategoTerm x_33017 = null;
          IStrategoTerm z_33017 = null;
          IStrategoTerm a_33018 = null;
          z_33017 = term;
          x_33017 = trans.const273;
          a_33018 = z_33017;
          term = dr_lookup_rule_0_2.instance.invoke(context, a_33018, x_33017, trans.constCons84);
          if(term == null)
            break Fail2016;
          if(true)
            break Success727;
        }
        term = trans.constNil4;
      }
      u_33017 = term;
      term = w_33017;
      term = termFactory.makeTuple(u_33017, term);
      term = foldl_1_0.instance.invoke(context, term, lifted581.instance);
      if(term == null)
        break Fail2015;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}