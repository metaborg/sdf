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
    Fail2013:
    { 
      IStrategoTerm j_33017 = null;
      IStrategoTerm l_33017 = null;
      l_33017 = term;
      Success726:
      { 
        Fail2014:
        { 
          IStrategoTerm m_33017 = null;
          IStrategoTerm o_33017 = null;
          IStrategoTerm p_33017 = null;
          o_33017 = term;
          m_33017 = trans.const273;
          p_33017 = o_33017;
          term = dr_lookup_all_rules_0_2.instance.invoke(context, p_33017, m_33017, trans.constCons84);
          if(term == null)
            break Fail2014;
          if(true)
            break Success726;
        }
        term = trans.constNil4;
      }
      j_33017 = term;
      term = l_33017;
      term = termFactory.makeTuple(j_33017, term);
      term = foldl_1_0.instance.invoke(context, term, lifted580.instance);
      if(term == null)
        break Fail2013;
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}